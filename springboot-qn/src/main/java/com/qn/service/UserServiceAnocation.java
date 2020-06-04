package com.qn.service;

import com.qn.eneity.User;
import com.qn.dao.boot.UserMapperAnocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 注解使用mybatis业务类
 */
@Service
public class UserServiceAnocation {
    @Autowired
    UserMapperAnocation userMapperAnocation;

    @Cacheable(value = "user", keyGenerator = "cacheKeyGenerator")
    public List<User> getAllUsers() {
        System.out.println(new Date().toString());
        return userMapperAnocation.getAllUsers();
    }
}
