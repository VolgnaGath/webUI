package org.example.Lesson6.dz;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginPage extends BasePage{

    public loginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@data-qa='login-email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@data-qa='login-password']")
    private WebElement passField;

    @FindBy(xpath = " //button[@data-qa='login-button']")
    private WebElement buttonLogin;

     public NavigationBlock login(String login, String password) {
        emailField.sendKeys(login);
        passField.sendKeys(password);
        buttonLogin.click();
        return new NavigationBlock(driver);
    }

}
