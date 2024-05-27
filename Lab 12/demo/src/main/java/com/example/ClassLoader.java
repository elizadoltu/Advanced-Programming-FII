package com.example;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

public class ClassLoader {

    public static List<Class<?>> loadClassesFromDirectory(File directory) throws Exception {
        List<Class<?>> classes = new ArrayList<>();
        for (File file : directory.listFiles()) {
            if (file.isDirectory()) {
                classes.addAll(loadClassesFromDirectory(file));
            } else if (file.getName().endsWith(".class")) {
                System.out.println("Found class file: " + file.getAbsolutePath());
                classes.add(loadClassFromFile(file));
            }
        }
        return classes;
    }

    public static Class<?> loadClassFromFile(File file) throws Exception {
        String className = file.getName().replace(".class", "");
        URLClassLoader classLoader = new URLClassLoader(new URL[] { file.getParentFile().toURI().toURL() });
        System.out.println("Loading class: " + className);
        return classLoader.loadClass(className);
    }

}
