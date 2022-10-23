package com.sangen.controller;

import com.sangen.domain.ResponseResult;
import com.sangen.domain.User;
import com.sangen.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author:majunchao
 * @date:2022/10/11 9:17
 */

@RestController
@Api(tags = "登录页面")
public class LoginController {

    @Autowired
    LoginService loginService;


    @PostMapping("/user/login")
    @ApiOperation("登录功能")
    public ResponseResult login(@RequestBody User user) {
        return loginService.login(user);
    }

    @PostMapping("/user/logout")
    @ApiOperation("退出登录")
    public ResponseResult logout(){
        return loginService.logout();
    }






}
