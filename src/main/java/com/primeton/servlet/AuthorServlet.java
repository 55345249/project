package com.primeton.servlet;

import com.primeton.jwt.Jwt;
import net.minidev.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns="/author/token",loadOnStartup=1,description="生成token的方法")
public class AuthorServlet extends HttpServlet{
    //private static final long serialVersionUID = -8463692428988705309L;
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String token=request.getHeader("token");
System.out.println("token : " + token);
        Map<String, Object> result= Jwt.validToken(token);
        //转JSON并输出
        PrintWriter out = response.getWriter();
        /*JSONObject resp=new JSONObject();
        resp.put("msg", "成功");
        resp.put("result", result);*/

        out.println(new JSONObject(result).toJSONString());
        //out.println(resp.toJSONString());
        out.flush();
        out.close();
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request,response);
    }
    public void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Map<String , Object> payload=new HashMap<String, Object>();
        Date date=new Date();
        payload.put("uid", "291969452");//用户id
        payload.put("iat", date.getTime());//生成时间
        payload.put("ext",date.getTime()+60*60*24*30);//过期时间30天
        String token=null;
        token=Jwt.createToken(payload);

        response.setContentType("text/html;charset=UTF-8;");
        Cookie cookie=new Cookie("token", token);
        cookie.setMaxAge(3600);//单位为秒 过期时间为1小时
        response.addCookie(cookie);
        PrintWriter out = response.getWriter();
        out.println(token);
        out.flush();
        out.close();
    }
}
