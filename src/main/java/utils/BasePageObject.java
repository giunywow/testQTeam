package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.Random;


public abstract class BasePageObject {
    private static final int REGULAR_TIMEOUT = 30;
    public BrowserHelper browserHelper = new BrowserHelper();
    protected static WebDriver driver;

    public WebDriver getDriver() {
        driver = browserHelper.getChromeDriver();
        return driver;
    }

    public static void waitElementIsDisplayed(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(REGULAR_TIMEOUT));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitElementIsClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(REGULAR_TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitForPageLoadComplete() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(REGULAR_TIMEOUT));
        wait.until(driver1 -> String.valueOf(((JavascriptExecutor) driver1).executeScript("return document.readyState")).equals("complete"));
    }

    public static void waitForJQuery() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(REGULAR_TIMEOUT));
        ExpectedCondition<Boolean> condition = arg -> {
            try {
                return (Boolean) ((JavascriptExecutor) driver).executeScript( "return jQuery.active == 0");
            } catch (Exception e) {
                return true;
            }
        };
        wait.until(condition); }


    public int randomNumber(int min, int max) {
        return new Random().nextInt(max - min + 1) + min;
    }

    public boolean hasFocus(WebElement element) {
        WebElement elementInFocus = driver.switchTo().activeElement();
        return element.equals(elementInFocus);
    }

    public void hoverElement(WebElement element) {
        new Actions(driver).moveToElement(element).perform();
    }

    public static void scrollElementIntoView(WebElement element) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView({behaviour: 'smooth', block: 'center'});", element);
    }

    public void waitElementContainsText(WebElement element, String expectedText, int REGULAR_TIMEOUT) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(REGULAR_TIMEOUT));
        driver.findElement((By) element).getText().contains(expectedText);

    }
}

