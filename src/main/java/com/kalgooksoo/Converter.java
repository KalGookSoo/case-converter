package com.kalgooksoo;

interface Converter {

    static String camelToSnake(String camelCase, boolean isUpper) {
        if (camelCase == null || camelCase.isEmpty()) {
            return camelCase;
        }

        StringBuilder sb = new StringBuilder();
        char[] chars = camelCase.toCharArray();

        for (char c : chars) {
            if (Character.isUpperCase(c)) {
                if (sb.length() > 0) {
                    sb.append('_');
                }
                sb.append(Character.toLowerCase(c));
            } else {
                sb.append(c);
            }
        }
        return isUpper ? sb.toString().toUpperCase() : sb.toString();
    }

}
