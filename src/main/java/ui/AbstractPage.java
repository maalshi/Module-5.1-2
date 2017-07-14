package ui;

import com.thoughtworks.selenium.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import javax.xml.bind.Element;

public abstract class AbstractPage{

    protected WebDriver driver;
    protected WebDriverWait wait;

    public void dragAndDrop(WebElement toBeDragged, WebElement target){
        new Actions(driver).dragAndDrop(toBeDragged, target).build().perform();
    }

    public void waitElement (WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitElement (By locator){
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(locator)));
    }

    public void jsClick(WebElement element){
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
    }
    public void waitHighlightAndClickElement(By locator){
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(locator)));
        ((JavascriptExecutor)driver).executeScript("arguments[0].style.backgroundColor='red'", driver.findElement(locator));
    }

    public void waitHighlightAndClickElement(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
        ((JavascriptExecutor)driver).executeScript("arguments[0].style.backgroundColor='red'", element);
    }

    public void waitForElementInvisible(By locator){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }
}

