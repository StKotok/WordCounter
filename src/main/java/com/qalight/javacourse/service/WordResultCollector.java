package com.qalight.javacourse.service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pavelkulakovsky on 11.08.14.
 */
public class WordResultCollector {
    private Map<String, Map<String, Integer>> wordsResult = new HashMap<>();

    public Map<String, Map<String, Integer>> getWordsResult(String sourceLink, Map<String, Integer> sortedWords) {
        wordsResult.put(sourceLink, sortedWords);

        return wordsResult;
    }


}
