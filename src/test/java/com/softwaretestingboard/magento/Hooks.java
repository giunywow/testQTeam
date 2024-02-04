package com.softwaretestingboard.magento;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.BasePageObject;
import utils.BrowserHelper;
import utils.InteractionsPage;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Hooks extends BasePageObject {
//    public BrowserHelper browserHelper = new BrowserHelper();
//    public WebDriver driver;
    public InteractionsPage interactionsPage;

    @BeforeAll
    void beforeAll() {
//        driver = browserHelper.getChromeDriver();
        getDriver();
        interactionsPage = PageFactory.initElements(driver, InteractionsPage.class);
    }

    @AfterAll
    void afterAll() {
        driver.quit();
    }

}
