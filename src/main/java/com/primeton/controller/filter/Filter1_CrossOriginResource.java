package com.primeton.controller.filter;

import com.thetransactioncompany.cors.CORSConfiguration;
import com.thetransactioncompany.cors.CORSFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
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
                @WebInitParam(name = "ignores", value = "*.js,*.css,*.png,*.jpg,*.gif,/login.html,/servlet/login")
        })
public class Filter1_CrossOriginResource extends CORSFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(Filter0_CheckToken.class);

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

        logger.info("跨域过滤器");
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;


        //是否静态的，是静态的，直接放过。
        if (canIgnore(req)) {
            chain.doFilter(request, response);
            return;
        } else {
            String token = req.getHeader("token");
            logger.info("全局过滤器中获取的token=" + token);
            if (token == null) {
                res.sendRedirect("/login.html");
                //req.getRequestDispatcher("/login.html");
                return;
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
        //System.out.println("url------------->"+url);
        for (String ignore : prefixIignores) {
            if (url.endsWith(ignore.replace("*", ""))) {
                return true;
            }
        }
        return false;
    }
}
