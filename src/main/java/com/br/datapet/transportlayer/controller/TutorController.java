package com.br.datapet.transportlayer.controller;

import com.br.datapet.datasource.TutorAdapter;
import com.br.datapet.datasource.exception.StandardRestHandler;
import com.br.datapet.usecase.CadastroTutorPort;
import com.br.datapet.usecase.dto.request.CadastroTutorRequest;
import com.br.datapet.usecase.impl.CadastroTutorUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tutor")
public class TutorController extends StandardRestHandler {

    private CadastroTutorPort cadastroTutorPort;

    public TutorController(TutorAdapter tutorAdapter) {
        this.cadastroTutorPort = new CadastroTutorUseCase(tutorAdapter);
    }

    @PostMapping
    public ResponseEntity cadastrarTutor(@RequestBody CadastroTutorRequest cadastroTutorRequest) {
        cadastroTutorPort.cadastrarTutor(cadastroTutorRequest);
        return ResponseEntity.ok().body("Cadastro realizado com sucesso");
    }

}
