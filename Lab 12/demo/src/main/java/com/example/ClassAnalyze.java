package com.example;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class ClassAnalyze {

    public static void analyzeClass(Class<?> clazz) {
        System.out.println("Class: " + clazz.getName());
        System.out.println("Methods:");
        for (Method method : clazz.getDeclaredMethods()) {
            System.out.println(Modifier.toString(method.getModifiers()) + " " + method.getReturnType().getSimpleName()
                    + " " + method.getName() + Arrays.toString(method.getParameterTypes()));
        }
    }
}
