package com.qalight.javacourse.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class JsonResultPresentationTest {
    private JsonResultPresentation jsonResultPresentation;

    @Before
    public void setUp() {
        jsonResultPresentation = new JsonResultPresentation();
    }

    @Test
    public void isEligible_json() {
        //given
        final String TYPE = "json";

        //when
        boolean actualResult = jsonResultPresentation.isEligible(TYPE);

        //then
        Assert.assertTrue(actualResult);
    }

    @Test
    public void isEligible_gif() {
        //given
        final String TYPE = "gif";

        //when
        boolean actualResult = jsonResultPresentation.isEligible(TYPE);

        //then
        Assert.assertFalse(actualResult);
    }

    @Test
    public void testCreateResponse() throws Exception {
        //given
        final String expectedJsonResponse = "{\"success\":true,\"unFilteredWords\":[[\"Project\",\"24\"],[\"Word\",\"13\"],[\"Counter\",\"5\"],[\"Hello\",\"10\"],[\"World\",\"7\"]]}";

        final Map<String, Integer> unFilteredCountedWords = new HashMap<>();
        unFilteredCountedWords.put("Hello", 10);
        unFilteredCountedWords.put("World", 7);
        unFilteredCountedWords.put("Word", 13);
        unFilteredCountedWords.put("Counter", 5);
        unFilteredCountedWords.put("Project", 24);

        //when
        String actualJsonResponse = jsonResultPresentation.createResponse(unFilteredCountedWords);

        //then
        Assert.assertEquals(expectedJsonResponse, actualJsonResponse);
    }

    //todo fix test
    @Test
    public void testCreateErrorResponse() throws Exception {
        //given
        String expectedJsonResponse = "{\"respMessage\":\"WordCounter Exception: results collection should not be null\"}";

        //when
        Throwable e = new IllegalArgumentException("results collection should not be null");
        String actualJsonResponse = jsonResultPresentation.createErrorResponse(e);

        //then
        Assert.assertEquals(expectedJsonResponse, actualJsonResponse);
    }
}