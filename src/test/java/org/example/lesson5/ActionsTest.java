package org.example.lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

public class ActionsTest {
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
    void highlightTestText() {
        driver.get("https://translate.yandex.com/?source_lang=en&target_lang=ru&text=test");
        actions.moveToElement(driver.findElement(By.xpath("//div[@class='fakearea-container']//div[@id='fakeArea']")), -20, 0).clickAndHold()
                .moveByOffset(30,0).perform();
    }
    @Test
    void yetBewExamples() {
        driver.get("https://google.com");
        ((JavascriptExecutor)driver).executeScript("alert('ffff')");
        driver.switchTo().alert().accept();

        driver.switchTo().newWindow(WindowType.TAB);
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get("https://ya,ru");
        driver.switchTo().window(tabs.get(0));
    }
}
