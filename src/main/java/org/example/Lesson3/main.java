package org.example.Lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class main {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("user-agent=Googlebot/2.1 (+http://www.google.com/bot.html)");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get("https://www.pitomec.ru/");
        Cookie authCookie = new Cookie("pitomec_session", "a%3A9%3A%7Bs%3A10%3A%22session_id%22%3Bs%3A32%3A%22e09ff454466e44083f902eb26aaf365e%22%3Bs%3A10%3A%22ip_address%22%3Bs%3A13%3A%2281.177.127.24%22%3Bs%3A10%3A%22user_agent%22%3Bs%3A50%3A%22Mozilla%2F5.0+%28Windows+NT+10.0%3B+Win64%3B+x64%29+AppleWeb%22%3Bs%3A13%3A%22last_activity%22%3Bi%3A1668874525%3Bs%3A11%3A%22request_uri%22%3Bs%3A1%3A%22%2F%22%3Bs%3A7%3A%22user_id%22%3Bs%3A5%3A%2274398%22%3Bs%3A10%3A%22last_visit%22%3Bi%3A0%3Bs%3A5%3A%22login%22%3Bs%3A7%3A%22qukazal%22%3Bs%3A4%3A%22pass%22%3Bs%3A32%3A%22827ccb0eea8a706c4c34a16891f84e7b%22%3B%7D");
        driver.manage().addCookie(authCookie);
        Thread.sleep(20000);
        driver.navigate().refresh();
        Thread.sleep(20000);
        driver.navigate().refresh();
        driver.findElement(By.xpath("//li[.='Мой блог']")).click();
        driver.findElement(By.xpath("//a[@href='/blog/post']")).click();
        String testTitle = "TEST";
        driver.findElement(By.id("title")).sendKeys(testTitle);
        driver.findElement(By.id("text")).sendKeys("test");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        driver.findElement(By.xpath("//li[.='Мой блог']")).click();
        List<WebElement> titles = driver.findElements(By.xpath("//a[@class='postTitle']"));
        titles.stream().filter(p -> p.getText().equals(testTitle)).findFirst().get().click();
        Thread.sleep(5000);
        driver.quit();


    }
}
