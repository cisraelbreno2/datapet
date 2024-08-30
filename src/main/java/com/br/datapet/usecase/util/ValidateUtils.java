package com.br.datapet.usecase.util;

import java.util.InputMismatchException;
import java.util.Optional;

public class ValidateUtils {

    public static boolean isCPFValid(String CPF) {
        CPF = removerCaracteresEspeciais(CPF);

        if (CPF.equals("00000000000") ||
                CPF.equals("11111111111") ||
                CPF.equals("22222222222") || CPF.equals("33333333333") ||
                CPF.equals("44444444444") || CPF.equals("55555555555") ||
                CPF.equals("66666666666") || CPF.equals("77777777777") ||
                CPF.equals("88888888888") || CPF.equals("99999999999") ||
                (CPF.length() != 11))
            return(false);

        char dig10, dig11;
        int sm, i, r, num, peso;

        try {
            sm = 0;
            peso = 10;
            for (i=0; i<9; i++) {
                num = (int)(CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig10 = '0';
            else dig10 = (char)(r + 48);

            // Calculo do 2o. Digito Verificador
            sm = 0;
            peso = 11;
            for(i=0; i<10; i++) {
                num = (int)(CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig11 = '0';
            else dig11 = (char)(r + 48);

            if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
                return(true);
            else return(false);
        } catch (InputMismatchException erro) {
            return(false);
        }
    }

    public static boolean isEmailValid(String email) {
        if(email.contains("@") && email.contains(".")) {
            return true;
        }
        return false;
    }

    public static boolean isTelefoneValid(String ddd, String telefone) {
        Optional.ofNullable(ddd).orElseThrow(() -> new IllegalArgumentException("DDD não pode ser nulo"));
        Optional.ofNullable(telefone).orElseThrow(() -> new IllegalArgumentException("Telefone não pode ser nulo"));

        if(ddd.length() == 3 && telefone.length() >= 7) {
            return true;
        }
        return false;
    }

    public static boolean isTelefoneValid(String telefone) {
        Optional.ofNullable(telefone).orElseThrow(() -> new IllegalArgumentException("Telefone não pode ser nulo"));
        if(telefone.length() >= 7) {
            return true;
        }
        return false;
    }

    public static boolean isObjectsNull(Object... objects) {
        for (Object object : objects) {
            if (object == null) {
                return true;
            }
        }
        return false;
    }

    public static String removerCaracteresEspeciais(String input) {
        return input.replaceAll("[^a-zA-Z0-9\\s]", "");
    }

}
