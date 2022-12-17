package org.example.lesson4;

import org.example.Lesson4.Functions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;


import java.util.List;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class AssertJExamplesTest {
    @Test
    void assertJTest() {
        //Assumptions.assumeTrue(1==2);
        List<Object> stringList = Arrays.asList("test123", "test1234", "test12345");
        Assertions.assertAll(
                () -> assertThat(new Functions().isPalindrome("123")).isFalse(),
                () -> assertThat(5).isGreaterThan(4).isLessThan(6),
                () -> assertThat(stringList).containsAnyOf("test", "test123")
        );

   }
}