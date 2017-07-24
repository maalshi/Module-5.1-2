package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

//Factory
public class WebDriverFactory {
    public WebDriver getDriver(){
        System.setProperty("webdriver.gecko.driver", "D:\\webdrivers\\browsers\\geckodriver.exe");
        System.setProperty("webdriver.chrome.driver","D:\\webdrivers\\browsers\\chromedriver.exe");

        if(System.getProperty("browser").equals("firefox")) {
            return new FirefoxDriver();
        } else if(System.getProperty("browser").equals("chrome")){
            return new ChromeDriver();
        }
        return new FirefoxDriver();
    }
}
