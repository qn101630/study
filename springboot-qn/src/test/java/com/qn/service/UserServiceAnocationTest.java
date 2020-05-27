package com.qn.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
class UserServiceAnocationTest {

    @Autowired
    UserServiceAnocation userServiceAnocation;

    @Test
    void getAllUsers() {
        for (int i = 0; i < 10; i++) {
            userServiceAnocation.getAllUsers()
                    .forEach(user -> System.out.println(user.toString()));
        }
    }
}