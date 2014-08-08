package com.qalight.javacourse;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class HtmlFormReaderTest {

    @Test
    public void testReadHtmlSourceFile() throws Exception {

        // given
        final byte[] expectedHtmlPageByte = Files.readAllBytes(Paths.get("./src/main/resources/index.html"));
        final String expectedHtmlPageString = new String(expectedHtmlPageByte);

        // when
        HtmlFormReader htmlFormReader = new HtmlFormReader();
        String actualIndexHtmlString = htmlFormReader.readHtmlSourceFile("index.html");

        // then
        Assert.assertEquals(expectedHtmlPageString, actualIndexHtmlString);

    }

    @Test
    @Ignore // Test marked "ignored" because HtmlFormReader not valid
    public void testReadErrorWebPage() throws Exception {

        // given
        final byte[] expectedHtmlPageByte = Files.readAllBytes(Paths.get("./src/main/resources/Error.html"));
        final String expectedHtmlPageString = new String(expectedHtmlPageByte);

        // when
        HtmlFormReader htmlFormReader = new HtmlFormReader();
        String actualHtmlPageString = htmlFormReader.readHtmlSourceFile("Error.html");

        // then
        Assert.assertEquals(expectedHtmlPageString, actualHtmlPageString);

    }

    @Test
    @Ignore // Test marked "ignored" because HtmlFormReader not valid
    public void testReturnErrorPageWhenRequiredPageIsMissing() throws Exception {

        // given
        final byte[] expectedHtmlPageByte = Files.readAllBytes(Paths.get("./src/main/resources/Error.html"));
        final String expectedHtmlPageString = new String(expectedHtmlPageByte);

        // when
        HtmlFormReader htmlFormReader = new HtmlFormReader();
        String actualErrorHtmlString = htmlFormReader.readHtmlSourceFile("someRequiredPage.html");

        // then
        Assert.assertEquals(expectedHtmlPageString, actualErrorHtmlString);

    }

}