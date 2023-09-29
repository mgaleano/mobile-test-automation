package cl.testing.helper;

import cl.testing.pageobject.AccountPage;
import cl.testing.pageobject.HomePage;
import org.openqa.selenium.WebDriver;

public class NavigationFlow {

    public static HomePage goToHomePage(WebDriver driver, String platform) {
        HomePage homePage = new HomePage(driver);
        if (!platform.equals("WEB")) {
            AccountPage accountPage = new AccountPage(driver);
            homePage = accountPage.clickOnSkipSignInButton();
        }

        return homePage;
    }
}
