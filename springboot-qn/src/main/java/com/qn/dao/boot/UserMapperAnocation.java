package com.qn.dao.boot;

import com.qn.eneity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * mapper注解映射类
 */
@Repository
@Mapper
public interface UserMapperAnocation {

    @Select("SELECT * FROM user")
    List<User> getAllUsers();
}
