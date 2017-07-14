package ui.aerlpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import ui.AbstractPage;

/**
 * Created by Maryia_Shynkarenka on 6/9/2017.
 */
public class FlightResultsPage extends AbstractPage{
    WebDriver driver;

    @FindBy(xpath = "//button[@data-test-id='test_continue_btn']")
    WebElement continueButton;

    @FindBy(xpath = "//div[contains(@data-test-id,'first')]//div[contains(@class,'flight-results')]//span")
    WebElement outboundFlight;

    @FindBy(xpath = "//div[contains(@data-test-id,'second')]//div[contains(@class,'flight-results')]//span")
    WebElement inboundFlight;

    public FlightResultsPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 20);
        PageFactory.initElements(driver, this);
    }
    public void clickContinue(){
        waitElement(continueButton);
        continueButton.click();
    }

    public String getOutboundText(){
        waitElement(continueButton);
        return outboundFlight.getText();
    }

    public String getInboundText(){
        waitElement(continueButton);
        return inboundFlight.getText();
    }
}
