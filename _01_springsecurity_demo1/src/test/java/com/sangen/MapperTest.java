package com.sangen;

import com.sangen.domain.User;
import com.sangen.mapper.MenuMapper;
import com.sangen.mapper.UserMapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

/**
 * @author:majunchao
 * @date:2022/10/10 14:59
 */
@SpringBootTest
public class MapperTest {
    @Autowired
    UserMapper userMapper;


    @Autowired
    PasswordEncoder passwordEncoder;



    @Test
    public void  TestBCryptPassWordEncoder(){
//        String encode = passwordEncoder.encode("1234");
//        System.out.println(encode);
        boolean matches = passwordEncoder.matches("1234","$2a$10$Kw6NRRNzajx.sP1vsoWZUeIbtd9Vw1rtkt242bXIzRlV7ClxO4RsK" );
        System.out.println(matches);
    }

    @Test
    public void testUserMapper(){
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }


    @Autowired
    MenuMapper menuMapper;
    @Test
    public void test1(){
        List<String> list = menuMapper.selectPermsByUserId(1l);
        System.out.println(list);

    }
}
