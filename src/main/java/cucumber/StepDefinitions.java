package cucumber;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import ui.AbstractPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import businessobjects.Route;

/**
 * Created by Maryia_Shynkarenka on 7/24/2017.
 */
public class StepDefinitions extends AbstractPage {

    public WebDriver driver;

    public StepDefinitions(){
        driver= this.driver;
    }

    @When("^I open Aerlingus Homepage$")
    public void open_aerlingus_homepage(){
        driver.get("www.aerlingus.com");
    }


    @When ("^I perform a Flight search$")
    public void perform_a__flight_search(){
        waitElement(By.xpath("//*[@id='origin']/div"));
        driver.findElement(By.xpath("//*[@id='origin']/div")).click();
        driver.findElement(By.xpath("//*[@id='origin']/div")).sendKeys("dublin");
        driver.findElement(By.xpath("//li[contains(@id,'typeahead')][1]")).click();
        waitElement(By.xpath("//*[@id='dest']/div"));
        driver.findElement(By.xpath("//*[@id='dest']/div")).sendKeys("paris");
        driver.findElement(By.xpath("//li[contains(@id,'typeahead')][1]")).click();
    }

    @When("^I press Find Flights button")
    public void press_find_flights_button(){
        driver.findElement(By.xpath("//button[@data-test-id='test_booker_search']")).click();
    }


    @Then ("^I see Flight Results page")
    public void i_see_flight_results_page() {
        Assert.assertEquals("Dublin", driver.findElement(By.xpath("//div[contains(@data-test-id,'first')]//div[contains(@class,'flight-results')]//span")).getText());
    }
}
