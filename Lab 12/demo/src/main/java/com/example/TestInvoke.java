package com.example;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class TestInvoke {

    public static void invokeTestMethods(Class<?> clazz) throws Exception {
        System.out.println("Invoking test methods for class: " + clazz.getName());
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(TestClass.class)) {
                System.out.println("Found @Test method: " + method.getName());
                TestStatics.incrementTestCount(clazz);
                try {
                    if (Modifier.isStatic(method.getModifiers()) && method.getParameterCount() == 0) {
                        method.setAccessible(true);
                        method.invoke(null);
                    } else {
                        Object instance = clazz.getDeclaredConstructor().newInstance();
                        method.setAccessible(true);
                        method.invoke(instance, getMockParameters(method.getParameterTypes()));
                    }
                    System.out.println("Test passed: " + method.getName());
                } catch (InvocationTargetException | IllegalAccessException e) {
                    TestStatics.incrementTestFailures(clazz);
                    System.err.println("Test failed: " + method.getName());
                    e.printStackTrace();
                }
            }
        }
    }

    private static Object[] getMockParameters(Class<?>[] parameterTypes) {
        Object[] parameters = new Object[parameterTypes.length];
        for (int i = 0; i < parameterTypes.length; i++) {
            if (parameterTypes[i] == int.class) {
                parameters[i] = 0; // Mock value for int
            } else if (parameterTypes[i] == long.class) {
                parameters[i] = 0L; // Mock value for long
            } else if (parameterTypes[i] == double.class) {
                parameters[i] = 0.0; // Mock value for double
            } else if (parameterTypes[i] == float.class) {
                parameters[i] = 0.0f; // Mock value for float
            } else if (parameterTypes[i] == boolean.class) {
                parameters[i] = false; // Mock value for boolean
            } else if (parameterTypes[i] == char.class) {
                parameters[i] = '\u0000'; // Mock value for char
            } else if (parameterTypes[i] == byte.class) {
                parameters[i] = (byte) 0; // Mock value for byte
            } else if (parameterTypes[i] == short.class) {
                parameters[i] = (short) 0; // Mock value for short
            } else if (parameterTypes[i] == String.class) {
                parameters[i] = ""; // Mock value for String
            } else {
                parameters[i] = null; // Default to null for unsupported types
            }
        }
        return parameters;
    }
}
