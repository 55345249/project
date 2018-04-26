package com.primeton.controller;

import com.primeton.domain.Img;
import com.primeton.domain.CapUser;
import com.primeton.service.impl.ImgServiceImpl;
import com.primeton.service.impl.UserServiceImpl;
import com.primeton.utils.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

@RestController
@EnableAutoConfiguration
public class TestControler{
    @Autowired
    private ImgServiceImpl imgService;
    @Autowired
    private UserServiceImpl userService;
    private String str="1111";
    private static final Logger logger = LoggerFactory.getLogger(TestControler.class);

    @RequestMapping("/selectImg")
    public List<Img> selectImg1(){
        return imgService.selectImg1();
    }

    @RequestMapping("/selectImg/{describe}")
    public List<Img> selectImg(@PathVariable("describe") String describe){
        System.out.print(describe);
        return imgService.selectImg(describe);
    }


    @RequestMapping("/hell")
    @Scope(value="prototype")
    String hello(){
        System.out.println("被调用"+str);
        str="5555";
        logger.info("日志输出测试INFO");
        return "hello,spring boot";
    }

    @RequestMapping("/say/{name}")
    String say(@PathVariable String name){
        return "say"+name;
    }

/*    @RequestMapping("/")
    public ModelAndView login(){
        System.out.println("4444");
        ModelAndView mv=new ModelAndView("indexNew.jsp");
        return mv;
    }*/

    @RequestMapping("/insert")
    public void insertImg(){
        Img img=new Img("3","png","fffffff");
        imgService.insert(img);
    }

    @RequestMapping("del")
    public void del(){
        String id="1";
        imgService.del(id);
    }

    @RequestMapping("/main")
    public void main(HttpServletResponse response) {
        try {
            response.sendRedirect("/main.html");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
