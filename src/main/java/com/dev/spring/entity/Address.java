package com.dev.spring.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "adresses")
@Data
public class Address implements Serializable {

    public enum TypeAddress {
        COMERCIAL, RESIDENSIAL
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_address")
    private long id;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "street", nullable = false)
    private String street;

    @Enumerated(EnumType.STRING)
    @Column(name = "type_address", nullable = false)
    private TypeAddress type;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "persons_addresses",
            joinColumns = @JoinColumn(name = "id_address"),
            inverseJoinColumns = @JoinColumn(name = "id_person")
    )
    private List<Person> persons;
}
