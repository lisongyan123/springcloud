# zuul + config client 动态配置路由

## filter会在请求的时候从请求中读取token字段，如果通过了，则可以进行下一步请求，否则返回失败
```thymeleafexpressions

import com.alibaba.druid.util.StringUtils;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;

@Slf4j
@Component
public class TokenFilter extends ZuulFilter {

    /**
     * 过滤器的类型，它决定过滤器在请求的哪个生命周期中执行。
     * 这里定义为pre，代表会在请求被路由之前执行。
     *
     * @return
     */
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    /**
     * filter执行顺序，通过数字指定。
     * 数字越大，优先级越低。
     *
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 判断该过滤器是否需要被执行。这里我们直接返回了true，因此该过滤器对所有请求都会生效。
     * 实际运用中我们可以利用该函数来指定过滤器的有效范围。
     * true执行过滤器，false不执行过滤器·
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器的具体逻辑
     *
     * @return
     */
    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info("进入访问过滤器，访问的url：【{}】，访问的方法：【{}】",request.getRequestURL(),request.getMethod());
        String token = request.getParameter("token");
        String accessToken = request.getHeader("accessToken");
        if (token == null || token.isEmpty() || StringUtils.isEmpty(accessToken)) {
            log.info("当前请求没有accessToken和token");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            ctx.setResponseBody("token and accessToken is empty");
        }
        log.info("请求通过过滤器");
        return null;
    }
}
```
## 启动类
```markdown
@EnableZuulProxy
@SpringBootApplication

public class ZuulApplication {
    public static void main(String[] args) {SpringApplication.run(ZuulApplication.class, args);}
    @Bean
    @RefreshScope
    @ConfigurationProperties("zuul")
    @Primary //必须
    public ZuulProperties zuulProperties(){
        return new ZuulProperties();
    }
}
```

## 具体内容参考博客 ： https://blog.csdn.net/qq_41211642/article/details/104889642