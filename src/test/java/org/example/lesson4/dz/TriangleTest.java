package org.example.lesson4.dz;

import org.example.Lesson4.Cat;
import org.example.Lesson4.Functions;
import org.example.Lesson4.dz.Triangle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TriangleTest {
    @ParameterizedTest
    @MethodSource("squareTriProvider")
    void squareTriTest(Triangle triangle, String square) {
        Assertions.assertEquals(triangle.squareTri(), square);
    }

    private static List<Arguments> squareTriProvider() {
        return Arrays.asList(
                Arguments.of(new Triangle(6.0, 10.0, 7.0), "20,66"),
                Arguments.of(new Triangle(11.0, 12.0, 6.0), "32,84")
        );
    }
}