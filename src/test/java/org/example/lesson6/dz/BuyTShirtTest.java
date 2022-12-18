package org.example.lesson6.dz;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.example.Lesson6.dz.MainPage;
import org.example.Lesson7.MyUtils;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class BuyTShirtTest {
    WebDriver driver;
    WebDriverWait webDriverWait;

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeEach
    void initDriver() {
        driver = new ChromeDriver();
        driver.get("https://automationexercise.com/");
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }
    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Test
    @DisplayName("Скрин")
    @Severity(SeverityLevel.BLOCKER)
    @Attachment(value = "Page screenshot", type = "image/png")
    void BuyTShirtTest() {
        try {

            new MainPage(driver).clickSignupButton().login("ILYA-crime2008@yandex.ru", "12365478").
                    NavifationBlockProductMenuClick()
                    .selectCategory()
                    .selectWomenDress()
                    .getFirstDressModel()
                    .clickButtonAddToCart().goToViewCart()
                    .checkTotalPrice("Rs. 1000").clickCheckOut()
                    .clickPlaceOrder()
                    .setCardName("Abula")
                    .setCardNumber("123321123")
                    .setCVC("311")
                    .setExpiration("11")
                    .setExpiryYear("1991")
                    .clickConfirmOrder();
            webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[.='Congratulations! Your order has been confirmed!']")));
            Assertions.assertTrue(driver.getCurrentUrl().contains("payment_done"));

        }
        catch (Exception exception) {
            MyUtils.makeScreenshot(driver, "failure- org.example.Lesson6.BuyTShirt" + System.currentTimeMillis() + ".png");
            exception.printStackTrace();

        }
    }

}
