package com.qalight.javacourse.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ResultPresentationServiceTest {
    private ResultPresentationService resultPresentationService;

    @Before
    public void setup() {
        resultPresentationService = new ResultPresentationService();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetResultPresentation_null() {
        //given
        final String dataTypeResponse = null;

        //when
        resultPresentationService.getResultPresentation(dataTypeResponse);

        //then
        //expected exception
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetResultPresentation_empty() {
        //given
        final String dataTypeResponse = "";

        //when
        resultPresentationService.getResultPresentation(dataTypeResponse);

        //then
        //expected exception
    }

    @Test
    public void testGetResultPresentation() throws Exception {
        //given
        final String DATA_TYPE = "json";

        //when
        ResultPresentation resultPresentation = resultPresentationService.getResultPresentation(DATA_TYPE);

        //then
        Assert.assertTrue(resultPresentation instanceof JsonResultPresentation);
    }

    @Test(expected = RuntimeException.class)
    public void testNonExistingType() {
        // given
        final String NON_EXISTING_TYPE = "gif";

        //when
        resultPresentationService.getResultPresentation(NON_EXISTING_TYPE);

        //then
        //expected exception
    }
}