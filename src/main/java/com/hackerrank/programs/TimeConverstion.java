package com.hackerrank.programs;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeConverstion {

    public static void main(String[] args) {
        
       
        String s = "07:05:45PM";
        DateFormat readFormat = new SimpleDateFormat( "hh:mm:ssa");
        DateFormat writeFormat = new SimpleDateFormat( "HH:mm:ss");
        Date date = null;
        try {
            date = readFormat.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String formattedDate = null;
        if (date != null) {
             formattedDate = writeFormat.format(date);
        }
        
        System.out.println(formattedDate);
    }

}
