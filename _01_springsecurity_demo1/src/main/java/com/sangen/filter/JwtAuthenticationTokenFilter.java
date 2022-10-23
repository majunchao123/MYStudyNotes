package com.sangen.filter;

import com.sangen.domain.LoginUser;
import com.sangen.utils.JwtUtil;
import com.sangen.utils.RedisCache;
import io.jsonwebtoken.Claims;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author:majunchao
 * @date:2022/10/11 15:27
 */
@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {


    @Autowired
    RedisCache redisCache;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        //获取token
        String token = httpServletRequest.getHeader("token");
        if (StringUtils.isEmpty(token)){
            filterChain.doFilter(httpServletRequest,httpServletResponse);
            return;
        }

        //解析token
        String userid;
        try {
            Claims claims = JwtUtil.parseJWT(token);
             userid = claims.getSubject();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("token非法");
        }

        //从redis中获取用户信息
        String redisKey = "login:"+userid;
        LoginUser user = (LoginUser) redisCache.getCacheObject(redisKey);
        if (ObjectUtils.allNull(user)){
            throw new RuntimeException("用户未登录");
        }

        //存入securityContextHolder
        // 获取权限信息封装到Authentication中
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        //放行
        filterChain.doFilter(httpServletRequest,httpServletResponse);
    }
}
