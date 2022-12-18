package org.example.lesson5.dz;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.example.Lesson7.MyUtils;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class FindNurseryPitomecTest {
    WebDriver driver;
    WebDriverWait webDriverWait;
    Actions actions;
    Cookie authCookie = new Cookie("pitomec_session", "a%3A9%3A%7Bs%3A10%3A%22session_id%22%3Bs%3A32%3A%22b98d3dd51ccbada5257305f36101dd73%22%3Bs%3A10%3A%22ip_address%22%3Bs%3A14%3A%22217.107.127.56%22%3Bs%3A10%3A%22user_agent%22%3Bs%3A50%3A%22Mozilla%2F5.0+%28Windows+NT+10.0%3B+Win64%3B+x64%29+AppleWeb%22%3Bs%3A13%3A%22last_activity%22%3Bi%3A1670158485%3Bs%3A11%3A%22request_uri%22%3Bs%3A11%3A%22%2Fuser%2Flogin%22%3Bs%3A7%3A%22user_id%22%3Bs%3A5%3A%2274398%22%3Bs%3A10%3A%22last_visit%22%3Bi%3A0%3Bs%3A5%3A%22login%22%3Bs%3A7%3A%22qukazal%22%3Bs%3A4%3A%22pass%22%3Bs%3A32%3A%22827ccb0eea8a706c4c34a16891f84e7b%22%3B%7D");

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeEach
    void setupBrowser() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
        driver.get("https://www.pitomec.ru/");
        driver.manage().addCookie(authCookie);

    }
    @AfterEach
    public void checkBrowser() {
        List<LogEntry> allLogRows = driver.manage().logs().get(LogType.BROWSER).getAll();
        if (!allLogRows.isEmpty()) {
            if (allLogRows.size() > 0) {
                allLogRows.forEach(logEntry -> {
                    System.out.println(logEntry.getMessage());
                });
            }
        }
    }
    void tearDown() {
        driver.quit();
    }

    @Test
    @DisplayName("FindNurseryPitomecTest")
    @Severity(SeverityLevel.TRIVIAL)
    @Attachment(value = "Page screenshot", type = "image/png")
    void nurseryTest() throws InterruptedException {
        try {
            ((JavascriptExecutor) driver).executeScript("let element = document.evaluate(\"//div[@id='pt_slot_id45']//a[@title='Гостиница для кошек в центре Москвы']\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null)\n" +
                    "//element.singleNodeValue.remove()");
            driver.findElement(By.xpath("//div[@id='topMenu']//a[.='Питомники']")).click();
            driver.findElement(By.xpath("//span[.='Выберите вид']")).click();
            driver.findElement(By.xpath("//li[.='Собаки']")).click();
            Thread.sleep(1000);
            webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='select_type']//div[@class='custom-select']")));
            driver.findElement(By.xpath("//div[@id='select_type']//div[@class='custom-select']")).click();
            webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='select_type']//li[.='Лабрадор ретривер']")));
            actions.scrollToElement(driver.findElement(By.xpath("//div[@id='select_type']//li[.='Лабрадор ретривер']"))).perform();
            driver.findElement(By.xpath("//div[@id='select_type']//li[.='Лабрадор ретривер']")).click();
            webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Искать']")));
            driver.findElement(By.xpath("//input[@value='Искать']")).click();
            webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[.='Питомник Лабрадоров амар Васант']")));
            driver.findElement(By.xpath("//a[.='Питомник Лабрадоров амар Васант']")).click();
            driver.findElement(By.xpath("//a[@href='/pitomniki/amarvasant/animals']")).click();
        } catch (Exception exception) {
            MyUtils.makeScreenshot(driver, "failure- org.example.Lesson5.FindNurseryPitomecTest" + System.currentTimeMillis() + ".png");
            exception.printStackTrace();
        }
    }
}
