package info.deepidea.wordcounter.core;

import org.junit.Assert;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class WordResultSorterTest {
    private static final String KEY_ASCENDING = "KEY_ASCENDING";
    private static final String KEY_DESCENDING = "KEY_DESCENDING";
    private static final String VALUE_ASCENDING = "VALUE_ASCENDING";
    private static final String VALUE_DESCENDING = "VALUE_DESCENDING";

    @Test
    public void testGetOrderType_nullParam() {
        // given
        final String sortingOrder = null;

        // when
        WordResultSorter actualSortingType = WordResultSorter.getOrderType(sortingOrder);

        // then
        WordResultSorter expectedSortingType = WordResultSorter.VALUE_DESCENDING;

        Assert.assertEquals(expectedSortingType, actualSortingType);
    }

    @Test
    public void testGetOrderType_emptyParam() {
        // given
        final String sortingOrder = "";

        // when
        WordResultSorter actualSortingType = WordResultSorter.getOrderType(sortingOrder);

        // then
        WordResultSorter expectedSortingType = WordResultSorter.VALUE_DESCENDING;

        Assert.assertEquals(expectedSortingType, actualSortingType);
    }

    @Test
    public void testGetOrderType_properParam() {
        // given
        final String sortingOrder = "KEY_ASCENDING";

        // when
        WordResultSorter actualSortingType = WordResultSorter.getOrderType(sortingOrder);

        // then
        WordResultSorter expectedSortingType = WordResultSorter.KEY_ASCENDING;

        Assert.assertEquals(expectedSortingType, actualSortingType);
    }

    @Test
    public void testEnumeration() {
        // given
        final Set<String> expectedEnumValues = new TreeSet<String>() {{
            add(KEY_ASCENDING);
            add(KEY_DESCENDING);
            add(VALUE_ASCENDING);
            add(VALUE_DESCENDING);
        }};

        //when
        Set<String> actualEnumValues = new TreeSet<>();
        for (WordResultSorter wordResultSorter : WordResultSorter.values()) {
            actualEnumValues.add(String.valueOf(wordResultSorter));
        }

        //then
        Assert.assertEquals(expectedEnumValues, actualEnumValues);
    }

    @Test
    public void testGetSortedWords_KeyAsc() {
        //given
        final Map<String, Integer> givenHashMap = new HashMap<String, Integer>() {{
            put("three", 3);
            put("one", 1);
            put("two", 2);
        }};

        final String expectedResultByKA = "{one=1, three=3, two=2}";

        //when
        Map<String, Integer> actualResultByKA = WordResultSorter.valueOf(KEY_ASCENDING).getSortedWords(givenHashMap);

        //then
        Assert.assertEquals(expectedResultByKA, String.valueOf(actualResultByKA));
    }

    @Test
    public void testGetSortedWords_KeYDesc() {
        //given
        final Map<String, Integer> givenHashMap = new HashMap<String, Integer>() {{
            put("three", 3);
            put("one", 1);
            put("two", 2);
        }};

        final String expectedResultByKD = "{two=2, three=3, one=1}";

        //when
        Map<String, Integer> actualResultByKD = WordResultSorter.valueOf(KEY_DESCENDING).getSortedWords(givenHashMap);

        //then
        Assert.assertEquals(expectedResultByKD, String.valueOf(actualResultByKD));
    }

    @Test
    public void testGetSortedWords_ValAsc() {
        //given
        final Map<String, Integer> givenHashMap = new HashMap<String, Integer>() {{
            put("three", 3);
            put("one", 1);
            put("two", 2);
        }};

        final String expectedResultByVA = "{one=1, two=2, three=3}";

        //when
        Map<String, Integer> actualResultByVA = WordResultSorter.valueOf(VALUE_ASCENDING).getSortedWords(givenHashMap);

        //then
        Assert.assertEquals(expectedResultByVA, String.valueOf(actualResultByVA));
    }

    @Test
    public void testGetSortedWords_ValDesc() {
        //given
        final Map<String, Integer> givenHashMap = new HashMap<String, Integer>() {{
            put("three", 3);
            put("one", 1);
            put("two", 2);
        }};

        final String expectedResultByVD = "{three=3, two=2, one=1}";

        //when
        Map<String, Integer> actualResultByVD = WordResultSorter.valueOf(VALUE_DESCENDING).getSortedWords(givenHashMap);

        //then
        Assert.assertEquals(expectedResultByVD, String.valueOf(actualResultByVD));
    }
}