package ui.aerlpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.AbstractPage;

/**
 * Created by Maryia_Shynkarenka on 6/13/2017.
 */
public class PaxInfoPage extends AbstractPage {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//option[text()='Mr']")
    WebElement titleMr;

    @FindBy(id = "test_adultFname-0-1")
    WebElement firstName;

    @FindBy(id = "test_adultLname-0-2")
    WebElement familyName;

    @FindBy(xpath = "//*[@id='test_email-3']")
    WebElement email;

    @FindBy(xpath = "//*[@id='test_confirmemail-6']")
    WebElement confirmEmail;

    @FindBy(xpath = "//*[@id='test_acode-4']")
    WebElement areaCode;

    @FindBy(xpath = "//*[@id='test_mobnumber-5']")
    WebElement localNumber;

    @FindBy(id = "test_continueTravelEsstl")
    WebElement continueButton;

    public PaxInfoPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void clickTitleMr(){
        waitElement (titleMr);
        titleMr.click();
    }

    public void sendKeysFirstName(String name){
        firstName.sendKeys(name);
    }

    public void sendKeysFamilyName(String surname){
       familyName.sendKeys(surname);
    }

    public void sendKeysEmail(String emailAddress){
       email.sendKeys(emailAddress);
    }

    public void sendKeysConfirmEmail(String confirmEmailAddress){
        confirmEmail.sendKeys(confirmEmailAddress);
    }

    public void sendKeysAreaCode(String area){
        areaCode.sendKeys(area);
    }

    public void sendKeysLocalNumber(String local){
        localNumber.sendKeys(local);
    }

    public void clickContinue(){
        waitElement(continueButton);
        continueButton.click();
    }
}
