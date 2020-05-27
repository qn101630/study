package com.qn.dao.app;

import com.qn.eneity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppPersonRepository extends JpaRepository<Person, Integer> {

}
