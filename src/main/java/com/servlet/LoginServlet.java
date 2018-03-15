package com.servlet;

import com.jwt.Jwt;
import net.minidev.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = "/servlet/login",loadOnStartup = 1)
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 5285600116871825644L;

    //校验用户名密码
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username=request.getParameter("username");
        String password =request.getParameter("password");
        JSONObject resultJSON=new JSONObject();

        //用户名密码校验成功后，生成token返回客户端
        if("admin".equals(username)&&"123".equals(password)){
            //生成token
            Map<String , Object> payload=new HashMap<String, Object>();
            Date date=new Date();
            payload.put("uid", "admin");//用户ID
            payload.put("iat", date.getTime());//生成时间
            payload.put("ext",date.getTime()+1000*60*60*24*30);//过期时间30天
            String token= Jwt.createToken(payload);

            resultJSON.put("success", true);
            resultJSON.put("msg", "登陆成功");
            resultJSON.put("token", token);

        }else{
            resultJSON.put("success", false);
            resultJSON.put("msg", "用户名或密码不对");
        }
        //输出结果
        output(resultJSON.toJSONString(), response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        this.doGet(request,response);
    }
    public void output(String jsonStr,HttpServletResponse response) throws IOException{
        response.setContentType("text/html;charset=UTF-8;");
        PrintWriter out = response.getWriter();
System.out.println("jsonStr=" + jsonStr);
        out.println(jsonStr);
        out.flush();
        out.close();
    }
}
