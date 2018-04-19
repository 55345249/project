package com.primeton.build;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ServletComponentScan("com.primeton")
@ComponentScan("com.primeton")
@MapperScan("com.primeton")
public class ApplicationServer {
    public static void main(String args[]) {
        SpringApplication.run(ApplicationServer.class,args);
    }
}
