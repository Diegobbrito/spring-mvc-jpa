package com.dev.spring;

import com.dev.spring.dao.PersonDAO;
import com.dev.spring.entity.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        insertPerson();
    }

    private static void insertPerson(){
//        Person p1 = new Person();
//        p1.setFirstName("Ana Maria");
//        p1.setAge(29);
//        p1.setLastName("da Silva");
//
//        new PersonDAO().save(p1);
//        System.out.println(p1.toString());

//        Person p2 = new Person();
//        p2.setFirstName("Bruna");
//        p2.setAge(29);
//        p2.setLastName("Figueira");
//
//        new PersonDAO().save(p2);
//        System.out.println(p2.toString());
//
//        Person p3 = new Person();
//        p3.setFirstName("Carlos Andre");
//        p3.setAge(26);
//        p3.setLastName("Rodrigues");
//
//        new PersonDAO().save(p3);
//        System.out.println(p3.toString());
    }

}
