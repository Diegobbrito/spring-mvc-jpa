package com.dev.spring;

import com.dev.spring.dao.DocumentDAO;
import com.dev.spring.dao.PersonDAO;
import com.dev.spring.entity.Document;
import com.dev.spring.entity.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
//        insertPerson();
//        updatePerson();
//        insertDocument();
//        updateDocument();
        findPersonByCpf();
    }

    private static void findPersonByCpf() {

        Person p = new PersonDAO().findByCpf("123.456.789-99");
        System.out.println(p.toString());
    }

    private static void updateDocument() {

        Document doc = new DocumentDAO().findById(1L);
        doc.setCpf("123.456.789-99");
        new DocumentDAO().update(doc);
    }

    private static void insertDocument() {

        Person p1 = new Person();
        p1.setFirstName("Aline");
        p1.setLastName("da Souza");
        p1.setAge(29);
        p1.setDocument(new Document("123.456.789-99", 123456789));
        new PersonDAO().save(p1);
        System.out.println(p1.toString());
    }


    private static void updatePerson(){
        Person p = new PersonDAO().findById(2L);

        p.setLastName("De Souza");

        new PersonDAO().update(p);

        p = new PersonDAO().findById(2L);

        System.out.println(p.toString());

    }

    private static void insertPerson(){
        Person p1 = new Person();
        p1.setFirstName("Ana Maria");
        p1.setAge(29);
        p1.setLastName("da Silva");

        new PersonDAO().save(p1);
        System.out.println(p1.toString());

        Person p2 = new Person();
        p2.setFirstName("Bruna");
        p2.setAge(29);
        p2.setLastName("Figueira");

        new PersonDAO().save(p2);
        System.out.println(p2.toString());

        Person p3 = new Person();
        p3.setFirstName("Carlos Andre");
        p3.setAge(26);
        p3.setLastName("Rodrigues");

        new PersonDAO().save(p3);
        System.out.println(p3.toString());
    }

}
