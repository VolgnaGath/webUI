package org.example.lesson4;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.Lesson4.Functions;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FunctionsTest {
    public static Logger logger = LoggerFactory.getLogger(FunctionsTest.class);
    @BeforeAll
    static void beforeAll() {
        System.out.println("Метод перед каждым");
        WebDriverManager.chromedriver().setup();
        logger.atInfo();
    }
    @BeforeEach
    void beforeEach() {
        logger.atError();
    }

    @Test
    @DisplayName("Тест палендром с нечетным количеством символов")
    void isPalindromeTest () {
        boolean result = new Functions().isPalindrome("12321");
        Assertions.assertEquals(true, result);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1234321", "123454321"})
    @DisplayName("Тест палендром параметризованый")
    void isPalindromeTest (String tesWord) {
        boolean result = new Functions().isPalindrome(tesWord);
        Assertions.assertEquals(true, result);
    }

    @ParameterizedTest
    @CsvSource({"123, false", "1234321, true"})
    @DisplayName("Тест палендром параметризованый")
    void isPalindromeTest (String tesWord, boolean expectedResult) {
        Assertions.assertEquals(expectedResult, new Functions().isPalindrome(tesWord));
    }
}
