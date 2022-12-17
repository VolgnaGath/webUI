package org.example.Lesson6.dz;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCart extends BasePage{
    public ShoppingCart(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//p[@class='cart_total_price']")
    private WebElement totalPrice;

    public ShoppingCart checkTotalPrice(String rs) {
        Assertions.assertEquals(rs, totalPrice.getText());
        return this;
    }

    @FindBy(xpath = "//a[.='Proceed To Checkout']")
    private WebElement checkOut;

    public Checkout clickCheckOut() {
        checkOut.click();
        return new Checkout(driver);
    }
}
