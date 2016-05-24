package com.kingman.myresume;

import android.content.Context;

import java.util.Calendar;

/**
 * Created by wb-lijinwei.a on 2016/5/24.
 */
public class Utils {
    public static String getGreeting(Context context){
        // greeting
        String greeting = "";
        Calendar calendar = Calendar.getInstance();

        int minutes = calendar.get(Calendar.MINUTE) + 60 * calendar.get(Calendar.HOUR_OF_DAY);
        if ((0 <= minutes && minutes <= 5 * 60 + 29) || (18 * 60 + 29 < minutes && minutes <= 23 * 60 + 29)) {
            greeting = context.getString(R.string.home_device_greeting_goodevening);
        } else if (5 * 60 + 29 < minutes && minutes <= 8 * 60 + 29) {
            greeting = context.getString(R.string.home_device_greeting_goodmoring);
        } else if (8 * 60 + 29 < minutes && minutes <= 11 * 60 + 29) {
            greeting = context.getString(R.string.home_device_greeting_goodmoring2);
        } else if (11 * 60 + 29 < minutes && minutes <= 13 * 60 + 29) {
            greeting = context.getString(R.string.home_device_greeting_goodeafternoon);
        } else if (13 * 60 + 29 < minutes && minutes <= 18 * 60 + 29) {
            greeting = context.getString(R.string.home_device_greeting_goodeafternoon2);
        }
        return greeting;
    }
}
