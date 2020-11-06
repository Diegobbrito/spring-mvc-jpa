package com.dev.spring.dao;

import com.dev.spring.entity.Person;

import java.util.List;

public class PersonDAO extends GenericDAO<Person> {

    public PersonDAO(){
        super(Person.class);
    }

    public List<Person> findByLastName(String lastName){
        String jpql = "from Person p where p.lastname like ?";

        return find(jpql,lastName);
    }
}
