package Pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class BasePage {

    protected static WebDriver webDriver;
    protected static WebDriverWait wait;

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));

    }

    protected static void clickElementByXpath(String xpath) {

        findElementByXpath(xpath).click();
    }

    protected void sendTextToElementByXpath(String xpath, String text) {

        findElementByXpath(xpath).sendKeys(text);
    }

    protected static boolean elementExists(String xpath) {
        try {
            findElementByXpath(xpath);
            webDriver.findElement(By.xpath(xpath));
            return true;
        } catch (Exception err) {


            return false;
        }

    }

    protected static WebElement findElementByXpath(String xpath) {
        WebElement element;
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        element = webDriver.findElement(By.xpath(xpath));
        return element;
    }

    protected static String getCurrentPageUrl() {
        return webDriver.getCurrentUrl();

    }

    protected static WebElement moveToElement(String xpath) {
        WebElement element;
        element = webDriver.findElement(By.xpath(xpath));
        element.click();
        Actions actions = new Actions(webDriver);
        actions.moveToElement(element).build().perform();
        return element;
    }



    protected static WebElement captureImage(String xpath)  {
        WebElement logo;
        logo = webDriver.findElement(By.xpath(xpath));
        return logo;
    }

    protected static LogEntries getLogs() {
        LogEntries entries = webDriver.manage().logs().get(LogType.BROWSER);
            return entries;
        }
    }


