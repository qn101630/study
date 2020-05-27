package com.qn.service;

import com.qn.eneity.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
class UserServiceTest {

    @Autowired
    UserService userService;

    @Test
    void sel() {
        User user = userService.Sel(2);
        System.out.println(user.toString());
    }
}