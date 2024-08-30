package com.br.datapet.usecase.enums;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum EstadoEnum {

    SAO_PAULO("São Paulo", Arrays.asList("São Paulo", "Campinas", "Santos")),
    RIO_DE_JANEIRO("Rio de Janeiro", Arrays.asList("Rio de Janeiro", "Niterói", "Petrópolis")),
    MINAS_GERAIS("Minas Gerais", Arrays.asList("Belo Horizonte", "Uberlândia", "Juiz de Fora")),
    BAHIA("Bahia", Arrays.asList("Salvador", "Feira de Santana", "Ilhéus"));

    private final String nomeCompleto;
    private final List<String> cidades;
    private static final Map<String, EstadoEnum> estadoMap = new HashMap<>();

    static {
        Arrays.stream(EstadoEnum.values())
                .forEach(estado -> estadoMap.put(estado.getNomeCompleto().toUpperCase(), estado));
    }

    EstadoEnum(String nomeCompleto, List<String> cidades) {
        this.nomeCompleto = nomeCompleto;
        this.cidades = cidades;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public List<String> getCidades() {
        return cidades;
    }

    public static boolean isEstadoValido(String estado) {
        return estadoMap.containsKey(estado.toUpperCase());
    }

    public static boolean isCidadeValidaParaEstado(String estado, String cidade) {
        EstadoEnum est = estadoMap.get(estado.toUpperCase());
        return est != null && est.getCidades().contains(cidade);
    }
}
