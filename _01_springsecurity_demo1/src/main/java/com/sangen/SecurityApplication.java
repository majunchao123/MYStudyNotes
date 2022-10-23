package com.sangen;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author:majunchao
 * @date:2022/10/10 10:46
 */
@MapperScan("com.sangen.mapper")
@SpringBootApplication
public class SecurityApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(SecurityApplication.class);
        System.out.println(run);
    }
}
