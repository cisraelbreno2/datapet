package com.br.datapet.datasource.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

import java.util.UUID;

@Entity
@Getter
public class Parametros {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String frequenciaCardiaca;
    private String pressao;
    private Double temperatura;
    private String frequenciaRespiratoria;
    private String hidratacao;
    private Boolean mucosas;
    private Boolean urina;
    private Boolean fezes;
    private Boolean alimentacao;
    private Boolean agua;
}
