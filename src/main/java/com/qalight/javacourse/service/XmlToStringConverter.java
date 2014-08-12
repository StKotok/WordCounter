package com.qalight.javacourse.service;

/**
 * Created by kpl on 09.08.2014.
 */
public class XmlToStringConverter implements DocumentToStringConverter {

    private final String DOCUMENT_TYPE = "xml";
    @Override
    public Boolean isEligable(String documentType) {
        return documentType.equalsIgnoreCase(DOCUMENT_TYPE);
    }

    @Override
    public String convertToString(String userUrl) {

        //todo: implementation:

        return userUrl;
    }
}