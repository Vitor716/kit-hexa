package br.com.hexa.infra.utils;

import org.apache.commons.lang3.math.NumberUtils;

import java.text.Normalizer;

import static org.apache.commons.lang3.StringUtils.left;

public class StringUtils {

    private StringUtils() {
    }

    public static Number removeNotNumber(String target) {
        try {
            return NumberUtils.toLong(target.replaceAll("[^\\d.]", ""));
        } catch (Exception e) {
            return 0L;
        }
    }

    public static String normalizeAlpha(String target) {
        if (target == null) return "";
        String normalizedWord = Normalizer.normalize(target, Normalizer.Form.NFD);
        String result = normalizedWord.replaceAll("\\p{M}", "").replaceAll("[^a-zA-Z ]", " ").trim();
        return result;
    }

    public static String normalizeAlphaLimit(String target, Integer limit) {
        return left(normalizeAlpha(target), limit);
    }

    public static String normalizeNumeric(String target) {
        if (target == null) return "";
        String normalizedWord = Normalizer.normalize(target, Normalizer.Form.NFD);
        String result = normalizedWord.replaceAll("[^\\d.]", "").trim();
        return result;
    }

    public static String normalizeNumericLimit(String target, Integer limit) {
        return left(normalizeNumeric(target), limit);
    }

    public static String normalizeAlphaNumeric(String target) {
        if (target == null) return "";
        String normalizedWord = Normalizer.normalize(target, Normalizer.Form.NFD);
        String result = normalizedWord.replaceAll("\\p{M}", "").replaceAll("[^0-9a-zA-Z ]", " ").trim();
        return result;
    }

    public static String normalizeAlphaNumericLimit(String target, Integer limit) {
        return left(normalizeAlphaNumeric(target), limit);
    }

}
