package com.qn.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
class RedisServiceTest {
    @Autowired
    RedisService redisService;

    @Test
    void getValue() {
        System.out.println("获取数据： "+redisService.getValue("sex","nan"));
    }

    @Test
    void testSerializable(){
        System.out.println(redisService.testSerializable().toString());
    }
}