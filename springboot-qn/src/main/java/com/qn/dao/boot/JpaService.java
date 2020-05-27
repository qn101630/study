package com.qn.dao.boot;

import com.qn.eneity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * jpa测试业务类
 */
public interface JpaService extends JpaRepository<Account, Integer> {

    Account findByIdAndName(int id, String name);

}
