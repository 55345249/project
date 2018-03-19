package com.primeton.controller;

import com.primeton.build.ApplicationServer;
import com.primeton.domain.Img;
import com.primeton.service.impl.ImgServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Scope;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@EnableAutoConfiguration
public class TestControler{
    @Autowired
    private ImgServiceImpl imgService;

    private String str="1111";
    public static final Logger logger = LoggerFactory.getLogger(ApplicationServer.class);

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

    @RequestMapping("/")
    public ModelAndView login(){
        System.out.println("4444");
        ModelAndView mv=new ModelAndView("login.jsp");
        return mv;
    }

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

}
