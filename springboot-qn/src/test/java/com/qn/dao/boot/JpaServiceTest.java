package com.qn.dao.boot;

import com.qn.eneity.Account;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@RunWith(SpringRunner.class)
class JpaServiceTest {

    @Autowired
    JpaService jpaService;

    /**
     * 查询所有
     */
    @Test
    void getAll() {
        List<Account> list = jpaService.findAll();
        list.forEach(account -> System.out.println(account.toString()));
    }

    /**
     * 根据id查询
     */
    @Test
    void getById() {
        System.out.println(jpaService.findById(1).toString());
    }

    /**
     * 分页查询
     */
    @Test
    void getByPage() {
        PageRequest pageRequest = PageRequest.of(0, 2);

        Page<Account> userPage = jpaService.findAll(pageRequest);

        List<Account> userList = userPage.getContent();

        userList.forEach((user) -> System.out.println(user));

        Assert.assertNotNull(userList);
    }

    /**
     * 更新
     */
    @Test
    void getUpdate() {
        Optional<Account> byId = jpaService.findById(1);
        Account account = byId.orElseThrow(() -> new RuntimeException("用户信息没有取到"));
        account.setMoney(10000);
        Account save = jpaService.save(account);
        Assert.assertNotNull(save);
        System.out.println(save.toString());
    }

    /**
     * 自定义方法
     */
    @Test
    void getByIdAndName() {
        Account account = jpaService.findByIdAndName(4, "曾烨烨");
        System.out.println(account.toString());
    }

}