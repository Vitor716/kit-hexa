package br.com.hexa.infra.utils;

import org.apache.commons.lang3.StringUtils;

public class CnpjUtils {

    private CnpjUtils() {
    }

    /**
     * Realiza a validacao de um cnpj
     *
     * @param cnpj int[] - o CNPJ pode ser passado no formato array com 3 posicoes sendo:
     *             0 - numero do cnpj
     *             1 - filial
     *             2 - controle
     * @return boolean
     */
    public static boolean cnpjValido(int... value) {
        return cnpjValido(obterCnpjNumeros(value));
    }

    /**
     * Realiza a validacao de um cnpj
     *
     * @param cnpj String - o CNPJ pode ser passado no formato 99.999.999/9999-99 ou
     *             99999999999999
     * @return boolean
     */
    public static boolean cnpjValido(String cnpj) {
        cnpj = cnpj.replace(".", "");
        cnpj = cnpj.replace("-", "");
        cnpj = cnpj.replace("/", "");

        try {

            Long.parseLong(cnpj);

            // considera-se erro CNPJ's formados por uma sequencia de numeros iguais
            if (cnpj.equals("00000000000000") || cnpj.equals("11111111111111") || cnpj.equals("22222222222222") || cnpj.equals("33333333333333") || cnpj.equals("44444444444444") || cnpj.equals("55555555555555") || cnpj.equals("66666666666666") || cnpj.equals("77777777777777") || cnpj.equals("88888888888888") || cnpj.equals("99999999999999") || (cnpj.length() != 14))
                return (false);
            char dig13, dig14;
            int sm, i, r, num, peso;

            // Calculo do 1o. Digito Verificador
            sm = 0;
            peso = 2;
            for (i = 11; i >= 0; i--) {
                // converte o i-esimo caractere do CNPJ em um numero: // por
                // exemplo, transforma o caractere '0' no inteiro 0 // (48 eh a
                // posicao de '0' na tabela ASCII)
                num = cnpj.charAt(i) - 48;
                sm = sm + (num * peso);
                peso = peso + 1;
                if (peso == 10) peso = 2;
            }

            r = sm % 11;
            if ((r == 0) || (r == 1)) dig13 = '0';
            else dig13 = (char) ((11 - r) + 48);

            // Calculo do 2o. Digito Verificador
            sm = 0;
            peso = 2;
            for (i = 12; i >= 0; i--) {
                num = cnpj.charAt(i) - 48;
                sm = sm + (num * peso);
                peso = peso + 1;
                if (peso == 10) peso = 2;
            }
            r = sm % 11;
            if ((r == 0) || (r == 1)) dig14 = '0';
            else dig14 = (char) ((11 - r) + 48);

            // Verifica se os digitos calculados conferem com os digitos
            // informados.
            return (dig13 == cnpj.charAt(12)) && (dig14 == cnpj.charAt(13));
        } catch (Exception erro) {
            return (false);
        }
    }

    public static int[] obterCnpjArrayNumerico(String value) {
        if (value == null) {
            return new int[3];
        }
        String cnpj = value.replaceAll("[^\\d]", "");
        if (cnpj.length() > 14 || StringUtils.isBlank(cnpj)) {
            return new int[3];
        }

        String numeroCnpj = cnpj.substring(0, cnpj.length() - 6);
        String filialCnpj = cnpj.substring(cnpj.length() - 6, cnpj.length() - 2);
        String controleCnpj = cnpj.substring(cnpj.length() - 2);

        int[] resultado = new int[3];

        resultado[0] = Integer.parseInt(numeroCnpj);
        resultado[1] = Integer.parseInt(filialCnpj);
        resultado[2] = Integer.parseInt(controleCnpj);

        return resultado;
    }

    public static String obterCnpjNumeros(int... value) {
        if (value == null || value.length != 3 || value[0] > 99999999 || value[1] > 9999 || value[2] > 99) {
            return "00000000000000";
        }
        return StringUtils.leftPad(String.valueOf(value[0]), 8, "0") + StringUtils.leftPad(String.valueOf(value[1]), 4, "0") + StringUtils.leftPad(String.valueOf(value[2]), 2, "0");
    }

}
