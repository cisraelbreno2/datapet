package com.br.datapet.datasource.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.UUID;

@Entity
@Getter
public class Alergia {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "id_pet", referencedColumnName = "id")
    private Pet pet;

    private String descricao;
    private String nome;

}
