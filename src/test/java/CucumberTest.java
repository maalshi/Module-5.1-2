import config.WebDriverSingleton;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

@CucumberOptions(strict = true, plugin = { "json:target/cucumber-report.json",
        "html:target/cucumber-report" }, tags = "@smokeTest", features = "src/test/resources/features/first.feature", glue = {
        "cucumber_steps" })
public class CucumberTest extends AbstractTestNGCucumberTests {
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
