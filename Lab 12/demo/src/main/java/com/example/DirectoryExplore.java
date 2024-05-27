package com.example;

import java.io.File;
import java.util.List;

public class DirectoryExplore {

    public static void exploreAndAnalyze(File file, String packageName) throws Exception {
        if (file.isDirectory()) {
            System.out.println("Exploring directory: " + file.getAbsolutePath());
            List<Class<?>> classes = ClassLoader.loadClassesFromDirectory(file);
            for (Class<?> clazz : classes) {
                ClassAnalyze.analyzeClass(clazz);
                TestInvoke.invokeTestMethods(clazz);
            }
        } else if (file.getName().endsWith(".class")) {
            System.out.println("Exploring file: " + file.getAbsolutePath());
            Class<?> clazz = ClassLoader.loadClassFromFile(file);
            ClassAnalyze.analyzeClass(clazz);
            TestInvoke.invokeTestMethods(clazz);
        }
    }
}
