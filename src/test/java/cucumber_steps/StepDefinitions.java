package cucumber_steps;

import config.WebDriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import ui.AbstractPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import businessobjects.Route;
import ui.aerlpages.FlightResultsPage;
import ui.aerlpages.Homepage;
import utils.AssertUtil;

/**
 * Created by Maryia_Shynkarenka on 7/24/2017.
 */
public class StepDefinitions {

    public WebDriver driver = WebDriverSingleton.getWebDriverInstance();;
    Homepage homepage;

    @When("^I open Aerlingus Homepage$")
    public void open_aerlingus_homepage(){
        driver.get("www.aerlingus.com");
    }


    @When ("^I perform a Flight search$")
    public void perform_a__flight_search(){
        driver.get("https://www.aerlingus.com/html/en-US/home.html");
        homepage = new Homepage(driver);
        homepage.setRoute(new Route("dublin","paris"));
    }

    @When("^I press Find Flights button")
    public void press_find_flights_button(){
        homepage.clickFindFlightButton();
        FlightResultsPage flightresults = new FlightResultsPage(driver);
        AssertUtil.assertEquals(flightresults.getOutboundText(), "Dublin to Paris");
        AssertUtil.assertEquals(flightresults.getInboundText(), "Paris to Dublin");
        flightresults.clickContinue();
    }


    @Then ("^I see Flight Results page")
    public void i_see_flight_results_page() {
        Assert.assertEquals("Dublin", driver.findElement(By.xpath("//div[contains(@data-test-id,'first')]//div[contains(@class,'flight-results')]//span")).getText());
    }
}
