package org.example.Lesson6.dz;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class searchProduct extends BasePage{

    public searchProduct(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = " //div[@class='panel-heading']//a[@href='#Women']")
    private WebElement categoryWomen;

    public searchProduct selectCategory() {
        categoryWomen.click();
        return this;
    }
    @FindBy(xpath = "//div[@id='Women']//a[.='Dress ']")
    private WebElement womenDress;

    public searchProduct selectWomenDress() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(womenDress));
        womenDress.click();
        return this;
    }

    @FindBy(xpath = "//div[@class='productinfo text-center']//h2[.='Rs. 1000']")
    private WebElement firstDressModel;

    public searchProduct getFirstDressModel() {
        actions.moveToElement(firstDressModel).perform();
        return this;
    }
    @FindBy(xpath = "//div[@class='product-overlay']//a[@data-product-id='3']")
    private WebElement buttonAddToCart;

    public SuccessBlock clickButtonAddToCart() {
        buttonAddToCart.click();
        return new SuccessBlock(driver);
    }

}
