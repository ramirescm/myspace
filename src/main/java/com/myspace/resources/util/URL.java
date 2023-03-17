package com.myspace.resources.util;

import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class URL {
    public static String decodeParam(String text) {
        try{
            return URLDecoder.decode(text, Charset.forName("UTF-8"));
        } catch (IllegalArgumentException e) {
            return "";
        }
    }

    public static Date convertDate(String textDate, Date defaulValue) {
        try {
            var sdf = new SimpleDateFormat("yyyy-MM-dd");
            sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
            return sdf.parse(textDate);
        } catch (ParseException e){
            return defaulValue;
        }
    }
}
