package com.br.datapet.datasource.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class EntradaHospitalarQuadroExecucao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "id_entrada_hospitalar", referencedColumnName = "id")
    private EntradaHospitalar entradaHospitalar;

    @ManyToOne
    @JoinColumn(name = "id_quadro_execucao", referencedColumnName = "id")
    private QuadroExecucao quadroExecucao;

}
