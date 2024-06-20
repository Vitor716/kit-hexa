package br.com.hexa.infra.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class CurrencyUtils {
    public final static DecimalFormat dfBR = setFormatBR("####0.00");

    private CurrencyUtils() {
    }

    private static DecimalFormat setFormatBR(String format) {
        final DecimalFormatSymbols dfsBR = new DecimalFormatSymbols();
        final DecimalFormat dfBR = new DecimalFormat(format);
        dfsBR.setDecimalSeparator(',');
        dfsBR.setGroupingSeparator('.');
        dfBR.setDecimalFormatSymbols(dfsBR);
        return dfBR;
    }

    public static String getStringBR(BigDecimal source) {
        try {
            return dfBR.format(source.setScale(2, RoundingMode.DOWN));
        } catch (Exception e) {
            return "";
        }
    }

}
