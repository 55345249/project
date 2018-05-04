package com.primeton.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;


@Configuration
public class DataSourceConfig {

    @Bean(name = "test01")
    @ConfigurationProperties(prefix = "spring.datasource.test01") // application.yml中对应属性的前缀
    public DataSource dataSource1() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "test")
    @ConfigurationProperties(prefix = "spring.datasource.test") // application.yml中对应属性的前缀
    public DataSource dataSource2() {
        return DataSourceBuilder.create().build();
    }


}
