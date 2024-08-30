package com.br.datapet.datasource.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
public class EntradaHospedagem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "id_pet", referencedColumnName = "id")
    private Pet pet;

    private LocalDateTime horaEntrada;
    private LocalDateTime horaSaida;
    private Integer diarias;
    private Boolean antipulga;
    private Boolean vermifogo;

}
