package com.br.datapet.datasource.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
public class QuadroExecucao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String procedimento;
    private LocalDateTime horario;
    private Boolean efetuado;

}
