package com.qn.service;

import com.qn.eneity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * boot-jdbc测试业务类
 */
@Service
public class AccountService {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Account> getAll() {
        return jdbcTemplate.query("SELECT * FROM account", new Object[]{}, new BeanPropertyRowMapper(Account.class));
    }
}
