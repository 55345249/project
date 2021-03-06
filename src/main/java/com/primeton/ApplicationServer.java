package com.primeton;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.primeton.repository")
@ServletComponentScan(value = "com")
public class ApplicationServer {
    public static void main(String args[]) {
        SpringApplication.run(ApplicationServer.class,args);
    }
}
