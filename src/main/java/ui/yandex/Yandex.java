package ui.yandex;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.AbstractPage;
import businessobjects.YandexLogin;

/**
 * Created by Maryia_Shynkarenka on 6/21/2017.
 */
public class Yandex extends AbstractPage {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//input[@name='login']")
    WebElement loginField;

    @FindBy(xpath = "//input[@name='passwd']")
    WebElement passwordField;

    @FindBy(xpath = "//input[@class='checkbox__control']")
    WebElement alienComputerCheckbox;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement buttonSubmit;

    public Yandex(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void yandexLogin(YandexLogin yandexLogin){
        waitElement(loginField);
        loginField.sendKeys(yandexLogin.getLogin());
        passwordField.sendKeys(yandexLogin.getPassword());
    }

    public void clickSubmitButton(){
        buttonSubmit.click();
    }
}
