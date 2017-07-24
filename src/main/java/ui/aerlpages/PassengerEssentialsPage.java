package ui.aerlpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import ui.AbstractPage;

/**
 * Created by Maryia_Shynkarenka on 6/13/2017.
 */
public class PassengerEssentialsPage extends AbstractPage {

    @FindBy(xpath = "//div[@id='test-left']//div[@class='relative ng-scope'][1]//div[contains(@class,'head-section')]//span[@class='ng-binding']")
    WebElement OutboundFlight;

    @FindBy(xpath = "//div[@id='test-left']//div[@class='relative ng-scope'][2]//div[contains(@class,'head-section')]//span[@class='ng-binding']")
    WebElement InboundFlight;

    public PassengerEssentialsPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 20);
        PageFactory.initElements(driver, this);
    }

    public String getTextOutboundFlight(){
        waitElement(OutboundFlight);
        return OutboundFlight.getText();
    }

    public String getTextInboundFlight(){
        waitElement(InboundFlight);
        return InboundFlight.getText();
    }
}
