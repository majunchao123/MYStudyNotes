package com.sangen.service.impl;

import com.sangen.domain.LoginUser;
import com.sangen.domain.ResponseResult;
import com.sangen.domain.User;
import com.sangen.service.LoginService;
import com.sangen.utils.JwtUtil;
import com.sangen.utils.RedisCache;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:majunchao
 * @date:2022/10/11 9:19
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    RedisCache redisCache;


    @Override
    public ResponseResult login(User user) {

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);




        //如果认证没通过 给出对应提示
        if (ObjectUtils.allNull(authenticate)){
            throw new RuntimeException("登陆失败");
        }
        //如果认证成功 使用userid生成一个jwt jwt存入responseResult中返回
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        String id = loginUser.getUser().getId().toString();
        String jwt = JwtUtil.createJWT(id);

        Map<String,Object> token  = new HashMap<>();
        token.put("token",jwt);
        //把user存入redis中
        redisCache.setCacheObject("login:"+id,loginUser);
        return new ResponseResult(200,"登陆成功",token);
    }



    @Override
    public ResponseResult logout() {
        //从SecurityContextHolder中取出用户id
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        String userid = loginUser.getUser().getId().toString();
        redisCache.deleteObject("login:"+userid);
        return new ResponseResult(200,"注销成功");
    }
}
