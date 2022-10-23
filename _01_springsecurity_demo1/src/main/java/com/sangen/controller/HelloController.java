package com.sangen.controller;

import com.sangen.domain.ResponseResult;
import com.sangen.domain.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author:majunchao
 * @date:2022/10/10 10:47
 */
@RestController
@Api(tags = "测试页面")
public class HelloController {


    @GetMapping("/hello")
    @ApiOperation("测试功能1")
    @PreAuthorize("hasAuthority('system:test:list')")
    public String hello() {
        return "hello";
    }


    @PostMapping("/testCors")
    @ApiOperation("测试接口")
    @PreAuthorize("@ss.hasAuthority('system:test:list')")
    public ResponseResult testCors() {
        return new ResponseResult(200,"测试成功");
    }






}
