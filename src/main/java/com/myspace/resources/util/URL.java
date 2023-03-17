package com.myspace.resources.util;

import java.net.URLDecoder;
import java.nio.charset.Charset;

public class URL {
    public static String decodeParam(String text) {
        try{
            return URLDecoder.decode(text, Charset.forName("UTF-8"));
        } catch (IllegalArgumentException e) {
            return "";
        }
    }
}
