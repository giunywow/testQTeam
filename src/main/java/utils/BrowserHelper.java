package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.apache.commons.lang3.SystemUtils.*;

public class BrowserHelper {

    public WebDriver getChromeDriver() {
        if (!IS_OS_MAC && !IS_OS_WINDOWS)
            throw new RuntimeException("The OS it is not supported!");
        if (IS_OS_MAC)
            System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver");
        if (IS_OS_WINDOWS)
            System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }
}
