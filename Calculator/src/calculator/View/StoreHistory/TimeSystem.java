/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GetTime;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.SimpleTimeZone;

/**
 *
 * @author lenovo i3
 */
public class TimeSystem {

    public Time getTimeInSystem() throws ParseException {
        Time today = new Time(System.currentTimeMillis());
        int hour = 0;
        int m = 0;
        int s = 0;
        hour = today.getHours();
        m = today.getMinutes();
        s = today.getSeconds();
        return today;
    }

    public String getDateInSystem() throws ParseException {
        Date today = new Date(System.currentTimeMillis());
        SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
        String date = dateformat.format(today);
        return date;
    }

    public static void main(String[] args) throws ParseException {
        TimeSystem lc = new TimeSystem();
        System.out.println(lc.getTimeInSystem());
        System.out.println(lc.getDateInSystem());
    }
}
