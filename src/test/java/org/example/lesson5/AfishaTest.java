package org.example.lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.time.Duration;

public class AfishaTest {
    WebDriver driver;
    WebDriverWait webDriverWait;
    Actions actions;

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeEach
    void setupBrowser() {
       driver = new ChromeDriver();
       webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
       actions = new Actions(driver);
       driver.get("https://www.afisha.ru/");

    }
    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Test
    void goToOkkoTest() {
        ((JavascriptExecutor)driver).executeScript("let element = document.evaluate(\"//div[@data-test='HONEY-AD AD-ad_1']\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null)\n" +
                "element.singleNodeValue.remove()");
        actions.scrollToElement(driver.findElement(By.xpath("//button[.='Подписаться']"))).perform();
        actions.moveToElement(driver.findElement(By.xpath("//a[.='КИНО']"))).perform();
        driver.findElement(By.xpath("//div[@data-test='SUGGEST']//a[.='Скоро онлайн в Okko']")).click();
        Assertions.assertTrue(driver.getCurrentUrl().contains("okko"));
////div[@data-test='HONEY-AD AD-ad_1']
        //div[@data-test='SUGGEST']//a[.='Скоро онлайн в Okko']
    }

    @Test
    void authTest() {

        driver.findElement(By.xpath("//button[.='Войти']")).click();
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src, 'login')]")));
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.id("login")));
        driver.findElement(By.id("login")).sendKeys("spartalex1993");
        driver.findElement(By.id("password")).sendKeys("Test4test");
        webDriverWait.until(d -> d.findElement(By.id("login")).getAttribute("value").contains("@rambler.ru"));
        driver.findElement(By.xpath("//button[.='Войти']")).click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//header//a//div[contains(., 'Избранное') and preceding-sibling::span")));
        Assertions.assertTrue(driver.findElement(By.xpath("//header//a//div[contains(., 'Избранное') and preceding-sibling::span")).isDisplayed());

    }
}
