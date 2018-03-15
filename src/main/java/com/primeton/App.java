package com.primeton;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@MapperScan("com.primeton.mapper")
@ServletComponentScan(value = "com")
public class App {
    //teststsets
    public static void main(String args[]) {
        SpringApplication.run(App.class,args);
    }
}