package com.br.datapet.datasource.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
public class EntradaHospitalar {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String motivo;
    private String urgencia;

    private LocalDateTime horaEntrada;
    private LocalDateTime horaSaida;

    @ManyToOne
    @JoinColumn(name = "id_parametro", referencedColumnName = "id")
    private Parametros parametro;

    @ManyToOne
    @JoinColumn(name = "id_pet", referencedColumnName = "id")
    private Pet pet;

}
