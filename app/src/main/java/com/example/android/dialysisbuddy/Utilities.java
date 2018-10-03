package com.example.android.dialysisbuddy;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by alfredchang on 2018-01-30.
 */

public class Utilities {

    public static String formatMonth(int month) {
        final String INIT_FORMAT = "M";
        final String FINAL_FORMAT = "MMM";

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

    public static StringBuilder formatTime(int hour, int minute) {
        String format;

        if (hour == 0) {
            hour += 12;
            format = "AM";
        } else if (hour == 12) {
            format = "PM";
        } else if (hour > 12) {
            hour -= 12;
            format = "PM";
        } else {
            format = "AM";
        }

        if (minute >= 0 && minute <= 9) {
            String formattedMinute = String.valueOf(minute);
            formattedMinute = "0" + formattedMinute;
            return new StringBuilder().append(hour).append(":").append(formattedMinute).append(format);
        }

        return new StringBuilder().append(hour).append(":").append(minute).append(format);
    }

    // TODO.
    public static boolean isPastDate(int day, int time) {
        boolean isPast = false;

        // Get current date.


        // Get current time.


        // Check if parameters are past current date and time.

        return isPast;
    }
}
