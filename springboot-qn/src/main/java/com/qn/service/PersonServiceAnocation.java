package com.qn.service;

import com.qn.dao.app.PersonMapperAnocation;
import com.qn.eneity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceAnocation {
    @Autowired
    PersonMapperAnocation personMapperAnocation;

    List<Person> getAll() {
        return personMapperAnocation.getAll();
    }
}
