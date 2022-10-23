package com.sangen.config;


import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {


    //配置Swagger的docket的bean实例
    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //basePackage:指定要扫描的包
                //any():扫描全部的包
                //withMethodAnnotation  扫描方法上的注解
                //withClassAnnotation  扫描类上的注解
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                //paths  过滤地址
                //.paths(PathSelectors.ant("/controller/**"))
                .build();
    }


    //配置swagger信息 = apiInfo
    private ApiInfo apiInfo(){
        //作者信息
        Contact contact = new Contact("小马", "www.http", "294136893@qq.com");

        return new ApiInfo("小马的学习日记",
                "Api Documentation",
                "1.0",
                "urn:tos",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList()
        );
    }
}