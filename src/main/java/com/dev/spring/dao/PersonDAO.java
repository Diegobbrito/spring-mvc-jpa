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

    public List<Person> findAgeIsBetween(int min, int max){
        String jpql = "from Person p where p.age between ? and ?";
        return find(jpql, min, max);
    }

    public Person findByFullName(String firtName, String lastName){
        String jpql = "from Person p where p.firtName like ? and p.lastName like ?";
        return findOne(jpql, firtName, lastName);
    }

    public Person findByCpf(String cpf){
        String jpql = "select p from Person p, Document d where d.cpf like ?1 and p.document.id = d.id";

        return findOne(jpql, cpf);
    }
}
