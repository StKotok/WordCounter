import com.qalight.javacourse.service.WordCounterServiceImpl;
import org.junit.Assert;
import org.junit.Test;

public class WordCounterServiceImplTest {

    private final String HTML_TEST_PAGE = "http://defas.com.ua/java/pageForSeleniumTest.html";

    @Test
    public void testGetWordCounterResult_okUrl_KeyAscSort_JsonResp() {
        // given
        final String sortingParam = "KEY_ASCENDING";
        final String dataTypeResponse = "JSON";
        final String expectedResult = "{\"success\":true,\"response\":[[{\"hash\":110183,\"key\":\"one\",\"value\":4},{\"hash\":114,\"key\":\"r\",\"value\":1},{\"hash\":115277,\"key\":\"two\",\"value\":3},{\"hash\":810938485,\"key\":\"ааббввггддееёёжжззииййккллммннооппррссттууффххццччшшщщъъыыььээююяя\",\"value\":1,\"next\":{\"hash\":34085349,\"key\":\"єнот\",\"value\":1,\"next\":{\"hash\":1025097045,\"key\":\"білка\",\"value\":3}}},{\"hash\":1044630083,\"key\":\"ааббввггґґддееєєжжззииііїїййккллммннооппррссттууффххццччшшщщььююяя\",\"value\":1},{\"hash\":1025097045,\"key\":\"білка\",\"value\":3},{\"hash\":1036003870,\"key\":\"объем\",\"value\":3},{\"hash\":1036002946,\"key\":\"объём\",\"value\":1,\"next\":{\"hash\":114,\"key\":\"r\",\"value\":1}},{\"hash\":33993926,\"key\":\"ёлка\",\"value\":3},{\"hash\":34085349,\"key\":\"єнот\",\"value\":1,\"next\":{\"hash\":1025097045,\"key\":\"білка\",\"value\":3}},{\"hash\":34168576,\"key\":\"їжак\",\"value\":2}]],\"listUsersUrls\":[\"http://defas.com.ua/java/pageForSeleniumTest.html\"],\"dataTypeResponse\":\"JSON\"}";

        // when
        WordCounterServiceImpl wordCounterService = new WordCounterServiceImpl();
        String actualResult = wordCounterService.getWordCounterResult(HTML_TEST_PAGE, sortingParam, dataTypeResponse);

        // then
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testGetWordCounterResult_emptyUrl_KeyAscSort_JsonResp() {
        // given
        final String clientRequestEmptyUrl = "";
        final String sortingParam = "KEY_ASCENDING";
        final String dataTypeResponse = "JSON";
        final Exception expectedException = new IllegalArgumentException("str is null or empty");

        // when
        WordCounterServiceImpl wordCounterService = new WordCounterServiceImpl();
        Exception actualException = null;
        try {
            wordCounterService.getWordCounterResult(clientRequestEmptyUrl, sortingParam, dataTypeResponse);
        } catch (IllegalArgumentException e) {
            actualException = e;
        }

        // then
        if (actualException != null) {
            Assert.assertEquals(expectedException.toString(), actualException.toString());
        } else {
            Assert.assertFalse(true);
        }
    }

    @Test
    public void testGetWordCounterResult_InvalidUrl_KeyAscSort_JsonResp() {
        // given
        final String clientRequestInvalidUrl = "http://95.158.60.148:8008/kpl/testingPageINVALID.html";
        final String sortingParam = "KEY_ASCENDING";
        final String dataTypeResponse = "JSON";
        final String expctedExceptionString = "java.lang.RuntimeException: Can't connect to: http://95.158.60.148:8008/kpl/testingPageINVALID.html";

        // when
        WordCounterServiceImpl wordCounterService = new WordCounterServiceImpl();
        Exception actualException = null;
        try {
            wordCounterService.getWordCounterResult(clientRequestInvalidUrl, sortingParam, dataTypeResponse);
        } catch (RuntimeException e) {
            actualException = e;
        }

        // then
        if (actualException != null) {
            Assert.assertEquals(expctedExceptionString, actualException.toString());
        } else {
            Assert.assertFalse(true);
        }
    }

    @Test
    public void testGetWordCounterResult_okUrl_KeyDescSort_JsonResp() {
        // given
        final String sortingParam = "KEY_DESCENDING";
        final String dataTypeResponse = "JSON";
        final String expectedResult = "{\"success\":true,\"response\":[[{\"hash\":34168576,\"key\":\"їжак\",\"value\":2},{\"hash\":34085349,\"key\":\"єнот\",\"value\":1,\"next\":{\"hash\":1025097045,\"key\":\"білка\",\"value\":3}},{\"hash\":33993926,\"key\":\"ёлка\",\"value\":3},{\"hash\":1036002946,\"key\":\"объём\",\"value\":1,\"next\":{\"hash\":114,\"key\":\"r\",\"value\":1}},{\"hash\":1036003870,\"key\":\"объем\",\"value\":3},{\"hash\":1025097045,\"key\":\"білка\",\"value\":3},{\"hash\":1044630083,\"key\":\"ааббввггґґддееєєжжззииііїїййккллммннооппррссттууффххццччшшщщььююяя\",\"value\":1},{\"hash\":810938485,\"key\":\"ааббввггддееёёжжззииййккллммннооппррссттууффххццччшшщщъъыыььээююяя\",\"value\":1,\"next\":{\"hash\":34085349,\"key\":\"єнот\",\"value\":1,\"next\":{\"hash\":1025097045,\"key\":\"білка\",\"value\":3}}},{\"hash\":115277,\"key\":\"two\",\"value\":3},{\"hash\":114,\"key\":\"r\",\"value\":1},{\"hash\":110183,\"key\":\"one\",\"value\":4}]],\"listUsersUrls\":[\"http://defas.com.ua/java/pageForSeleniumTest.html\"],\"dataTypeResponse\":\"JSON\"}";

        // when
        WordCounterServiceImpl wordCounterService = new WordCounterServiceImpl();
        String actualResult = wordCounterService.getWordCounterResult(HTML_TEST_PAGE, sortingParam, dataTypeResponse);

        // then
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testGetWordCounterResult_okUrl_ValAscSort_JsonResp() {
        // given
        final String sortingParam = "VALUE_ASCENDING";
        final String dataTypeResponse = "JSON";
        final String expectedResult = "{\"success\":true,\"response\":[[{\"hash\":1036002946,\"key\":\"объём\",\"value\":1,\"next\":{\"hash\":114,\"key\":\"r\",\"value\":1}},{\"hash\":114,\"key\":\"r\",\"value\":1},{\"hash\":1044630083,\"key\":\"ааббввггґґддееєєжжззииііїїййккллммннооппррссттууффххццччшшщщььююяя\",\"value\":1},{\"hash\":810938485,\"key\":\"ааббввггддееёёжжззииййккллммннооппррссттууффххццччшшщщъъыыььээююяя\",\"value\":1,\"next\":{\"hash\":34085349,\"key\":\"єнот\",\"value\":1,\"next\":{\"hash\":1025097045,\"key\":\"білка\",\"value\":3}}},{\"hash\":34085349,\"key\":\"єнот\",\"value\":1,\"next\":{\"hash\":1025097045,\"key\":\"білка\",\"value\":3}},{\"hash\":34168576,\"key\":\"їжак\",\"value\":2},{\"hash\":1025097045,\"key\":\"білка\",\"value\":3},{\"hash\":33993926,\"key\":\"ёлка\",\"value\":3},{\"hash\":115277,\"key\":\"two\",\"value\":3},{\"hash\":1036003870,\"key\":\"объем\",\"value\":3},{\"hash\":110183,\"key\":\"one\",\"value\":4}]],\"listUsersUrls\":[\"http://defas.com.ua/java/pageForSeleniumTest.html\"],\"dataTypeResponse\":\"JSON\"}";

        // when
        WordCounterServiceImpl wordCounterService = new WordCounterServiceImpl();
        String actualResult = wordCounterService.getWordCounterResult(HTML_TEST_PAGE, sortingParam, dataTypeResponse);

        // then
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testGetWordCounterResult_okUrl_ValDescSort_JsonResp() {
        // given
        final String sortingParam = "VALUE_DESCENDING";
        final String dataTypeResponse = "JSON";
        final String expectedResult = "{\"success\":true,\"response\":[[{\"hash\":110183,\"key\":\"one\",\"value\":4},{\"hash\":1025097045,\"key\":\"білка\",\"value\":3},{\"hash\":33993926,\"key\":\"ёлка\",\"value\":3},{\"hash\":115277,\"key\":\"two\",\"value\":3},{\"hash\":1036003870,\"key\":\"объем\",\"value\":3},{\"hash\":34168576,\"key\":\"їжак\",\"value\":2},{\"hash\":1036002946,\"key\":\"объём\",\"value\":1,\"next\":{\"hash\":114,\"key\":\"r\",\"value\":1}},{\"hash\":114,\"key\":\"r\",\"value\":1},{\"hash\":1044630083,\"key\":\"ааббввггґґддееєєжжззииііїїййккллммннооппррссттууффххццччшшщщььююяя\",\"value\":1},{\"hash\":810938485,\"key\":\"ааббввггддееёёжжззииййккллммннооппррссттууффххццччшшщщъъыыььээююяя\",\"value\":1,\"next\":{\"hash\":34085349,\"key\":\"єнот\",\"value\":1,\"next\":{\"hash\":1025097045,\"key\":\"білка\",\"value\":3}}},{\"hash\":34085349,\"key\":\"єнот\",\"value\":1,\"next\":{\"hash\":1025097045,\"key\":\"білка\",\"value\":3}}]],\"listUsersUrls\":[\"http://defas.com.ua/java/pageForSeleniumTest.html\"],\"dataTypeResponse\":\"JSON\"}";

        // when
        WordCounterServiceImpl wordCounterService = new WordCounterServiceImpl();
        String actualResult = wordCounterService.getWordCounterResult(HTML_TEST_PAGE, sortingParam, dataTypeResponse);

        // then
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testGetWordCounterResult_okUrl_InvalidSort_JsonResp() {
        // given
        final String sortingParam = "invalidSortingParam";
        final String dataTypeResponse = "JSON";
        final String expctedExceptionString = "java.lang.IllegalArgumentException: No enum constant com.qalight.javacourse.core.WordResultSorter.invalidSortingParam";

        // when
        WordCounterServiceImpl wordCounterService = new WordCounterServiceImpl();
        Exception actualException = null;
        try {
            wordCounterService.getWordCounterResult(HTML_TEST_PAGE, sortingParam, dataTypeResponse);
        } catch (RuntimeException e) {
            actualException = e;
        }

        // then
        if (actualException != null) {
            Assert.assertEquals(expctedExceptionString, actualException.toString());
        } else {
            Assert.assertFalse(true);
        }
    }

    @Test
    public void testGetWordCounterResult_okUrl_KeyAscSort_InvalidResp() {
        // given
        final String sortingParam = "KEY_ASCENDING";
        final String dataTypeResponse = "invalidResponseParam";
        final String expctedExceptionString = "java.lang.IllegalArgumentException: No enum constant com.qalight.javacourse.service.ResultPresentation.invalidResponseParam";

        // when
        WordCounterServiceImpl wordCounterService = new WordCounterServiceImpl();
        Exception actualException = null;
        try {
            wordCounterService.getWordCounterResult(HTML_TEST_PAGE, sortingParam, dataTypeResponse);
        } catch (RuntimeException e) {
            actualException = e;
        }

        // then
        if (actualException != null) {
            Assert.assertEquals(expctedExceptionString, actualException.toString());
        } else {
            Assert.assertFalse(true);
        }
    }
}