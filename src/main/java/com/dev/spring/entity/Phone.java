package com.dev.spring.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "phones")
@Data
@NoArgsConstructor
public class Phone implements Serializable {

    public Phone(TypePhone type, String number) {
        this.number = number;
        this.type = type;
    }

    public enum TypePhone{
        RESIDENCIAL, CELULAR, COMERCIAL
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_phone")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "type_phone", nullable = false)
    private TypePhone type;

    @Column(name = "number", nullable = false)
    private String number;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id")
    private Person person;


}
