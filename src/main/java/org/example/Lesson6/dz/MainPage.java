package org.example.Lesson6.dz;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;


public class MainPage extends BasePage{


    @FindBy(xpath = "//a[@href='/login']")
    private WebElement signInButton;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public loginPage clickSignupButton() {
        signInButton.click();
        return new loginPage(driver);
    }


    
}
