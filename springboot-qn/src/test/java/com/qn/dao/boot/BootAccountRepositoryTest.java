package com.qn.dao.boot;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
class BootAccountRepositoryTest {

    @Autowired
    BootAccountRepository bootAccountRepository;

    @Test
    void getAllUsers() {
        bootAccountRepository.findAll().forEach(
                user -> System.out.println(user.toString())
        );
    }
}