package com.qn.service;

import com.qn.eneity.User;
import com.qn.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * xml使用mybatis测试业务类
 */
@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public User Sel(int id) {

        return userMapper.Sel(id);

    }
}
