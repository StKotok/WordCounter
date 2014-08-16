package com.qalight.javacourse.service;

import java.util.HashSet;
import java.util.Set;


public class DocumentConverter {
    private static Set<DocumentToStringConverter> documentToStringConverters;
    static {
        documentToStringConverters = new HashSet<>();
        documentToStringConverters.add(new HtmlToStringConverter());
        documentToStringConverters.add(new XmlToStringConverter());
    }
    public DocumentToStringConverter getDocumentConverter(TextType sourceType) {
        DocumentToStringConverter documentConverter = null;
        for (DocumentToStringConverter documentToStringConverter : documentToStringConverters) {
            if (documentToStringConverter.isEligible(sourceType)) {
                documentConverter = documentToStringConverter;
                break;
            }
        }
        return documentConverter;
    }

}
