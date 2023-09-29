package cl.testing.pageobject;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage extends BasePage {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Your Amazon Cart is empty']")
    protected WebElement emptyCartTxt;

    public boolean isEmptyCartMessageDisplayed() {
        return emptyCartTxt.isDisplayed();
    }
}
