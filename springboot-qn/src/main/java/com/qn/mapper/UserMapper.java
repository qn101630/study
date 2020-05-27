package com.qn.mapper;

import com.qn.eneity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * Mapper.xml映射类
 */
@Repository
@Mapper
public interface UserMapper {
    User Sel(int id);
}
