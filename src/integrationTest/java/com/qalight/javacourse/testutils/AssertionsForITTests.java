package com.qalight.javacourse.testutils;

import java.util.Collection;

public class AssertionsForITTests {
    public static boolean equalCollections(Collection<?> collection, Collection<?> anotherCollection) {
        if (collection == null) {
            return (anotherCollection == null);
        }
        if (anotherCollection == collection) {
            return true;
        }
        if (collection.size() != anotherCollection.size()) {
            return false;
        }
        for (Object each : collection) {
            if (!anotherCollection.contains(each)) {
                return false;
            }
        }
        return true;
    }
}
