package br.com.hexa.infra.utils;

import org.apache.commons.lang3.StringUtils;

public class CpfUtils {

    private CpfUtils() {}

    /**
     * Realiza a validacao do CPF.
     *
     * @param cpf numero de CPF a ser validado pode ser passado no formado
     *            array com 2 posicoes sendo:
     *            	0 - numero do cpf
     *            	1 - controle
     *            array ou 3 posicoes
     *            	0 - numero do cpf
     *              1 - filial (ignorado)
     *            	2 - controle
     * @return true se o CPF e valido e false se nao e valido
     */
    public static boolean cpfValido(int... value) {
        return cpfValido(obterCpfNumeros(value));
    }

    /**
     * Realiza a validacao do CPF.
     *
     * @param cpf numero de CPF a ser validado pode ser passado no formado
     *            999.999.999-99 ou 99999999999
     * @return true se o CPF e valido e false se nao e valido
     */
    public static boolean cpfValido(String cpf) {
        cpf = cpf.replace(".", "");
        cpf = cpf.replace("-", "");

        try {
            Long.parseLong(cpf);

            int d1, d2;
            int digito1, digito2, resto;
            int digitoCPF;
            String nDigResult;

            d1 = d2 = 0;
            digito1 = digito2 = resto = 0;

            for (int nCount = 1; nCount < cpf.length() - 1; nCount++) {
                digitoCPF = Integer.valueOf(cpf.substring(nCount - 1, nCount)).intValue();

                // multiplique a ultima casa por 2 a seguinte por 3 a seguinte por 4
                // e assim por diante.
                d1 = d1 + (11 - nCount) * digitoCPF;

                // para o segundo digito repita o procedimento incluindo o primeiro
                // digito calculado no passo anterior.
                d2 = d2 + (12 - nCount) * digitoCPF;
            }
            ;

            // Primeiro resto da divisao por 11.
            resto = (d1 % 11);

            // Se o resultado for 0 ou 1 o digito e 0 caso contrario o digito e 11
            // menos o resultado anterior.
            if (resto < 2)
                digito1 = 0;
            else
                digito1 = 11 - resto;

            d2 += 2 * digito1;

            // Segundo resto da divisao por 11.
            resto = (d2 % 11);

            // Se o resultado for 0 ou 1 o digito e 0 caso contrario o digito e 11
            // menos o resultado anterior.
            if (resto < 2)
                digito2 = 0;
            else
                digito2 = 11 - resto;

            // Digito verificador do CPF que esta sendo validado.
            String nDigVerific = cpf.substring(cpf.length() - 2, cpf.length());

            // Concatenando o primeiro resto com o segundo.
            nDigResult = String.valueOf(digito1) + String.valueOf(digito2);

            // comparar o digito verificador do cpf com o primeiro resto + o segundo
            // resto.
            return nDigVerific.equals(nDigResult);

        } catch (Exception e) {
            return false;
        }
    }

    public static boolean codigoCpfValido(String cpf){
        String pattern = "^[0-9]{1,9}$";
        return cpf.matches(pattern);
    }

    public static int[] obterCpfArrayNumerico(String value) {
        if (value == null) {
            return new int[3];
        }
        String cpf = value.replaceAll("[^\\d]", "");
        if (cpf.length() > 11) {
            return new int[3];
        }

        if (StringUtils.isBlank(cpf)) {
            return new int[3];
        }

        String numeroCpf = cpf.substring(0, cpf.length() - 2);
        String controleCpf = cpf.substring(cpf.length() - 2);

        int[] resultado = new int[3];

        resultado[0] = Integer.parseInt(numeroCpf);
        resultado[1] = 0;
        resultado[2] = Integer.parseInt(controleCpf);

        return resultado;
    }

    public static String obterCpfNumeros(int... value) {
        if (value == null) {
            return null;
        }

        if (value.length == 2 && value[0] < 1000000000 && value[1] < 100)
            return StringUtils.leftPad(String.valueOf(value[0]), 9, "0")
                    + StringUtils.leftPad(String.valueOf(value[1]), 2, "0");

        if (value.length == 3 && value[0] < 1000000000 && value[2] < 100)
            return StringUtils.leftPad(String.valueOf(value[0]), 9, "0")
                    + StringUtils.leftPad(String.valueOf(value[2]), 2, "0");

        return null;
    }

}
