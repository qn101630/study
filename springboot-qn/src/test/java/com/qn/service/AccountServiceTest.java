package com.qn.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * jdbc测试
 */
@SpringBootTest
@RunWith(SpringRunner.class)
class AccountServiceTest {

    @Autowired
    AccountService accountService;

    @Test
    void getAll() {
        accountService.getAll().forEach(account -> System.out.println(account.toString()));
    }
}