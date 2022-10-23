package com.sangen.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sangen.domain.Menu;

import java.util.List;

/**
 * @author:majunchao
 * @date:2022/10/12 16:45
 */
public interface MenuMapper extends BaseMapper<Menu> {

    List<String> selectPermsByUserId(Long userid);
}
