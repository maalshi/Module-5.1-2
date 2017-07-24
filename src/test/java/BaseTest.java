import config.WebDriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    protected WebDriver driver;

   @BeforeClass
    public WebDriver init() {
        driver = WebDriverSingleton.getWebDriverInstance();
        driver.manage().window().maximize();
        return driver;
    }

    @AfterClass
    public void closeDriver(){
        driver.quit();
    }
}
