package org.example.util;

import org.example.enums.DateFormatter;

import java.text.ParseException;
import java.util.Date;

public class DateUtil {

    public static Date convertStringToDate(String date, DateFormatter dateFormatter) throws ParseException {
        return dateFormatter.getSimpleDateFormat().parse(date);

    }

    public static String convertDateToString(Date date, DateFormatter dateFormatter) throws ParseException {
        return dateFormatter.getSimpleDateFormat().format(date);

    }
}
