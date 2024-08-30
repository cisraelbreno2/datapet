package com.br.datapet.usecase;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.br.datapet.datasource.TutorAdapter;
import com.br.datapet.usecase.dto.request.CadastroTutorRequest;
import com.br.datapet.usecase.impl.CadastroTutorUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class CadastroTutorUseCaseTest {

    @Mock
    private TutorAdapter tutorAdapter;

    @InjectMocks
    private CadastroTutorUseCase cadastroTutorUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCadastrarTutor_Sucesso() {
        CadastroTutorRequest request = new CadastroTutorRequest(
                "João da Silva",
                "097.817.409-73",
                "joao.silva@example.com",
                "11",
                "1234-5678",
                "11",
                "98765-4321",
                "Rua das Flores",
                "123",
                "Apto 101",
                "01234-567",
                "Centro",
                "São Paulo",
                "São Paulo"
        );

        doNothing().when(tutorAdapter).save(request);
        cadastroTutorUseCase.cadastrarTutor(request);
        verify(tutorAdapter, times(1)).save(request);
    }

    @Test
    void testCadastrarTutor_RequestNulo() {
        assertThrows(IllegalArgumentException.class, () -> {
            cadastroTutorUseCase.cadastrarTutor(null);
        });
    }

    @Test
    void testCadastrarTutor_CamposObrigatoriosFaltando() {
        CadastroTutorRequest request = new CadastroTutorRequest(
                null,
                "123.456.789-00",
                "joao.silva@example.com",
                "11",
                "1234-5678",
                "11",
                "98765-4321",
                "Rua das Flores",
                "123",
                "Apto 101",
                "01234-567",
                "Centro",
                "São Paulo",
                "São Paulo"
        );

        assertThrows(IllegalArgumentException.class, () -> {
            cadastroTutorUseCase.cadastrarTutor(request);
        });
    }

    @Test
    void testCadastrarTutor_EstadoInvalido() {
        CadastroTutorRequest request = new CadastroTutorRequest(
                "João da Silva",
                "123.456.789-00",
                "joao.silva@example.com",
                "11",
                "1234-5678",
                "11",
                "98765-4321",
                "Rua das Flores",
                "123",
                "Apto 101",
                "01234-567",
                "Centro",
                "São Paulo",
                "Estado Invalido"
        );

        assertThrows(IllegalArgumentException.class, () -> {
            cadastroTutorUseCase.cadastrarTutor(request);
        });
    }

    @Test
    void testCadastrarTutor_CidadeInvalidaParaEstado() {
        CadastroTutorRequest request = new CadastroTutorRequest(
                "João da Silva",
                "123.456.789-00",
                "joao.silva@example.com",
                "11",
                "1234-5678",
                "11",
                "98765-4321",
                "Rua das Flores",
                "123",
                "Apto 101",
                "01234-567",
                "Centro",
                "Cidade Invalida",
                "São Paulo"
        );

        assertThrows(IllegalArgumentException.class, () -> {
            cadastroTutorUseCase.cadastrarTutor(request);
        });
    }
}