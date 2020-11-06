package com.dev.spring.entity;

import lombok.Data;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "PERSONS", indexes = {@Index(columnList = "FIRST_NAME, LAST_NAME", name = "IDX_PERSON_NAME", unique = true)})
@Data
public class Person implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PERSON")
    private Long id;

    @Column(name = "FIRST_NAME", nullable = false, length = 30)
    private String firstName;

    @Column(name = "LAST_NAME", nullable = false, length = 60)
    private String lastName;

    @Column(name = "AGE", nullable = false)
    private Integer age;

}
