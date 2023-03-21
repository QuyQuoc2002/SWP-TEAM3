/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.text.ParseException;
import java.util.*;
import java.text.SimpleDateFormat;

/**
 *
 * @author DELL
 */
public class Calendars {

    /**
     * Convert date to epoch timestamp
     *
     * @param date ex: 11/09/2002
     * @param formatDate ex: dd/MM/yyyy
     * @return epoch timestamp in local time ex: 1031677200
     * @throws ParseException
     */
    public static long toMillisecond(String date, String formatDate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(formatDate);
        Date d = sdf.parse(date);
        long millis = d.getTime();
        return millis / 1000;
    }

    /**
     * Get current timestamp
     *
     * @return current epoch timestamp
     */
    public static long getCurrentTime() {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Asia/Ho_Chi_Minh"));
        return calendar.getTimeInMillis() / 1000;
    }
    
    public static long getTimeLastYear() {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Asia/Ho_Chi_Minh"));
        calendar.add(Calendar.YEAR, -1);
        return calendar.getTimeInMillis() / 1000;
    }

    
    public static long getMonthLastYear() {
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Asia/Ho_Chi_Minh"));
        cal.add(Calendar.YEAR, -1);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        return cal.getTimeInMillis() / 1000;
    }
    
    public static int getYear(long times) {
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Asia/Ho_Chi_Minh"));
        cal.setTimeInMillis(times*1000);
        int year = cal.get(Calendar.YEAR);
        return year;
    }
    
    public static int getDay(long times) {
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Asia/Ho_Chi_Minh"));
        cal.setTimeInMillis(times*1000);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        return day;
    }
    
    public static int getNameMonthLastYear() {
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Asia/Ho_Chi_Minh"));
        cal.add(Calendar.YEAR, -1);
        int month = cal.get(Calendar.MONTH) + 2;
        return month;
    }
    
    public static boolean isLeapYear(int year) {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Asia/Ho_Chi_Minh"));
        calendar.set(Calendar.YEAR, year);
        int daysInYear = calendar.getActualMaximum(Calendar.DAY_OF_YEAR);
        return daysInYear > 365;
    }

    public static String formatTime(String timeFormat, long millisecond) {
        SimpleDateFormat isoFormat = new SimpleDateFormat(timeFormat);
        isoFormat.setTimeZone(TimeZone.getTimeZone("Asia/Ho_Chi_Minh"));
        String time = isoFormat.format(millisecond * 1000);
        return time;
    }
    
    public static void main(String[] args) {
    }

}
