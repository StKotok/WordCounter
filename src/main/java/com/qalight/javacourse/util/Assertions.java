package com.qalight.javacourse.util;

import java.util.List;

public class Assertions {
    public static void assertStringIsNotNullOrEmpty(String str) {
        if (str == null || str.trim().length() < 1) {
            throw new IllegalArgumentException("Request is null or empty");
        }
    }

    public static void assertObjectIsNotNull(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("Object is null");
        }
    }

    public static void assertListIsNotEmpty(List list, String clientRequest){
        if (list.isEmpty()) {
           throw new IllegalArgumentException("System cannot count entered text {" + clientRequest +"}. " +
                   "Did you forget to add 'http://' to the link or entered not readable text?");
        }
    }
}