package br.com.hexa.infra.utils;

import io.micrometer.common.util.StringUtils;

public class CepUtils {

    private CepUtils() {
    }

    public static int[] getCep(String value) {
        if (value == null) {
            return new int[2];
        }

        String cep = value.replaceAll("[^\\d]", "");

        if (cep.length() > 8) {
            return new int[2];
        }

        if (StringUtils.isBlank(cep)) {
            return new int[2];
        }

        String numeroCep = cep.substring(0, cep.length() - 3);
        String controleCep = cep.substring(cep.length() - 3);

        int[] resultado = new int[2];

        resultado[0] = Integer.parseInt(numeroCep);
        resultado[1] = Integer.parseInt(controleCep);

        return resultado;
    }
}
