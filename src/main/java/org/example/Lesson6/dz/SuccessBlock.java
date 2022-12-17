package org.example.Lesson6.dz;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SuccessBlock extends BasePage{

    public SuccessBlock(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//a//u[.='View Cart']")
    private WebElement viewCart;

    public ShoppingCart goToViewCart() {
        webDriverWait.until(ExpectedConditions.visibilityOf(viewCart));
    viewCart.click(); return new ShoppingCart(driver);
    }
}
