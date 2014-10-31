package com.qalight.javacourse.service;

import com.qalight.javacourse.controller.CountWordsUserRequest;
import com.qalight.javacourse.core.ConcurrentExecutor;
import com.qalight.javacourse.core.WordResultSorter;
import com.qalight.javacourse.util.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@Service("wordCounterService")
public class WordCounterServiceImpl implements WordCounterService {
    private final RequestSplitter splitter;
    private final ConcurrentExecutor concurrentExecutor;
    private final CountersIntegrator integrator;
    private final WordFilter filter;

    @Autowired
    public WordCounterServiceImpl(RequestSplitter splitter, ConcurrentExecutor concurrentExecutor,
                                  CountersIntegrator integrator, WordFilter filter) {
        this.concurrentExecutor = concurrentExecutor;
        this.splitter = splitter;
        this.integrator = integrator;
        this.filter = filter;
    }

    @Override
    public WordCounterResultContainer getWordCounterResult(CountWordsUserRequest clientRequest) {
        checkParams(clientRequest.getTextCount(), clientRequest.getSortingOrder());

        Collection<String> splitterRequests = splitter.getSplitRequests(clientRequest.getTextCount());

        List<Map<String, Integer>> wordCountResults = concurrentExecutor.countAsynchronously(splitterRequests);

        Map<String, Integer> results = integrator.integrateResults(wordCountResults);

        Map<String, Integer> filteredResults = filter.removeUnimportantWords(results, clientRequest.isFilterRequired());

        Map<String, Integer> sortedRefinedCountedWords = getSortedWords(clientRequest, filteredResults);

        WordCounterResultContainer result = new WordCounterResultContainerImpl(sortedRefinedCountedWords);

        return result;
    }

    protected Map<String, Integer> getSortedWords(CountWordsUserRequest clientRequest, Map<String, Integer> filteredResults) {
        WordResultSorter sorter = clientRequest.getSortingOrder();
        return sorter.getSortedWords(filteredResults);
    }

    private static void checkParams(String userUrlsString, Object obj) {
        Assertions.assertStringIsNotNullOrEmpty(userUrlsString);
        Assertions.assertObjectIsNotNull(obj);
    }

}