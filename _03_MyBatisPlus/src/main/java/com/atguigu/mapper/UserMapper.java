package com.atguigu.mapper;

import com.atguigu.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.Map;

/**
 * @author:majunchao
 * @date:2022/10/17 16:03
 */

public interface UserMapper extends BaseMapper<User> {

    Map<String,Object> selectMapById(Long id);
}
