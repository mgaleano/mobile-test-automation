package cl.testing.common;

import io.appium.java_client.AppiumDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DriverHelper {

    public static WebDriver getDriver(String platform) {

        switch (platform) {
            case "ANDROID":
                // setup Android
                DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                desiredCapabilities.setCapability("platformName", "Android");
                desiredCapabilities.setCapability("automationName", "UiAutomator2");
                desiredCapabilities.setCapability("deviceName", "Pixel_3A");
                desiredCapabilities.setCapability("app", "/Users/marcos.galeano/testing-chile-2023/app.apk");
                desiredCapabilities.setCapability("autoGrantPermissions", "true");
                AppiumDriver<WebElement> appiumDriver = new AppiumDriver<>(getAppiumLocalhost(), desiredCapabilities);
                return appiumDriver;
            case "IOS":
                // setup iOS
            case "WEB":
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            default:
                Logger.getGlobal().log(Level.SEVERE, "Unsupported platform. Use ANDROID or IOS.");
        }

        return null;
    }

    private static URL getAppiumLocalhost() {
        try {
            return new URL("http://127.0.0.1:4723/wd/hub");
        } catch (MalformedURLException e) {
            Logger.getGlobal().log(Level.SEVERE, "There was an error setting Appium for local testing.", e);
        }
        return null;
    }
}
