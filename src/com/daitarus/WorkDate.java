package com.daitarus;

import java.util.Date;
import java.text.*;

public class WorkDate {

    private Date date;

    //getDate
    public String getDate(){
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd.MM.yyyy");
        return formatForDateNow.format(this.date);
    }
    public String getDate(String pattern){
        SimpleDateFormat formatForDateNow = new SimpleDateFormat(pattern);
        return formatForDateNow.format(this.date);
    }

    //setDate
    public boolean setDate(String dateS){
        SimpleDateFormat formatForDate = new SimpleDateFormat ("dd.MM.yyyy");
        try {
            this.date = formatForDate.parse(dateS);
            return true;
        }catch (ParseException e) {
            return false;
        }
    }
    public boolean setDate(String dateS,String pattern){
        SimpleDateFormat formatForDate = new SimpleDateFormat (pattern);
        try {
            this.date = formatForDate.parse(dateS);
            return true;
        }catch (ParseException e) {
            return false;
        }
    }

    //getNowDate
    public static String  getNowDate(){
        Date dateG = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd.MM.yyyy");
        return formatForDateNow.format(dateG);
    }

    //getNowTime
    public static String getNowTime(){
        Date dateG = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("hh:mm:ss");
        return formatForDateNow.format(dateG);
    }
    public static String getNowTime(String pattern){
        Date dateG = new Date();
        SimpleDateFormat formatForDateNow;
        formatForDateNow = new SimpleDateFormat(pattern);
        return formatForDateNow.format(dateG);
    }
}
