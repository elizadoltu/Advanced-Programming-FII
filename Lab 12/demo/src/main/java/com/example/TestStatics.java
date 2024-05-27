package com.example;

import java.util.HashMap;
import java.util.Map;

public class TestStatics {

    private static Map<Class<?>, Integer> testCounts = new HashMap<>();
    private static Map<Class<?>, Integer> testFailures = new HashMap<>();

    public static void incrementTestCount(Class<?> clazz) {
        testCounts.put(clazz, testCounts.getOrDefault(clazz, 0) + 1);
    }

    public static void incrementTestFailures(Class<?> clazz) {
        testFailures.put(clazz, testFailures.getOrDefault(clazz, 0) + 1);
    }

    public static void printStatistics() {
        System.out.println("Test Statistics:");
        for (Class<?> clazz : testCounts.keySet()) {
            System.out.println(clazz.getName() + ": " + testCounts.get(clazz) + " tests, "
                    + testFailures.getOrDefault(clazz, 0) + " failures");
        }
    }
}
