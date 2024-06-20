package br.com.hexa.infra.utils;

import org.apache.commons.lang3.math.NumberUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {

    public final static DateTimeFormatter formatterDateTimeBR = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");

    public final static DateTimeFormatter formatterDateBR = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public final static DateTimeFormatter formatterDatePointBR = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public final static DateTimeFormatter formatterDate2BR = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    private DateUtils(){
    }

    public static Integer dateToNumber(LocalDateTime dateTime){
        return NumberUtils.toInt(DateTimeFormatter.ofPattern("yyyyMMdd").format(dateTime));
    }

    public static LocalDate getGreater(LocalDate a, LocalDate b){
        return a.isAfter(b) ? a : b;
    }

    public static LocalDate getLower(LocalDate a, LocalDate b){
        return a.isBefore(b) ? a : b;
    }

    public static String getStringLocalDateTimeBr(LocalDateTime dateTime){
        try {
            return dateTime.format(formatterDatePointBR);
        }catch (Exception e){
            return "";
        }
    }

    public static String getStringLocalDateBr(LocalDate dateTime){
        try {
            return dateTime.format(formatterDatePointBR);
        }catch (Exception e){
            return "";
        }
    }
}

