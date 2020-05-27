package com.qn.dao.app;

import com.qn.eneity.Person;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface PersonMapperAnocation {
    @Select("SELECT * FROM person")
    List<Person> getAll();
}
