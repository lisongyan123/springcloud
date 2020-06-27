package com.example.cloudservice.service.impl;

import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.poi.excel.BigExcelWriter;
import cn.hutool.poi.excel.ExcelUtil;
import com.alibaba.fastjson.JSONObject;
import com.example.cloudservice.common.util.StringUtil;
import com.example.cloudservice.dao.LogDao;
import com.example.cloudservice.domain.vo.LogExample;
import com.example.cloudservice.service.LogService;
import com.github.pagehelper.PageInfo;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.lionsoul.ip2region.DataBlock;
import org.lionsoul.ip2region.DbConfig;
import org.lionsoul.ip2region.DbSearcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.io.*;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import cn.hutool.core.io.resource.ClassPathResource;
import javax.servlet.ServletOutputStream;
import java.io.IOException;
import com.example.cloudservice.domain.vo.Log;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class LogServiceImpl implements LogService {

    @Resource
    private LogDao logDao;

    @Override
    public Object queryAll(int pageNum, int size){
        PageInfo pageInfo = new PageInfo();
        pageInfo.setPageNum(pageNum);
        pageInfo.setSize(size);
        return new PageInfo<>(queryAll());
    }

    @Override
    public List<Log> queryAll() {
        LogExample logExample = new LogExample();
        return logDao.selectByExample(logExample);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(String username, String browser, String ip, ProceedingJoinPoint joinPoint, Log log) throws Exception {

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        com.example.cloudservice.common.log.Log aopLog = method.getAnnotation(com.example.cloudservice.common.log.Log.class);

        // 方法路径
        String methodName = joinPoint.getTarget().getClass().getName()+"."+signature.getName()+"()";

        StringBuilder params = new StringBuilder("{");
        //参数值
        Object[] argValues = joinPoint.getArgs();
        //参数名称
        String[] argNames = ((MethodSignature)joinPoint.getSignature()).getParameterNames();
        if(argValues != null){
            for (int i = 0; i < argValues.length; i++) {
                params.append(" ").append(argNames[i]).append(": ").append(argValues[i]);
            }
        }
        // 描述
        if (log != null) {
            log.setDescription(aopLog.value());
        }
        assert log != null;
        log.setRequestIp(ip);

        String loginPath = "login";
        if(loginPath.equals(signature.getName())){
            try {
                assert argValues != null;
                username = new JSONObject((Map<String, Object>) argValues[0]).get("username").toString();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        /**
         * 根据ip获取详细地址
         */
        log.setAddress(getCityInfo(log.getRequestIp()));
        log.setMethod(methodName);
        log.setUsername(username);
        log.setParams(params.toString() + " }");
        log.setBrowser(browser);
        if(logDao.insert(log) != 1) throw new Exception("添加log失败");
    }

    /**
     * 根据ip获取详细地址
     */
    public static String getCityInfo(String ip) {
        DbSearcher searcher = null;
        try {
            String path = "ip2region/ip2region.db";
            String name = "ip2region.db";
            DbConfig config = new DbConfig();
            File file = inputStreamToFile(new ClassPathResource(path).getStream(), name);
            searcher = new DbSearcher(config, file.getPath());
            Method method;
            method = searcher.getClass().getMethod("btreeSearch", String.class);
            DataBlock dataBlock;
            dataBlock = (DataBlock) method.invoke(searcher, ip);
            String address = dataBlock.getRegion().replace("0|","");
            char symbol = '|';
            if(address.charAt(address.length()-1) == symbol){
                address = address.substring(0,address.length() - 1);
            }
            return address.equals(ElAdminConstant.REGION)?"内网IP":address;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(searcher!=null){
                try {
                    searcher.close();
                } catch (IOException ignored) {
                }
            }

        }
        return "";
    }

    /**
     * inputStream 转 File
     */
    static File inputStreamToFile(InputStream ins, String name) throws Exception{
        File file = new File(System.getProperty("java.io.tmpdir") + File.separator + name);
        if (file.exists()) {
            return file;
        }
        OutputStream os = new FileOutputStream(file);
        int bytesRead;
        int len = 8192;
        byte[] buffer = new byte[len];
        while ((bytesRead = ins.read(buffer, 0, len)) != -1) {
            os.write(buffer, 0, bytesRead);
        }
        os.close();
        ins.close();
        return file;
    }


    @Override
    public Object findByErrDetail(Long id) {
        LogExample logExample = new LogExample();
        logExample.createCriteria().andIdEqualTo(id);
        Log log = logDao.selectByPrimaryKey(id);
        String details = log.getExceptionDetail();
        return details;
    }

    @Override
    public void download(List<Log> logs, HttpServletResponse response) throws IOException {
        List<Map<String, Object>> list = new ArrayList<>();
        for (Log log : logs) {
            Map<String,Object> map = new LinkedHashMap<>();
            map.put("用户名", log.getUsername());
            map.put("IP", log.getRequestIp());
            map.put("IP来源", log.getAddress());
            map.put("描述", log.getDescription());
            map.put("浏览器", log.getBrowser());
            map.put("请求耗时/毫秒", log.getTime());
            map.put("异常详情", new String(StringUtil.isEmpty(log.getExceptionDetail()) ? log.getExceptionDetail() : ""));
            map.put("创建日期", log.getCreateTime());
            list.add(map);
        }
        downloadExcel(list, response);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delAllByType(String type) throws Exception {
        LogExample logExample = new LogExample();
        logExample.createCriteria().andLogTypeEqualTo(type);
        if(logDao.deleteByExample(logExample) != 1) throw new Exception("删除失败");
    }

    public void downloadExcel(List<Map<String, Object>> list, HttpServletResponse response) throws IOException {
        String tempPath =System.getProperty("java.io.tmpdir") + IdUtil.fastSimpleUUID() + ".xlsx";
        File file = new File(tempPath);
        BigExcelWriter writer= ExcelUtil.getBigWriter(file);
        // 一次性写出内容，使用默认样式，强制输出标题
        writer.write(list, true);
        //response为HttpServletResponse对象
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
        //test.xls是弹出下载对话框的文件名，不能为中文，中文请自行编码
        response.setHeader("Content-Disposition","attachment;filename=file.xlsx");
        ServletOutputStream out=response.getOutputStream();
        // 终止后删除临时文件
        file.deleteOnExit();
        writer.flush(out, true);
        //此处记得关闭输出Servlet流
        IoUtil.close(out);
    }

    /**
     * 常用静态常量
     * @author Zheng Jie
     * @date 2018-12-26
     */
    public static class ElAdminConstant {

        public static final String RESET_PASS = "重置密码";

        public static final String RESET_MAIL = "重置邮箱";

        /**
         * 用于IP定位转换
         */
        static final String REGION = "内网IP|内网IP";

        /**
         * 常用接口
         */
        public static class Url{
            public static final String SM_MS_URL = "https://sm.ms/api";
        }
    }
}
