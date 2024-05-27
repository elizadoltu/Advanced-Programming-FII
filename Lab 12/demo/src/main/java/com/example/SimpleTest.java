package com.example;

public class SimpleTest {

    @TestClass
    public static void staticTestMethod() {
        System.out.println("Static test method executed.");
    }

    @TestClass
    public void instanceTestMethod() {
        System.out.println("Instance test method executed.");
    }

    @TestClass
    public void parameterizedTestMethod(int a, String b) {
        System.out.println("Parameterized test method executed with values: " + a + ", " + b);
    }
}
