package com.qalight.javacourse.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ResponseHeaderGetter {
    private static final String PLAIN_TEXT_TYPE = "plain";
    private static final Logger LOG = LoggerFactory.getLogger(ResponseHeaderGetter.class);
    private static final Pattern URL = Pattern.compile("^(https?://)?([\\da-z\\.-]+)\\.([a-z\\.]{2,6})([/\\w \\.-/%]*)*/?$");


    public String getTextTypeByHttpHeader(String userRequest) {
        checkForNullOrEmpty(userRequest);

        Matcher matcher = URL.matcher(userRequest);

        String contentType;

        if(matcher.matches()) {
            contentType = getType(userRequest);
        } else {
            contentType = PLAIN_TEXT_TYPE;
        }
        return contentType;
    }

    private String getType(String url){
        String contentType;
        try {
            URL obj = new URL(url);
            URLConnection conn = obj.openConnection();
            Map<String, List<String>> map = conn.getHeaderFields();
            contentType = String.valueOf(map.get("Content-Type"));
        } catch (Exception e) {
            String msg = " Text type is not defined.";
            LOG.error(url + msg, e);
            throw new IllegalArgumentException(url + msg, e);
        }
        return contentType;
    }
    private void checkForNullOrEmpty(String userRequest) {
        if (userRequest == null) {
            LOG.error("\"userRequest\"  parameter is NULL");
            throw new IllegalArgumentException(
                    "Text type is not defined because the link is null.");
        }

        if (userRequest.equals("")) {
            LOG.error("\"userRequest\"  parameter is empty.");
            throw new IllegalArgumentException(
                    "Text type is not defined because the link is empty.");
        }
    }
}