package com.filter;

import com.thetransactioncompany.cors.CORSConfiguration;
import com.thetransactioncompany.cors.CORSFilter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

//服务端跨域处理过滤器,该过滤器需要依赖cors-filter-2.2.1.jar和java-property-utils-1.9.1.jar

@WebFilter(urlPatterns={"/*"},asyncSupported=true,
initParams={
        @WebInitParam(name="cors.allowOrigin",value="*"),
        @WebInitParam(name="cors.supportedMethods",value="CONNECT, DELETE, GET, HEAD, OPTIONS, POST, PUT, TRACE"),
        @WebInitParam(name="cors.supportedHeaders",value="token,Accept, Origin, X-Requested-With, Content-Type, Last-Modified"),//注意，如果token字段放在请求头传到后端，这里需要配置
        @WebInitParam(name="cors.exposedHeaders",value="Set-Cookie"),
        @WebInitParam(name="cors.supportsCredentials",value="true")
})
public class Filter0_CrossOriginResource extends CORSFilter implements Filter{
    public void init(FilterConfig config) throws ServletException {
        System.out.println("跨域资源处理过滤器初始化了");
        super.init(config);
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("跨域过滤器");
        super.doFilter(request, response, chain);
    }

    @Override
    public void destroy() {

    }


    public void setConfiguration(CORSConfiguration config) {
        super.setConfiguration(config);
    }
}
