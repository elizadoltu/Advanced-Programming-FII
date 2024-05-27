package com.example;

public class AnotherSimpleTest {

    @TestClass
    public static void anotherStaticTestMethod() {
        System.out.println("Another static test method executed.");
    }

    @TestClass
    public void anotherInstanceTestMethod() {
        System.out.println("Another instance test method executed.");
    }
}
