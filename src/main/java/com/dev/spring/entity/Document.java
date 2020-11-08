package com.dev.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="documents")
@Data
@AllArgsConstructor
public class Document implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_document")
    private Long id;

    @Column(name = "cpf", nullable = false, unique = true, length = 14)
    private String cpf;

    @Column(name = "rg", unique = true)
    private Integer rg;

    public Document(String cpf, int rg) {
        this.cpf = cpf;
        this.rg = rg;
    }

    public Document() {
    }
}
