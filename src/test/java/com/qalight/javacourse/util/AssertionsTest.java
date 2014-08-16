package com.qalight.javacourse.util;

import org.junit.Test;

public class AssertionsTest {

    @Test(expected = IllegalArgumentException.class)
    public void testAssertStringIsNull() throws Exception {
        //given
        final String DATA = null;
        //when
        Assertions.assertStringIsNotNullOrEmpty(DATA);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAssertStringIsEmpty() throws Exception {
        //given
        final String DATA = " ";
        //when
        Assertions.assertStringIsNotNullOrEmpty(DATA);
    }

    @Test
    public void testAssertStringIsNotNullOrEmpty() throws Exception {
        //given
        final String DATA = "index.html";
        //when
        Assertions.assertStringIsNotNullOrEmpty(DATA);
    }
}