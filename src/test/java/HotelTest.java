import org.testng.annotations.Test;
import ui.HotelPages.HotelPage;
import ui.HotelPages.PlanPage;
import ui.aerlpages.Homepage;
import utils.AssertUtil;

public class HotelTest extends BaseTest {

    @Test
    public void verifyHotels() {
        driver.get("https://www.aerlingus.com/html/en-US/home.html");
        Homepage homepage = new Homepage(driver);
        homepage.clickTabHotel();
        String winHandleBefore = driver.getWindowHandle();
        homepage.clickButtonViewHotels();
        for (String winHandle : driver.getWindowHandles()) {
            if (!winHandle.equals(winHandleBefore)) {
                driver.switchTo().window(winHandle);
            }
        }
    }

    @Test(dependsOnMethods = {"verifyHotels"}, alwaysRun = true)
    public void assertText() {
        HotelPage hotelPage = new HotelPage(driver);
        hotelPage.verifyNewHotelsPartnerText();
        hotelPage.verifyWerePartneringText();
        hotelPage.verifyWereChangingText();
        hotelPage.clickButtonSearchFlights();
        PlanPage planPage = new PlanPage(driver);
        AssertUtil.assertEquals(planPage.verifyTextBookFlights(), "Plan Page");
    }
}






