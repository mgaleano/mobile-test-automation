package cl.testing.pageobject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static java.time.Duration.ofSeconds;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected WebDriverWait waitLong;
    protected FluentWait<WebDriver> fluentWait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        if (((AppiumDriver) driver).isBrowser()) {
            PageFactory.initElements(driver, this);
        } else {
            PageFactory.initElements(new AppiumFieldDecorator(driver, ofSeconds(5)), this);
        }
        wait = new WebDriverWait(driver, 8);
        waitLong = new WebDriverWait(driver, 15);
        fluentWait =
                new FluentWait<>(driver)
                        .ignoring(WebDriverException.class)
                        .withTimeout(Duration.ofSeconds(60))
                        .pollingEvery(Duration.ofMillis(500));
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
}
