package ui.HotelPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import ui.AbstractPage;

/**
 * Created by Maryia_Shynkarenka on 6/14/2017.
 */
public class PlanPage extends AbstractPage {

    WebDriver driver;
    WebDriverWait wait;

    By textBookFlights = By.xpath("//div[contains(@class,'page-header')]//h2");//By.className("h2-lrg centered ng-binding");

    public PlanPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public String verifyTextBookFlights(){
        waitElement(textBookFlights);
        return driver.findElement(textBookFlights).getText();
    }
}
