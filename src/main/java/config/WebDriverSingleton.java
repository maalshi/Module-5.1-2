package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

//Singleton
public class WebDriverSingleton {
    private static WebDriver driver;

    private WebDriverSingleton(){
    }

    public static WebDriver getWebDriverInstance(){
        if (driver == null) {
            driver = new WebDriverFactory().getDriver();
        }
        return driver;
    }
}