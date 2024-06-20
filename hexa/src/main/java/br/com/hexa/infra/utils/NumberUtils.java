package br.com.hexa.infra.utils;

public class NumberUtils {

    private NumberUtils(){

    }

    public static boolean nullOrZero(Number value){
        return value == null || value.longValue() == 0;
    }

    public static boolean nulo(Number value){
        return value == null;
    }
}
