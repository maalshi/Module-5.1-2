package ui.HotelPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import ui.AbstractPage;

/**
 * Created by Maryia_Shynkarenka on 6/14/2017.
 */
public class HotelPage extends AbstractPage {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(id = "green-search-dates-flights_IE-EUR")
    WebElement buttonSearchFlights;

    @FindBy(xpath = "//img/preceding-sibling::div//h1//strong")
    WebElement hotelText;

    @FindBy(xpath = "//img/preceding-sibling::div//p[@ng-if='!latestOffersPath']")
    WebElement wereChangingText;

    @FindBy(xpath = "//*[@ng-if='header']//p")
    WebElement newHotelPatnersText;

    @FindBy(xpath = "//*[@on='isGreen']//p/p")
    WebElement werePatneringText;

    public HotelPage (WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void assertHotelsText(){
        waitElement(buttonSearchFlights);
        Assert.assertEquals("Hotels", hotelText.getText());
    }

    public void verifyWereChangingText(){
        waitElement(wereChangingText);
        Assert.assertEquals("We're changing our Hotels partner", wereChangingText.getText());
    }

    public void verifyNewHotelsPartnerText(){
        waitElement(newHotelPatnersText);
        Assert.assertEquals("New Hotels partner coming soon!", newHotelPatnersText.getText());
    }

    public void verifyWerePartneringText(){
        waitElement(werePatneringText);
        Assert.assertEquals("We are partnering with one of the world's leading accommodation suppliers with over a million properties throughout 225 countries worldwide.You can also look forward to superior booking functionality and payment options, and customer service tailored to your needs.\n" +
                "Flights and hotels sorted!", werePatneringText.getText());
    }

    public void clickButtonSearchFlights(){
        waitElement(wereChangingText);
        buttonSearchFlights.click();

    }
}
