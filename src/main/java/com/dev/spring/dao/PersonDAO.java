package com.dev.spring.dao;

import com.dev.spring.entity.Person;

public class PersonDAO extends GenericDAO<Person> {

    public PersonDAO(){
        super(Person.class);
    }
}
