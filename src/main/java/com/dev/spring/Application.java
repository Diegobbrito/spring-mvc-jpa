package com.dev.spring;

import com.dev.spring.dao.DocumentDAO;
import com.dev.spring.dao.PersonDAO;
import com.dev.spring.dao.PhoneDAO;
import com.dev.spring.entity.Document;
import com.dev.spring.entity.Person;
import com.dev.spring.entity.Phone;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
//        insertPerson();
//        updatePerson();
//        insertDocument();
//        updateDocument();
//        findPersonByCpf();
//        insertPhone();
//        insertPhoneByPerson();
//        updatePhone();
//        updatePhoneByPerson();
//        deleteOnCascade();
    }

    private static void deleteOnCascade() {

        new PersonDAO().delete(9L);
    }
    private static void updatePhoneByPerson() {
        Person person = new PersonDAO().findById(9L);

        for (Phone phone: person.getPhones()) {
            System.out.println("1- " + phone.toString());
            if(Phone.TypePhone.COMERCIAL == phone.getType()){
                phone.setType(Phone.TypePhone.RESIDENCIAL);
            }
        }

        new PersonDAO().update(person);

        for (Phone phone: person.getPhones()) {
            System.out.println("2- " + phone.toString());

        }

    }
    private static void updatePhone() {

        Person person = new PersonDAO().findById(9L);

        PhoneDAO dao = new PhoneDAO();

        Phone phone = dao.findById(2L);

        phone.setPerson(person);
        dao.update(phone);

        phone = dao.findById(phone.getId());

        System.out.println(phone.toString());
    }
    private static void insertPhoneByPerson() {
        Phone phone1 = new Phone(Phone.TypePhone.CELULAR, "900595022");
        Phone phone2 = new Phone(Phone.TypePhone.COMERCIAL, "553440022");

        Person person = new Person();
        person.setFirstName("Jojo");
        person.setLastName("Figueira");
        person.setAge(20);
        person.setDocument(new Document("245.385.638-99", 95244557));

//        phone1.setPerson(person);
//        phone2.setPerson(person);
//        person.setPhones(Arrays.asList(phone1, phone2));

        person.addPhone(phone1);
        person.addPhone(phone2);

        new PersonDAO().save(person);

    }
    private static void insertPhone() {
        Person p1 = new Person();
        p1.setFirstName("Jonata");
        p1.setLastName("Figueira");
        p1.setAge(29);
        p1.setDocument(new Document("112.345.678-99", 1234567));
        Phone phone = new Phone(Phone.TypePhone.CELULAR, "991990022");
        phone.setPerson(p1);

        PhoneDAO dao = new PhoneDAO();

        dao.save(phone);

        phone = dao.findById(phone.getId());

        System.out.println(phone.toString());
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
