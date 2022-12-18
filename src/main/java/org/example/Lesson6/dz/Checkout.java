package org.example.Lesson6.dz;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Checkout extends BasePage{

    public Checkout(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[.='Place Order']")
    private WebElement placeOrder;

    public Payment clickPlaceOrder() {
        placeOrder.click();
        return new Payment(driver);
    }
}
