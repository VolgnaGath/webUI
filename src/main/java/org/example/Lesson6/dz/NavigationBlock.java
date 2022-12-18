package org.example.Lesson6.dz;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavigationBlock extends BasePage{

    public NavigationBlock(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//li//a[@href='/products']")
    private WebElement productButton;

    public searchProduct NavifationBlockProductMenuClick() {
        productButton.click();
        return new searchProduct(driver);
    }

    //ul[contians(@class, 'submenu')//a[=.'T-shirts'] (ul который содержит класс со значение сабменю)
    //span[.='Size']/ancestor::div[@class='layered_filter']//a (ancestor - подняться до элемента)
}
