package com.example.android.dialysisbuddy;

import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by alfredchang on 2018-01-30.
 */

public class Utilities {

    private static final String LOG_TAG = Utilities.class.getSimpleName();

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
        return sdf2.format(date);
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

    // TODO -- must be callback.
    public static boolean isPastDate(String date, String hour, String minute) {
        boolean isPast = false;

        Log.v(LOG_TAG, "Complete date: " + date);

        // Get current date.
        Calendar calendar = Calendar.getInstance();
        TimeZone localTimeZone = TimeZone.getDefault();
        calendar.setTimeZone(localTimeZone);

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        int ampm = calendar.get(Calendar.AM_PM);

        // Get current time.
        int currentHour = calendar.get(Calendar.HOUR);
        int currentMinute = calendar.get(Calendar.MINUTE);

        String currentTime = month + " " + dayOfMonth + ", " + year + " " + currentHour + ":"
                + currentMinute + " " + ampm;
        Date parameterTime = new Date(date + " " + hour + ":" + minute + " ");

        // Check if parameters are past current date and time.
        try {
            isPast = new SimpleDateFormat("MMM dd, yyyy hh:mm aaa").parse(currentTime).after(parameterTime);
        } catch (ParseException e) {
            Log.v(LOG_TAG, "Could not parse simple date format.");
        }

        return isPast;
    }
}
