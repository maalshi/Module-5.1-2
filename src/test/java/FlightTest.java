import org.testng.annotations.Test;
import ui.aerlpages.FlightResultsPage;
import ui.aerlpages.Homepage;
import businessobjects.Route;
import ui.aerlpages.PassengerEssentialsPage;
import ui.aerlpages.PaxInfoPage;
import utils.AssertUtil;

public class FlightTest extends BaseTest {

    @Test
       public void search(){
        driver.get("https://www.aerlingus.com/html/en-US/home.html");
        Homepage homepage = new Homepage(driver);
        homepage.setRoute(new Route("dublin","paris"));
        homepage.clickFindFlightButton();
        FlightResultsPage flightresults = new FlightResultsPage(driver);
        AssertUtil.assertEquals(flightresults.getOutboundText(), "Dublin to Paris");
        AssertUtil.assertEquals(flightresults.getInboundText(), "Paris to Dublin");
        flightresults.clickContinue();
    }

    @Test(dependsOnMethods = { "search" }, alwaysRun = true)
    public void passengerInfo() {
        PaxInfoPage pax = new PaxInfoPage(driver);
        pax.clickTitleMr();
        pax.sendKeysFirstName("John");
        pax.sendKeysFamilyName("Blare");
        pax.sendKeysEmail("maalshi@mail.ru");
        pax.sendKeysConfirmEmail("maalshi@mail.ru");
        pax.sendKeysAreaCode("34");
        pax.sendKeysLocalNumber("3434");
        pax.clickContinue();
    }

    @Test (dependsOnMethods = { "search", "passengerInfo" }, alwaysRun = true)
            public void assertEssentials(){
        PassengerEssentialsPage essentials = new PassengerEssentialsPage(driver);
        AssertUtil.assertEquals(essentials.getTextOutboundFlight(),"DUBLIN to PARIS/CDG");
        AssertUtil.assertEquals(essentials.getTextInboundFlight(),"PARIS/CDG to DUBLIN");
    }
}