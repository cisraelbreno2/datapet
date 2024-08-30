package com.br.datapet.usecase.impl;

import com.br.datapet.datasource.TutorAdapter;
import com.br.datapet.usecase.CadastroTutorPort;
import com.br.datapet.usecase.annotation.Usecase;
import com.br.datapet.usecase.dto.request.CadastroTutorRequest;

@Usecase
public class CadastroTutorUseCase implements CadastroTutorPort {

    private TutorAdapter tutorAdapter;

    public CadastroTutorUseCase(TutorAdapter tutorAdapter) {
        this.tutorAdapter = tutorAdapter;
    }

    public void cadastrarTutor(CadastroTutorRequest cadastroTutorRequest) {

        CadastroTutorRequest.isValid(cadastroTutorRequest);

        tutorAdapter.save(cadastroTutorRequest);
    }
}
