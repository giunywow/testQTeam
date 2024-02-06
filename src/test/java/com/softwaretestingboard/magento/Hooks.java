package com.softwaretestingboard.magento;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.support.PageFactory;
import utils.BasePageObject;
import utils.InteractionsPage;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Hooks extends BasePageObject {
    public static InteractionsPage interactionsPage;

    @BeforeAll
    void beforeAll() {
        getDriver();
        interactionsPage = PageFactory.initElements(driver, InteractionsPage.class);
    }

    @AfterAll
    void afterAll() {
        driver.quit();
    }

}
