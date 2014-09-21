package com.qalight.javacourse;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

// todo: check only json response, not whole div with id 'ajaxResponse'
// todo: get rid of sleep() method - wait for response
public class WebFormTest {
    private static final String HTML_TEST_PAGE = "http://defas.com.ua/java/pageForSeleniumTest.html";
    private static final String PDF_TEST_PAGE = "http://defas.com.ua/java/textForSeleniumTest.pdf";
    private static final String CONTEXT = "/WordCounter/";
    private static final int TIME_WAIT = 3600;
    private static final int PORT = 8080;
    private static final String BASE_URL = "http://localhost:" + PORT + CONTEXT;;

    private WebDriver driver;

    @Before
    public void setUp() throws Exception {
        if (isMacOs()){
            driver = new SafariDriver();
        } else {
            driver = new FirefoxDriver();
        }
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    private boolean isMacOs() {
        boolean result = false;
        if (System.getProperty("os.name").toLowerCase().indexOf("mac") >= 0) {
            result = true;
        }
        return result;
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void testEmptyUrlRequest() throws Exception {
        // given
        driver.get(BASE_URL);

        // when
        driver.findElement(By.id("button")).click();
        sleep(TIME_WAIT);

        // then
        String actualResult = driver.findElement(By.id("ajaxResponse")).getText();
        String expectedResult = "Request is null or empty";

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testIncorrectUrl() throws Exception {
        // given
        driver.get(BASE_URL);

        // when
        driver.findElement(By.id("userUrlsList")).clear();
        driver.findElement(By.id("userUrlsList")).sendKeys(HTML_TEST_PAGE + "a");
        driver.findElement(By.id("button")).click();
        sleep(TIME_WAIT);

        // then
        String actualResult = driver.findElement(By.id("ajaxResponse")).getText();
        final String expectedResult = "Can't connect to: http://defas.com.ua/java/pageForSeleniumTest.htmla";
        assertTrue(actualResult.contains(expectedResult));
    }

    @Test
    public void testSortingKeyAscending() throws Exception {
        // given
        driver.get(BASE_URL);

        // when
        driver.findElement(By.id("userUrlsList")).clear();
        driver.findElement(By.id("userUrlsList")).sendKeys(HTML_TEST_PAGE);
        driver.findElement(By.id("button")).click();
        driver.findElement(By.className("sorting")).click();
        sleep(TIME_WAIT);

        //then
        String actualSortingKeyAscending = driver.findElement(By.id("ajaxResponse")).getText();
        assertTrue(actualSortingKeyAscending.contains(EXPECTED_SORTING_KEY_ASCENDING));
    }

    @Test
    public void testSortingValueAscending() throws Exception {
        // given
        driver.get(BASE_URL);

        // when
        driver.findElement(By.id("userUrlsList")).clear();
        driver.findElement(By.id("userUrlsList")).sendKeys(HTML_TEST_PAGE);
        driver.findElement(By.id("button")).click();
        driver.findElement(By.className("sorting_desc")).click();
        sleep(TIME_WAIT);

        // then
        String actualSortingValueAscending = driver.findElement(By.id("ajaxResponse")).getText();
        assertTrue(actualSortingValueAscending.contains(EXPECTED_SORTING_VALUE_ASCENDING));
    }

    @Test
    public void testSortingKeyDescending() throws Exception {
        // given
        driver.get(BASE_URL);

        // when
        driver.findElement(By.id("userUrlsList")).clear();
        driver.findElement(By.id("userUrlsList")).sendKeys(HTML_TEST_PAGE);
        driver.findElement(By.id("button")).click();
        driver.findElement(By.className("sorting")).click();
        driver.findElement(By.className("sorting")).click();
        sleep(TIME_WAIT);

        // then
        String actualSortingKeyDescending = driver.findElement(By.id("ajaxResponse")).getText();
        assertTrue(actualSortingKeyDescending.contains(EXPECTED_SORTING_KEY_DESCENDING));
    }

    @Test
    public void testSortingValueDescending() throws Exception {
        // given
        driver.get(BASE_URL);

        // when
        driver.findElement(By.id("userUrlsList")).clear();
        driver.findElement(By.id("userUrlsList")).sendKeys(HTML_TEST_PAGE);
        driver.findElement(By.id("button")).click();
        sleep(TIME_WAIT);

        // then
        String actualSortingValueDescending = driver.findElement(By.id("ajaxResponse")).getText();
        assertTrue(actualSortingValueDescending.contains(EXPECTED_SORTING_VALUE_DESCENDING));
    }

    @Test
    public void testSearchWord() throws Exception {
        // given
        driver.get(BASE_URL);

        // when
        driver.findElement(By.id("userUrlsList")).clear();
        driver.findElement(By.id("userUrlsList")).sendKeys(HTML_TEST_PAGE);
        driver.findElement(By.id("button")).click();
        driver.findElement(By.cssSelector("input[type=\"search\"]")).clear();
        driver.findElement(By.cssSelector("input[type=\"search\"]")).sendKeys("білка");
        sleep(TIME_WAIT);

        // then
        String actualSearchWord = driver.findElement(By.id("ajaxResponse")).getText();
        assertTrue(actualSearchWord.contains(EXPECTED_SEARCH_WORD));
    }

    @Test
    @Ignore
    public void testNextResponse() throws Exception {
        // given
        driver.get(BASE_URL);

        // when
        driver.findElement(By.id("userUrlsList")).clear();
        driver.findElement(By.id("userUrlsList")).sendKeys(HTML_TEST_PAGE);
        driver.findElement(By.id("button")).click();
        sleep(TIME_WAIT);
        driver.findElement(By.linkText("Next")).click();

        // then
        String actualNextResponse = driver.findElement(By.id("ajaxResponse")).getText();
        assertTrue(actualNextResponse.contains(EXPECTED_NEXT_RESPONSE));
    }

    @Test
    public void testPreviousResponse() throws Exception {
        // given
        driver.get(BASE_URL);

        // when
        driver.findElement(By.id("userUrlsList")).clear();
        driver.findElement(By.id("userUrlsList")).sendKeys(HTML_TEST_PAGE);
        driver.findElement(By.id("button")).click();
        sleep(TIME_WAIT);
        driver.findElement(By.linkText("Next")).click();
        driver.findElement(By.linkText("Previous")).click();

        // then
        String actualPreviousResponse = driver.findElement(By.id("ajaxResponse")).getText();
        assertTrue(actualPreviousResponse.contains(EXPECTED_PREVIOUS_RESPONSE));
    }

    @Test
    public void testShowEntries() throws Exception {
        // given
        driver.get(BASE_URL);

        // when
        driver.findElement(By.id("userUrlsList")).clear();
        driver.findElement(By.id("userUrlsList")).sendKeys(HTML_TEST_PAGE);
        driver.findElement(By.id("button")).click();
        sleep(TIME_WAIT);
        new Select(driver.findElement(By.name("example_length"))).selectByVisibleText("25");

        // then
        String actualShowEntries = driver.findElement(By.id("ajaxResponse")).getText();
        assertTrue(actualShowEntries.contains(EXPECTED_SHOW_ENTRIES));
    }

    @Test
    public void testInputText() throws Exception {
        // given
        driver.get(BASE_URL);

        // when
        driver.findElement(By.id("userUrlsList")).clear();
        driver.findElement(By.id("userUrlsList")).sendKeys(TEXT);
        driver.findElement(By.id("button")).click();
        sleep(TIME_WAIT);

        // then
        String actualInputText = driver.findElement(By.id("ajaxResponse")).getText();
        assertTrue(actualInputText.contains(EXPECTED_INPUT_TEXT));
    }

    @Test
    public void testReadingPDF() throws Exception {
        // given
        driver.get(BASE_URL);

        // when
        driver.findElement(By.id("userUrlsList")).clear();
        driver.findElement(By.id("userUrlsList")).sendKeys(PDF_TEST_PAGE);
        driver.findElement(By.id("button")).click();
        driver.findElement(By.className("sorting")).click();
        sleep(TIME_WAIT);

        //then
        String actualReadingPDF = driver.findElement(By.id("ajaxResponse")).getText();
        assertTrue(actualReadingPDF.contains(EXPECTED_READING_PDF));
    }

    private static final String EXPECTED_READING_PDF =
            "http://habrahabr.ru/posts/top/weekly/ 1\n" +
            "https://www.google.com.ua/search?q=java+pattern+compile+split&oq=%D0%BE 1\n" +
                    "vkamenniy@gmail.com 1\n" +
                    "dbdbddbaqschromeijljjsourc 1\n" +
                    "ddbcdpatterncompiledb 1\n" +
                    "eidchromeessmieutf 1\n" +
            "one 4\n" +
            "two 3\n" +
            "білка 3\n" +
            "время 1\n" +
            "Showing 1 to 10 of 24 entries\n" +
            "Previous\n" +
            "1\n" +
            "2\n" +
            "3\n" +
            "Next";


    private static final String EXPECTED_INPUT_TEXT =
            "one 4\n" +
            "ёлка 3\n" +
            "two 3\n" +
            "білка 3\n" +
            "объем 3\n" +
            "їжак 2\n" +
            "объём 1\n" +
            "дом 1\n" +
            "друг 1\n" +
            "єнот 1\n" +
            "Showing 1 to 10 of 18 entries\n" +
            "Previous\n" +
            "1\n" +
            "2\n" +
            "Next";

    private static final String TEXT = "a One, the one ONE oNE  Two  two, two!@#$%^&*()_+=!123456789\n" +
            "\n" +
            "ёлка і Ёлка та ёлКА: ОБЪЁМ объем обЪем, але, но объем сказал завет человек время, имя, ученики, дом, друг, народ, слово, \n" +
            "\n" +
            "Їжак їжак єнот білка БІЛКА БіЛкА ";

    private static final String EXPECTED_SHOW_ENTRIES =
            "one 4\n" +
                    "ёлка 3\n" +
            "two 3\n" +
            "білка 3\n" +
                    "объем 3\n" +
            "їжак 2\n" +
                    "vkamenniy@gmail.com 1\n" +
            "объём 1\n" +
            "дом 1\n" +
            "http://habrahabr.ru/posts/top/weekly/ 1\n" +
                    "друг 1\n" +
                    "єнот 1\n" +
            "https://www.google.com.ua/search?q=java+pattern+compile+split&oq=%D0%BE%D1%84%D0%BC%D1%84+Pattern.compile+%D1%8B%D0%B7%D0%B4%D1%88%D0%B5+&aqs=chrome.2.69i57j0l2.14141j0j7&sourceid=chrome&es_sm=93&ie=UTF-8 1\n" +
                    "время 1\n" +
                    "человек 1\n" +
                    "народ 1\n" +
            "ученики 1\n" +
            "завет 1\n" +
            "имя 1\n" +
            "слово 1\n" +
            "сказал 1\n" +
                    "Showing 1 to 21 of 21 entries\n" +
            "Previous\n" +
            "1\n" +
            "Next";

    private static final String EXPECTED_PREVIOUS_RESPONSE =
            "one 4\n" +
                    "ёлка 3\n" +
            "two 3\n" +
            "білка 3\n" +
                    "объем 3\n" +
            "їжак 2\n" +
                    "vkamenniy@gmail.com 1\n" +
            "объём 1\n" +
            "дом 1\n" +
                    "http://habrahabr.ru/posts/top/weekly/ 1\n" +
                    "Showing 1 to 10 of 21 entries\n" +
            "Previous\n" +
            "1\n" +
            "2\n" +
            "3\n" +
            "Next";

    private static final String EXPECTED_NEXT_RESPONSE =
            "one 4\n" +
                    "ёлка 3\n" +
                    "two 3\n" +
                    "білка 3\n" +
                    "объем 3\n" +
                    "їжак 2\n" +
                    "vkamenniy@gmail.com 1\n" +
                    "объём 1\n" +
                    "дом 1\n" +
            "http://habrahabr.ru/posts/top/weekly/ 1\n" +
                    "Showing 1 to 10 of 21 entries\n" +
            "Previous\n" +
            "1\n" +
            "2\n" +
            "3\n" +
            "Next";

    private static final String EXPECTED_SEARCH_WORD =
            "білка 3\n" +
                    "Showing 1 to 1 of 1 entries (filtered from 21 total entries)\n" +
            "Previous\n" +
            "1\n" +
            "Next";

    private static final String EXPECTED_SORTING_KEY_ASCENDING =
            "http://habrahabr.ru/posts/top/weekly/ 1\n" +
            "https://www.google.com.ua/search?q=java+pattern+compile+split&oq=%D0%BE%D1%84%D0%BC%D1%84+Pattern.compile+%D1%8B%D0%B7%D0%B4%D1%88%D0%B5+&aqs=chrome.2.69i57j0l2.14141j0j7&sourceid=chrome&es_sm=93&ie=UTF-8 1\n" +
                    "vkamenniy@gmail.com 1\n" +
            "one 4\n" +
            "two 3\n" +
            "білка 3\n" +
            "время 1\n" +
            "дом 1\n" +
                    "друг 1\n" +
            "завет 1\n" +
                    "Showing 1 to 10 of 21 entries\n" +
            "Previous\n" +
            "1\n" +
            "2\n" +
            "3\n" +
            "Next";

    private static final String EXPECTED_SORTING_VALUE_ASCENDING =
            "vkamenniy@gmail.com 1\n" +
            "объём 1\n" +
            "дом 1\n" +
            "http://habrahabr.ru/posts/top/weekly/ 1\n" +
                    "друг 1\n" +
                    "єнот 1\n" +
            "https://www.google.com.ua/search?q=java+pattern+compile+split&oq=%D0%BE%D1%84%D0%BC%D1%84+Pattern.compile+%D1%8B%D0%B7%D0%B4%D1%88%D0%B5+&aqs=chrome.2.69i57j0l2.14141j0j7&sourceid=chrome&es_sm=93&ie=UTF-8 1\n" +
                    "время 1\n" +
                    "человек 1\n" +
                    "народ 1\n" +
                    "Showing 1 to 10 of 21 entries\n" +
            "Previous\n" +
            "1\n" +
            "2\n" +
            "3\n" +
            "Next";

    private static final String EXPECTED_SORTING_KEY_DESCENDING =
            "http://habrahabr.ru/posts/top/weekly/ 1\n" +
            "https://www.google.com.ua/search?q=java+pattern+compile+split&oq=%D0%BE%D1%84%D0%BC%D1%84+Pattern.compile+%D1%8B%D0%B7%D0%B4%D1%88%D0%B5+&aqs=chrome.2.69i57j0l2.14141j0j7&sourceid=chrome&es_sm=93&ie=UTF-8 1\n" +
                    "vkamenniy@gmail.com 1\n" +
            "время 1\n" +
            "дом 1\n" +
                    "друг 1\n" +
            "завет 1\n" +
            "имя 1\n" +
                    "народ 1\n" +
            "объём 1\n" +
                    "Showing 1 to 10 of 21 entries\n" +
            "Previous\n" +
            "1\n" +
            "2\n" +
            "3\n" +
            "Next";

    private static final String EXPECTED_SORTING_VALUE_DESCENDING =
            "one 4\n" +
                    "ёлка 3\n" +
            "two 3\n" +
            "білка 3\n" +
                    "объем 3\n" +
            "їжак 2\n" +
                    "vkamenniy@gmail.com 1\n" +
            "объём 1\n" +
            "дом 1\n" +
                    "http://habrahabr.ru/posts/top/weekly/ 1\n" +
                    "Showing 1 to 10 of 21 entries\n" +
            "Previous\n" +
            "1\n" +
            "2\n" +
            "3\n" +
            "Next";
}