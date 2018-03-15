package com.primeton.controller;


import com.primeton.bean.Img;
import com.primeton.service.ImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@EnableAutoConfiguration
public class TestControler{
    @Autowired
    private ImgService imgService;

    private String str="1111";


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
        return "hello,spring boot";
    }

    @RequestMapping("/say/{name}")
    String say(@PathVariable String name){
        return "say"+name;
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }


}
