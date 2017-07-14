import businessobjects.CarHireDetails;
import org.testng.annotations.Test;
import ui.CarHirePages.CarHireResults;
import ui.CarHirePages.CarHireSearch;
import ui.aerlpages.Homepage;
import utils.AssertUtil;

/**
 * Created by Maryia_Shynkarenka on 6/19/2017.
 */
public class CarHireTest extends BaseTest {

    @Test
    public void findCarHire() {
        driver.get("https://www.aerlingus.com/html/en-US/home.html");
        Homepage homepage = new Homepage(driver);
        homepage.clickTabCarHire();
        String winHandleBefore = driver.getWindowHandle();
        homepage.clickButtonMoreInfo();
        for (String winHandle : driver.getWindowHandles()) {
            if (!winHandle.equals(winHandleBefore)) {
                driver.switchTo().window(winHandle);
            }
        }

        CarHireSearch search = new CarHireSearch(driver);
        search.sendKeysPickUpLocation(new CarHireDetails("dublin"));
        winHandleBefore = driver.getWindowHandle();
        search.clickSuggestion();
        search.clickStartDate();
        search.clickOutboiundDate();
        search.clickEndDate();
        search.clickInboundDate();
        search.clickSearchButton();
        CarHireResults results = new CarHireResults(driver);
        //AssertUtil util = new AssertUtil();
        AssertUtil.assertEquals(results.getOutboundAirportText(),"Dublin - Airport");
        AssertUtil.assertEquals(results.getInboundAirportText(),"Dublin - Airport");
    }
}


