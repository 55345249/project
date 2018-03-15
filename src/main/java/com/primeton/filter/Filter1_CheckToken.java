package com.filter;

import com.jwt.Jwt;
import com.jwt.TokenState;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

//toekn校验过滤器，所有的API接口请求都要经过该过滤器(除了登陆接口)
@WebFilter("/servlet/*")
public class Filter1_CheckToken  implements Filter {

    @Override
    public void doFilter(ServletRequest arg0, ServletResponse arg1,
                         FilterChain chain ) throws IOException, ServletException {
        HttpServletRequest request=(HttpServletRequest) arg0;
        HttpServletResponse response=(HttpServletResponse) arg1;
//		response.setHeader("Access-Control-Allow-Origin", "*");
//System.out.println("请求URL："+ request.getRequestURI());
        if(request.getRequestURI().endsWith("/servlet/login")){
            //登陆接口不校验token，直接放行
            chain.doFilter(request, response);
            return;
        }
        //其他API接口一律校验token
        System.out.println("开始校验token");
        //从请求头中获取token
        String token=request.getHeader("token");
        Map<String, Object> resultMap= Jwt.validToken(token);
        TokenState state=TokenState.getTokenState((String)resultMap.get("state"));
        switch (state) {
            case VALID:
                //取出payload中数据,放入到request作用域中
                request.setAttribute("data", resultMap.get("data"));
                //放行
                chain.doFilter(request, response);
                break;
            case EXPIRED:
            case INVALID:
                System.out.println("无效token");
                //token过期或者无效，则输出错误信息返回给ajax
                JSONObject outputMsg = new JSONObject();
                outputMsg.put("success", false);
                outputMsg.put("msg", "您的token不合法或者过期了，请重新登陆");
                output(outputMsg.toJSONString(), response);
                break;
        }
    }

    public void output(String jsonStr,HttpServletResponse response) throws IOException{
        response.setContentType("text/html;charset=UTF-8;");
        PrintWriter out = response.getWriter();
//		out.println();
        out.write(jsonStr);
        out.flush();
        out.close();
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
        System.out.println("token过滤器初始化了");
    }

    @Override
    public void destroy() {

    }
}
