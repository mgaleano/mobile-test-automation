package cl.testing.pageobject;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountPage extends BasePage {

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "com.amazon.mShop.android.shopping:id/skip_sign_in_button")
    protected WebElement skipSignInBtn;


    public HomePage clickOnSkipSignInButton() {
        skipSignInBtn.click();
        return new HomePage(driver);
    }


}
