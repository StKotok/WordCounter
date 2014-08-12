package com.qalight.javacourse.service;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by kpl on 12.08.2014.
 */
public class DocumentConverter {
    private static Set<DocumentToStringConverter> documentToStringConverters;
    static {
        documentToStringConverters = new HashSet<>();
        documentToStringConverters.add(new HtmlToStringConverter());
        documentToStringConverters.add(new XmlToStringConverter());
    }

    public DocumentToStringConverter getDocumentConverter(String sourceType) {
        DocumentToStringConverter documentConverter = null;
        for (DocumentToStringConverter documentToStringConverter : documentToStringConverters) {
            if (documentToStringConverter.isEligable(sourceType)) {
                documentConverter = documentToStringConverter;
                break;
            }
        }
        return documentConverter;
    }

}