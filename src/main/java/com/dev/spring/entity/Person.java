package com.dev.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "person", indexes = {@Index(columnList = "FIRST_NAME, LAST_NAME", name = "IDX_PERSON_NAME", unique = true)})
public class Person implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_person")
    private Long id;

    @Column(name = "first_name", nullable = false, length = 30)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 60)
    private String lastName;

    @Column(name = "age",nullable = false)
    private Integer age;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER) //ToOne Eager, ManyToMany Lazy
    @JoinColumn(name = "document_id")
    private Document document;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.EAGER)// ToMany usar o EAGER e o person vem do nome dado no atributo em Phone
    private List<Phone> phones;

    public void addPhone(Phone phone){
        if(phones == null){
            phones = new ArrayList<>();
        }
        phone.setPerson(this);
        phones.add(phone);
    }

}
