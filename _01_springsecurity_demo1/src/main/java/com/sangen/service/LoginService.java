package com.sangen.service;

import com.sangen.domain.ResponseResult;
import com.sangen.domain.User;

/**
 * @author:majunchao
 * @date:2022/10/11 9:19
 */
public interface LoginService {
    ResponseResult login(User user);

    ResponseResult logout();

}
