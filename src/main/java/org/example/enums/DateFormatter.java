package org.example.enums;

import java.text.SimpleDateFormat;

public enum DateFormatter {
    DATE_FORMATTER_JS(new SimpleDateFormat("dd/MM/yyyy")),
    DATE_FORMATTER_JSP(new SimpleDateFormat("yyyy-MM-dd"));

    final SimpleDateFormat simpleDateFormat;

    DateFormatter(SimpleDateFormat simpleDateFormat) {
        this.simpleDateFormat = simpleDateFormat;
    }

    public SimpleDateFormat getSimpleDateFormat() {
        return simpleDateFormat;
    }
}
