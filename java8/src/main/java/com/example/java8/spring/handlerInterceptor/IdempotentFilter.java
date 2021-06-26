//package com.example.java8.spring.handlerInterceptor;
//
//import com.alibaba.fastjson.JSONArray;
//import com.alibaba.fastjson.JSONException;
//import com.alibaba.fastjson.JSONObject;
//import org.apache.commons.lang.StringUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.util.DigestUtils;
//import org.springframework.web.method.HandlerMethod;
//import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
//import redis.clients.jedis.JedisCluster;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.lang.reflect.Method;
//import java.util.Arrays;
//import java.util.Objects;
//import java.util.regex.Pattern;
//
//public class IdempotentFilter extends HandlerInterceptorAdapter {
//	private final Logger logger = LoggerFactory.getLogger(IdempotentFilter.class);
//	private static final String IDEMPOTENT = "idempotent.info";
//	private static final String NAMESPACE = "idempotent";
//	private static final String NAMESPACE_LOCK = "idempotent.lock";
//	@Override
//	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
//			throws Exception {
//		logger.info("request请求地址path[{}] uri[{}]", request.getServletPath(),request.getRequestURI());
//		HandlerMethod handlerMethod = (HandlerMethod) handler;
//		Method method = handlerMethod.getMethod();
//		Idempotent ra = method.getAnnotation(Idempotent.class);
//		if (Objects.nonNull(ra)) {
//			logger.debug("Start doIdempotent");
//			int liveTime = getIdempotentLockExpiredTime(ra);
//			String key = generateKey(request, ra);
//			logger.debug("Finish generateKey:[{}]",key);
//			JedisCluster jedisCluster = getJedisCluster();
//			//上分布式锁 避免相同的请求同时进入调用jedisCluster.get(key) 都为null的情况
//			new SimpleLock(NAMESPACE_LOCK + key,jedisCluster).wrap(new Runnable() {
//				@Override
//				public void run() {
//					//判断key是否存在，如存在抛出重复提交异常，如果不存在 则新增
//					if (jedisCluster.get(key) == null){
//						jedisCluster.setex(key,liveTime,"true");
//						request.setAttribute(IDEMPOTENT, key);
//					}else {
//						logger.debug("the key exist : {}, will be expired after {} mils if not be cleared", key, liveTime);
//						try {
//							throw new Exception("请勿重复提交");
//						} catch (Exception e) {
//							e.printStackTrace();
//						}
//					}
//				}
//			});
//		}
//		return true;
//	}
//
//	private int getIdempotentLockExpiredTime(Idempotent ra)
//	{
//		return ra.expiredTime();
//	}
//
//	@Override
//	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
//						   ModelAndView modelAndView) throws Exception {}
//
//	@Override
//	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
//			throws Exception {
//		try
//		{
//			//业务处理完成 删除redis中的key
//			afterIdempotent(request);
//		}
//		catch (Exception e)
//		{
//			// ignore it when exception
//			logger.error("Error after @Idempotent", e);
//		}
//	}
//
//	private void afterIdempotent(HttpServletRequest request) throws IOException
//	{
//		Object obj = request.getAttribute(IDEMPOTENT);
//		if (obj != null){
//			logger.debug("Start afterIdempotent");
//			String key =  obj.toString();
//			JedisCluster jedisCluster = getJedisCluster();
//			if (StringUtils.isNotBlank(key) && jedisCluster.del(key) == 0)
//			{
//				logger.debug("afterIdempotent error Prepared to delete the key:[{}] ",key);
//			}
//
//			logger.debug("End afterIdempotent");
//		}
//	}
//
//	/**
//	 * generate key
//	 *
//	 * @param request
//	 * @param ra
//	 * @return
//	 */
//	public String generateKey(HttpServletRequest request, Idempotent ra)
//	{
//		String requestURI = request.getRequestURI();
//		String requestMethod = request.getMethod();
//		StringBuilder result = new StringBuilder(NAMESPACE);
//		String token = request.getHeader("H-User-Token");
//		append(result, requestURI);
//		append(result, requestMethod);
//		append(result, token);
//		appendBodyData( request, result, ra);
//		logger.debug("The raw data to be generated key: {}", result.toString());
//		return DigestUtils.sha1Hex(result.toString());
//	}
//
//	private void appendBodyData(HttpServletRequest request,  StringBuilder src,
//								Idempotent ra)
//	{
//		if (Objects.nonNull(ra))
//		{
//			boolean shouldHashBody = (boolean) ra.body();
//			logger.debug("Found attr for body in @Idempotent, the value is {}", shouldHashBody);
//			if (shouldHashBody)
//			{
//				String data = null;
//				try {
//					data = HttpHelper.getBodyString(new RequestReaderHttpServletRequestWrapper(request));
//				} catch (IOException e) {
//					logger.warn("Found attr for body in @Idempotent, but the body is blank");
//					return;
//				}
//				if (StringUtils.isBlank(data))
//				{
//					logger.warn("Found attr for body in @Idempotent, but the body is blank");
//					return;
//				}
//				String[] bodyVals = ra.bodyVals();
//				// bodyVals优先
//				if (Objects.nonNull(bodyVals) && bodyVals.length != 0)
//				{
//					logger.debug("Found attr for bodyVals in @Idempotent, the value is {}", Arrays.asList(bodyVals));
//
//					final String finalData = data;
//					Arrays.asList(bodyVals).stream().sorted().forEach(e -> {
//						String val = getEscapedVal(finalData, e);
//						append(src, val);
//					});
//				}
//				else
//				{
//					append(src, data);
//				}
//			}
//		}
//	}
//
//	private String getEscapedVal(String json, String path)
//	{
//		String[] paths = path.split(":");
//		JSONObject jsonObject = null;
//		JSONArray jsonArray = null;
//		String nodeVal = json;
//		for (String fieldName : paths)
//		{
//			if (isInteger(fieldName)){
//				try {
//					jsonArray = JSONObject.parseArray(nodeVal);
//					nodeVal= jsonArray.get(Integer.parseInt(fieldName)).toString();
//				} catch (JSONException e) {//如果无法转为jsonArray 则说明不是数组尝试转为jsonObject去取值
//					logger.warn("getEscapedVal JSONObject.parseArray error nodeVal:[{}] fieldName:[{}]",nodeVal,nodeVal);
//					jsonObject = JSONObject.parseObject(nodeVal);
//					nodeVal = jsonObject.get(fieldName).toString();
//				}
//			}else {
//				jsonObject = JSONObject.parseObject(nodeVal);
//				nodeVal = jsonObject.get(fieldName).toString();
//			}
//
//		}
//		return nodeVal;
//	}
//
//	public static boolean isInteger(String str) {
//		Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
//		return pattern.matcher(str).matches();
//	}
//
//	private void append(StringBuilder src, String str)
//	{
//		if (!StringUtils.isBlank(str))
//		{
//			src.append("#").append(str);
//		}
//	}
//	//手动注入
//	public JedisCluster getJedisCluster() {
//		return SpringContextUtil.getBean(JedisCluster.class);
//	}
//}
