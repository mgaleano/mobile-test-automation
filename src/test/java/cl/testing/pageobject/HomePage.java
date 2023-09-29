package cl.testing.pageobject;

import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "com.amazon.mShop.android.shopping:id/cart_count")
    @FindBy(css = "a#nav-cart")
    protected WebElement cartBtn;

    public CartPage clickOnCartButton() {
        cartBtn.click();
        return new CartPage(driver);
    }
}
