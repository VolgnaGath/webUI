package org.example.Lesson6.dz;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.function.BooleanSupplier;

public class Payment extends BasePage{

    public Payment(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@data-qa='name-on-card']")
    private WebElement cardName;
    public Payment setCardName(String name) {
        cardName.sendKeys(name);
        return this;
    }

    @FindBy(xpath = "//input[@data-qa='card-number']")
    private WebElement cardNumber;

    public Payment setCardNumber(String number) {
        cardNumber.sendKeys(number);
        return this;
    }

    @FindBy(xpath = "//input[@data-qa='cvc']")
    private WebElement cvc;

    public Payment setCVC(String cvcValue) {
        cvc.sendKeys(cvcValue);
        return this;
    }
    @FindBy(xpath = "//input[@data-qa='expiry-month']")
    private WebElement expirationMonth;

    public Payment setExpiration(String exp) {
        expirationMonth.sendKeys(exp);
        return this;
    }
    @FindBy(xpath = "//input[@data-qa='expiry-year']")
    private WebElement expiryYear;
    public Payment setExpiryYear(String ry) {
        expiryYear.sendKeys(ry);
        return this;
    }

    @FindBy(xpath = "//button[@id='submit']")
    private WebElement confirmOrder;
    public void clickConfirmOrder() {
        confirmOrder.click();
    }

}
