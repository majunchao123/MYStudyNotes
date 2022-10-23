package com.atguigu;

import com.atguigu.mapper.UserMapper;
import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class MybatisplusApplicationTests {
    @Autowired
    UserMapper userMapper;

    @Autowired
    UserService userService;

    @Test
    void contextLoads() {
        List<User> users = userMapper.selectList(null);
        users.stream()
                .forEach(t-> System.out.println(t));
    }


    @Test
    public void testInsert(){
        List<User> userList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            User user = new User();
            user.setName("mjc"+i);
            user.setAge(30+i);
            userList.add(user);
        }
        boolean b = userService.saveBatch(userList);
    }



}
