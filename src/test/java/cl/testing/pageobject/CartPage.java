package cl.testing.pageobject;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Your Amazon Cart is empty']")
    @FindBy(css = "div.sc-your-amazon-cart-is-empty > h2")
    protected WebElement emptyCartTxt;

    public boolean isEmptyCartMessageDisplayed() {
        return emptyCartTxt.isDisplayed();
    }
}
