package com.primeton.controller.filter;

import com.primeton.utils.CookiesUtil;
import com.thetransactioncompany.cors.CORSConfiguration;
import com.thetransactioncompany.cors.CORSFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

//服务端跨域处理过滤器,该过滤器需要依赖cors-filter-2.2.1.jar和java-property-utils-1.9.1.jar

@WebFilter(urlPatterns = {"/*"}, asyncSupported = true,
        initParams = {
                @WebInitParam(name = "cors.allowOrigin", value = "*"),
                @WebInitParam(name = "cors.supportedMethods", value = "CONNECT, DELETE, GET, HEAD, OPTIONS, POST, PUT, TRACE"),
                @WebInitParam(name = "cors.supportedHeaders", value = "token,Accept, Origin, X-Requested-With, Content-Type, Last-Modified"),//注意，如果token字段放在请求头传到后端，这里需要配置
                @WebInitParam(name = "cors.exposedHeaders", value = "Set-Cookie"),
                @WebInitParam(name = "cors.supportsCredentials", value = "true"),
                @WebInitParam(name = "ignores", value = "*.js,*.css,*.png,*.jpg,*.gif,/login_new.html,/servlet/login")
        })
public class Filter0_CrossOriginResource extends CORSFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(Filter0_CrossOriginResource.class );

    private Set<String> prefixIignores = new HashSet<String>();

    @Override
    public void init(FilterConfig config) throws ServletException {
        logger.info("跨域资源处理过滤器初始化.begin……");
        super.init(config);
        String ignoresParam = config.getInitParameter("ignores");
        String[] ignoreArray = ignoresParam.split(",");
        for (String s : ignoreArray) {
            prefixIignores.add(s);
        }
        logger.info("跨域资源处理过滤器初始化.end");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //logger.info("跨域过滤器");
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        //是否静态的，是静态的，直接放过。
        if (canIgnore(req)) {
            chain.doFilter(request, response);
            return;
        } else {
            //String token = req.getHeader("token");
            String token = "";
            /*Cookie[] cookie = req.getCookies();
            if (cookie != null && cookie.length > 0) {

                for (int i = 0; i < cookie.length; i++) {
                    Cookie cook = cookie[i];
                    if (cook.getName().equalsIgnoreCase("token")) { //获取键
                        System.out.println("token:" + cook.getValue().toString());    //获取值
                        token = cook.getValue().toString();
                    }
                }
            }*/
            //String token = req.getCookies("token").value();
            Cookie cookie = CookiesUtil.getCookieByName(req,"token");
            if (cookie != null){
                token = cookie.getValue();
            }
            logger.info("全局过滤器中获取的token=" + token);

            if (null == token || "".equals(token)) {
                token = req.getHeader("token");
                if (null == token || "".equals(token)) {
                    res.sendRedirect("/login_new.html");
                    return;
                }
            }

            super.doFilter(request, response, chain);
        }
    }

    @Override
    public void destroy() {

    }

    public void setConfiguration(CORSConfiguration config) {
        super.setConfiguration(config);
    }

    private boolean canIgnore(HttpServletRequest request) {
        String url = request.getRequestURI();
        for (String ignore : prefixIignores) {
            if (url.endsWith(ignore.replace("*", ""))) {
                return true;
            }
        }
        return false;
    }
}
