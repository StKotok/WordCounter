package com.qalight.javacourse.service;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

public interface WordCounterService {
    WordCounterResultContainer getWordCounterResult(String dataSources) throws InterruptedException, ExecutionException, TimeoutException;
}
