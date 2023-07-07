package com.example.practice;

import org.junit.jupiter.api.*;

public class JUnitCycleTest {
    @BeforeAll
    static void beforeAll() {
        System.out.println("@BeforeAll 실행");
    }
    @BeforeEach
    public void beforeEach() {
        System.out.println("@BeforeEach 실행");
    }

    @Test
    public void test1() {
        System.out.println("test1");
    }
    @Test
    public void test2() {
        System.out.println("test2");
    }
    @Test
    public void test3() {
        System.out.println("test3");
    }
    @AfterAll
    static void afterAll() {
        System.out.println("@AfterAll 실행");
    }
    @AfterEach
    public void afterEach() {
        System.out.println("@AfterEach 실행");
    }
}
