package com.example.android.dialysisbuddy;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by alfredchang on 2018-01-30.
 */

public class Utilities {

    private final static String INIT_FORMAT = "M";
    private final static String FINAL_FORMAT = "MMM";

    public static String formatMonth(int month) {
        SimpleDateFormat sdf1 = new SimpleDateFormat(INIT_FORMAT);
        Date date = null;

        try {
            date = sdf1.parse(String.valueOf(month));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        SimpleDateFormat sdf2 = new SimpleDateFormat(FINAL_FORMAT);
        String formattedMonth = sdf2.format(date);

        return formattedMonth;
    }
}
