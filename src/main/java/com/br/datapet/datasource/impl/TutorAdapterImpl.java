package com.br.datapet.datasource.impl;

import com.br.datapet.datasource.TutorAdapter;
import com.br.datapet.datasource.entity.Tutor;
import com.br.datapet.datasource.repository.TutorRepository;
import com.br.datapet.usecase.dto.request.CadastroTutorRequest;
import org.springframework.stereotype.Repository;

@Repository
public class TutorAdapterImpl implements TutorAdapter {

    public TutorRepository tutorRepository;

    public TutorAdapterImpl(TutorRepository tutorRepository) {
        this.tutorRepository = tutorRepository;
    }

    public void save(CadastroTutorRequest cadastroTutorRequest) {

        Tutor tutor = Tutor.builder()
                .nome(cadastroTutorRequest.getNome())
                .cpf(cadastroTutorRequest.getCpf())
                .bairro(cadastroTutorRequest.getBairro())
                .cidade(cadastroTutorRequest.getCidade())
                .estado(cadastroTutorRequest.getEstado())
                .cep(cadastroTutorRequest.getCep())
                .logradouro(cadastroTutorRequest.getLogradouro())
                .numero(cadastroTutorRequest.getNumero())
                .complemento(cadastroTutorRequest.getComplemento())
                .email(cadastroTutorRequest.getEmail())
                .telefone(cadastroTutorRequest.getTelefone())
                .build();


        tutorRepository.save(tutor);
    }
}
