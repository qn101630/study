package com.qn.dao.boot;

import com.qn.eneity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BootAccountRepository extends JpaRepository<Account,Integer> {

}
