package com.controlcenter;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/all")
public class TestControler {
    @RequestMapping("/hell")
    String hello(){
        return "hello,spring boot";
    }

    @RequestMapping("/say/{name}")
    String say(@PathVariable String name){
        return "say"+name;
    }


}
