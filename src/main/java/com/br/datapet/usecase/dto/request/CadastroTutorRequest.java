package com.br.datapet.usecase.dto.request;

import com.br.datapet.usecase.enums.EstadoEnum;
import com.br.datapet.usecase.util.ValidateUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Optional;

@Getter
@AllArgsConstructor
public class CadastroTutorRequest {

    private String nome;
    private String cpf;
    private String email;
    private String dddTelefone;
    private String telefone;
    private String dddCelular;
    private String celular;
    private String logradouro;
    private String numero;
    private String complemento;
    private String cep;
    private String bairro;
    private String cidade;
    private String estado;


    public static void isValid(CadastroTutorRequest cadastroTutorRequest) {
        Optional.ofNullable(cadastroTutorRequest).orElseThrow(() -> new IllegalArgumentException("CadastroTutorRequest não pode ser nulo"));

        if(ValidateUtils.isObjectsNull(
                cadastroTutorRequest.getNome(),
                cadastroTutorRequest.getCpf(),
                cadastroTutorRequest.getLogradouro(),
                cadastroTutorRequest.getNumero(),
                cadastroTutorRequest.getBairro(),
                cadastroTutorRequest.getCidade(),
                cadastroTutorRequest.getEstado())){
            throw new IllegalArgumentException("Campos obrigatórios não preenchidos");
        };

        if(!EstadoEnum.isEstadoValido(cadastroTutorRequest.getEstado())){
            throw new IllegalArgumentException("Estado inválido");
        };

        if(!EstadoEnum.isCidadeValidaParaEstado(cadastroTutorRequest.getEstado(), cadastroTutorRequest.getCidade())){
            throw new IllegalArgumentException("Cidade inválida para o estado");
        };

        if (!ValidateUtils.isCPFValid(cadastroTutorRequest.getCpf())){
            throw new IllegalArgumentException("CPF inválido");
        };

    }

}


