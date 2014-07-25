package com.qalight.javacourse;

import java.util.*;

/**
 * Created by stkotok on 19.07.2014.
 */
public class StringUrlsParser {

    public List<String> urlList(String stringUrls) {

        final String delim = ", ";
        List<String> userCheckUrlsList = new ArrayList<String>(Arrays.asList(stringUrls.split(delim)));
        List<String> userUrlsList = new ArrayList<String>();

        for (String url : userCheckUrlsList) {
            if (url.startsWith("http://")) {
                userUrlsList.add(url);
            } else if (url.startsWith("https://")) {
                userUrlsList.add("I can't read https");
            } else {
                userUrlsList.add("http://" + url);
            }
        }
        System.out.println("userUrlsList: " + userUrlsList);
        return userUrlsList;
    }

}
