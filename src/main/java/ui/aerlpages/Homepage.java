package ui.aerlpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.AbstractPage;
import businessobjects.Route;

public class Homepage extends AbstractPage {

    By originField = By.xpath("//*[@id='origin']/div");
    By suggestion = By.xpath("//li[contains(@id,'typeahead')][1]");
    By destinationField = By.xpath("//*[@id='dest']/div");
    By findFlightButton = By.xpath("//button[@data-test-id='test_booker_search']");


    By tabHotel = By.xpath("//*[contains(@id,'partner-tab') and contains(.,'HOTELS')]");
    By buttonViewHotels = By.id("hotel-link-1");

    By tabCarHire = By.xpath("//*[contains(@id,'partner-tab') and contains(.,'CAR')]");
    By buttonMoreInfo = By.id("car-rental-link-1");

    public Homepage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public void clickOrigin(){
        super.waitElement(originField);
        driver.findElement(originField).click();
    }

    public void clearOrigin(){
        driver.findElement(originField).clear();
    }

    public void setRoute (Route route){
        waitElement(originField);
        driver.findElement(originField).click();
        //driver.findElement(originField).clear();
        driver.findElement(originField).sendKeys(route.getOrigin());
        driver.findElement(suggestion).click();
        waitElement(destinationField);
        driver.findElement(destinationField).sendKeys(route.getDestination());
        driver.findElement(suggestion).click();
    }

    public void sendKeysOrigin(String originCity){
        driver.findElement(originField).sendKeys(originCity);
    }

    public void clickOriginSuggestion(){
        driver.findElement(suggestion).click();
    }

    public void clickDestination(){
        driver.findElement(destinationField).click();
    }

    public void sendKeysDestination(String destinationCity){
        driver.findElement(destinationField).sendKeys(destinationCity);
    }

    public void clickDestinationSuggestion(){
        driver.findElement(suggestion).click();
    }

    public void clickFindFlightButton(){
        waitElement(findFlightButton);
        super.waitHighlightAndClickElement(findFlightButton);
        driver.findElement(findFlightButton).click();
    }

    public void clickTabHotel(){
        waitElement(tabHotel);
        driver.findElement(tabHotel).click();
    }

    public void clickButtonViewHotels(){
        waitElement(buttonViewHotels);
        driver.findElement(buttonViewHotels).click();
    }

    public void clickTabCarHire(){
        waitElement(tabCarHire);
        driver.findElement(tabCarHire).click();
    }

    public void clickButtonMoreInfo(){
        waitElement(buttonMoreInfo);
        driver.findElement(buttonMoreInfo).click();
    }
}
