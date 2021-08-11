package com.example.travels.test;

import com.example.traveldemo.TraveldemoApplication;
import com.example.traveldemo.entity.User;
import com.example.traveldemo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: Maozh
 * @Date: 2021 07 17
 */

@SpringBootTest(classes = TraveldemoApplication.class)
@RunWith(SpringRunner.class)
public class TestUserService {

    @Autowired
    private UserService userService;

    @Test
    public void testSave(){
        User user = new User();
        user.setUsername("xiaocai");
        user.setPassword("456");
        user.setEmail("456@qq.com");
        userService.register(user);
    }
}
