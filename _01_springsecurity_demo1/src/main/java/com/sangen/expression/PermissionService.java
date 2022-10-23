package com.sangen.expression;

import com.sangen.domain.LoginUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author:majunchao
 * @date:2022/10/13 15:26
 */
@Service("ss")
public class PermissionService {

    public boolean hasAuthority(String permission) {
        //从其中取出权限信息
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        List<String> permissions = loginUser.getPermissions();
        //比较返回boolean值
        return permissions.contains(permission);
    }
}
