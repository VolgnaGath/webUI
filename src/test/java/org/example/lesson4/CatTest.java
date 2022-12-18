package org.example.lesson4;

import net.bytebuddy.asm.Advice;
import org.example.Lesson4.Cat;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class CatTest {
    @ParameterizedTest
    @MethodSource("catAndAgeDataProvider")
    void catAndAgeTest (Cat cat, Integer age) {
        Assertions.assertEquals(cat.getAge(), age);

    }
    private static List<Arguments> catAndAgeDataProvider() {
        return Arrays.asList(
                Arguments.of(new Cat("test", 10), 10),
                Arguments.of(new Cat("test2", 11), 12)
        );
    }
}
