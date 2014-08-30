package com.qalight.javacourse.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by pavelkulakovsky on 27.08.14.
 */
@Component
public class ResultPresentationImpl {
    private static final Logger LOG = LoggerFactory.getLogger(ResultPresentationImpl.class);

    private static Set<ResultPresentation> resultPresentations;
    static {
        resultPresentations = new HashSet<>();
        resultPresentations.add(new JsonResultPresentation());
    }
    public ResultPresentation getResultPresentation(String dataTypeResponse) {
        if (dataTypeResponse == null) {
            throw new IllegalArgumentException("dataTypeResponse is Null");
        }

        ResultPresentation resultPresentation = null;
        for (ResultPresentation currentResultPresentation : resultPresentations) {
            if (currentResultPresentation.isEligible(dataTypeResponse)) {
                resultPresentation = currentResultPresentation;
                break;
            }
        }
        return resultPresentation;
    }

}
