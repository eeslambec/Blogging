package uz.pdp.blogging.util;

import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class Validator {
    public static boolean isNullOrEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }

    public static <T> T requireNonNullElse(T obj, T defaultValue) {
        if (obj == null) {
            return defaultValue;
        }
        if (obj instanceof String s) {
            if (isNullOrEmpty(s)) {
                return defaultValue;
            }
        }else if (obj instanceof Integer || obj instanceof Double) {
            double number = (obj instanceof Integer) ? ((Integer) obj).doubleValue() : (Double) obj;
            if (number < 0) {
                return defaultValue;
            }
        }
        else if (obj instanceof List<?> list) {
            if (list.isEmpty())
                return defaultValue;
        }
        return obj;
    }

}
