package info.deepidea.wordcounter.core;

import java.util.List;
import java.util.Map;

public interface WordCounter {
    Map<String, Integer> countWords(List<String> words);
}
