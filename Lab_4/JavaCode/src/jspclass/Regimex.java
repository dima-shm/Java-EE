package jspclass;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Regimex {
    protected String Result = "";
    protected Date mDate = new Date();
    private Calendar mCalendar;

    public Regimex(Calendar calendar) {
        mCalendar = calendar;
    }

    public Regimex() {
        mCalendar = Calendar.getInstance();
    }

    public int getHours() {
        return mCalendar.get(Calendar.HOUR_OF_DAY);
    }

    public int getMinutes() {
        return mCalendar.get(Calendar.MINUTE);
    }

    public int getSeconds() {
        return mCalendar.get(Calendar.SECOND);
    }

    public int getDay() {
        return mCalendar.get(Calendar.DATE);
    }

    public int getMonth() {
            return mCalendar.get(Calendar.MONTH);
    }

    public int getYear() {
            return mCalendar.get(Calendar.YEAR);
    }

    public String getDayByDate(int day, int month, int year) {
        String dateString = String.format("%d-%d-%d", day, month, year);
        Date date = null;
        try {
            date = new SimpleDateFormat("d-M-yyyy").parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String dayOfWeek = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(date);
        return dayOfWeek;
    }

}
