import config.WebDriverSingleton;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utils.AssertUtil;
import businessobjects.YandexLogin;
import ui.yandex.Yandex;
import ui.yandex.YandexDisk;

public class YandexTest extends BaseTest {

    @Test
    public void trashTest() {
        driver.get("https://yandex.by");
        Yandex yandex = new Yandex(driver);
        yandex.yandexLogin(new YandexLogin("maria1.tester", "Password1"));
        yandex.clickSubmitButton();

        YandexDisk disk = new YandexDisk(driver);
        disk.clickDisk()
                .openTheDisk();

        WebElement randomPicture = disk.getRandomPicture();
        String pictureSrc = disk.getElementScr(randomPicture);

        AssertUtil.assertListContainsElementWithSrc(pictureSrc, disk.getPictures());
        disk.movePictureIntoBin(randomPicture);
        AssertUtil.assertListNotContainElementWithSrc(pictureSrc, disk.getPictures());
        disk.clickBin()
                .clickOpenBinButton();
        AssertUtil.assertListContainsElementWithSrc(pictureSrc, disk.getPictures());
        disk.tickCheckBox()
                .clickRestoreButton();
        AssertUtil.assertListNotContainElementWithSrc(pictureSrc, disk.getPictures());
        disk.returnToDisk();
        AssertUtil.assertListContainsElementWithSrc(pictureSrc, disk.getPictures());
    }
}