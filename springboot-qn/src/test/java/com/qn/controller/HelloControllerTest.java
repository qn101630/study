package com.qn.controller;

import lombok.Data;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.validation.annotation.Validated;

@SpringBootTest
@RunWith(SpringRunner.class)
@Data
@Validated
class HelloControllerTest {
    @Autowired
    private HelloController helloController;

    @Test
    public void contextLoads(){
        System.out.println(helloController.account());
    }
}