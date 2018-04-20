package com.primeton.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static String getDateForSS() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmssSS");
        String formDate = sdf.format(date);
        return formDate;
    }

    public static void main(String[] args) {
        System.out.println(getDateForSS());
    }
}
