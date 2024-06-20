package br.com.hexa.infra.utils;

import org.apache.commons.lang3.RegExUtils;

import static br.com.hexa.infra.utils.StringUtils.normalizeAlphaNumericLimit;
import static org.apache.commons.lang3.math.NumberUtils.toInt;

public class EnderecoUtils {

    private EnderecoUtils(){}

    public static String tratarNumeroLogradouro(String numeroInformado){
        String formatado = (normalizeAlphaNumericLimit(numeroInformado, 7));
        String numero = "S/N";
        long numeroLogradouroLong = toInt(RegExUtils.removePattern(formatado, "[^\\d.]"));
        if(numeroLogradouroLong > 0){
            numero = formatado;
        }
        return numero;
    }
}
