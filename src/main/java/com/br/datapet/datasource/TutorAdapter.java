package com.br.datapet.datasource;

import com.br.datapet.usecase.dto.request.CadastroTutorRequest;

public interface TutorAdapter {

    void save(CadastroTutorRequest cadastroTutorRequest);
}
