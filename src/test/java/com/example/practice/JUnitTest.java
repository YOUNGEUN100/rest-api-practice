package com.example.practice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class JUnitTest {

    @DisplayName("1 + 2 는 3 이다.")
    @Test
    public void junitTest() {
        int a = 1;
        int b = 2;

        int sum = 3;

        Assertions.assertEquals(a+b,sum);
    }

    @DisplayName("1 + 3 는 4 이다.")
    @Test
    public void junitTest2() {
        int a = 1;
        int b = 3;

        int sum = 4;

        assertThat(a+b).isEqualTo(sum);
    }
}
