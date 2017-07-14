package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

//Factory
public class WebDriverFactory {
        public WebDriver getDriver(){

        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        if(System.getProperty("browser").equals("firefox")) {
            return new FirefoxDriver(DesiredCapabilities.firefox());
        } else if(System.getProperty("browser").equals("chrome")){
            return new ChromeDriver(DesiredCapabilities.chrome());
        }
        return new FirefoxDriver();
    }
}
