package com.primeton.build;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@MapperScan("com.primeton.mapper")
@ServletComponentScan(value = "com")
public class ApplicationServer {
    //11111
    public static void main(String args[]) {
        SpringApplication.run(ApplicationServer.class,args);
    }
}
