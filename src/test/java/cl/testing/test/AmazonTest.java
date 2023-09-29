package cl.testing.test;

import cl.testing.common.DriverHelper;
import cl.testing.pageobject.AccountPage;
import cl.testing.pageobject.CartPage;
import cl.testing.pageobject.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AmazonTest {

    @Test(description = "verify_empty_cart_guest")
    public void verifyGuestUserEmptyCart() {

        WebDriver driver = DriverHelper.getDriver("ANDROID");
        AccountPage accountPage = new AccountPage(driver);
        HomePage homePage = accountPage.clickOnSkipSignInButton();
        CartPage cartPage = homePage.clickOnCartButton();

        Assert.assertTrue(cartPage.isEmptyCartMessageDisplayed(), "Empty Cart message should be present.");
    }
}
