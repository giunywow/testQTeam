package com.softwaretestingboard.magento;

import static org.junit.jupiter.api.Assertions.assertTrue;

import dev.failsafe.internal.util.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserHelper;
import utils.InteractionsPage;

import java.util.List;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MagentoTest extends Hooks {

    @Test
    public void homepageCheck() throws InterruptedException {
        driver.get("https://magento.softwaretestingboard.com/");
        waitForPageLoadComplete();

        System.out.println("Page title: " + driver.getTitle());
        System.out.println("Page url: " + driver.getCurrentUrl());

        //search for a product
        interactionsPage.searchTextInput.clear();
        interactionsPage.searchTextInput.click();
        interactionsPage.searchTextInput.sendKeys("Maxima Drawstring Short");
        interactionsPage.searchSubmitButton.click();

        //select from search result select item details and add to basket
        waitElementIsDisplayed(interactionsPage.searchResults.get(0));
        interactionsPage.searchResults.get(0).click();
        waitForPageLoadComplete();
        waitElementIsDisplayed(interactionsPage.itemAddToCartButton);
        interactionsPage.itemSizes.get(0).click();
        interactionsPage.itemColors.get(0).click();
        interactionsPage.itemQuantity.clear();
        interactionsPage.itemQuantity.sendKeys("2");
        scrollElementIntoView(interactionsPage.itemAddToCartButton);
        interactionsPage.itemAddToCartButton.click();
        waitElementIsClickable(interactionsPage.cartShowCartContent);
        waitElementIsDisplayed(interactionsPage.itemAddToCartSuccessMessage);
        interactionsPage.itemAddToCartSuccessMessage.isDisplayed();
        waitForPageLoadComplete();
        waitForJQuery();

        //cart
        waitElementIsClickable(interactionsPage.cartShowCartContent);
        interactionsPage.cartShowCartContent.click();
        waitElementIsClickable(interactionsPage.cartProceedToCheckoutButton);
        interactionsPage.cartProceedToCheckoutButton.click();

        //checkout
        waitForPageLoadComplete();
        waitForJQuery();
        waitElementIsDisplayed(interactionsPage.checkoutEmailAddressField);
        interactionsPage.checkoutEmailAddressField.clear();
        interactionsPage.checkoutEmailAddressField.sendKeys("gigi@kent.ro");
        waitElementIsDisplayed(interactionsPage.checkoutFirstName);
        interactionsPage.checkoutFirstName.sendKeys("Gigi");
        waitElementIsDisplayed(interactionsPage.checkoutLastName);
        interactionsPage.checkoutLastName.sendKeys("Kent");
        waitElementIsDisplayed(interactionsPage.checkoutStreetAddress);
        interactionsPage.checkoutStreetAddress.sendKeys("random address");
        waitElementIsDisplayed(interactionsPage.checkoutCity);
        interactionsPage.checkoutCity.sendKeys("Budapchrest");
        waitElementIsDisplayed(interactionsPage.checkoutStateSelect);
        interactionsPage.checkoutStateSelect.click();
        interactionsPage.checkoutStateSelect.sendKeys(Keys.DOWN);
        interactionsPage.checkoutStateSelect.sendKeys(Keys.DOWN);
        interactionsPage.checkoutStateSelect.sendKeys(Keys.RETURN);
        interactionsPage.checkoutPostalCode.sendKeys("74820");
        interactionsPage.checkoutCountry.click();
        interactionsPage.checkoutCountry.sendKeys(Keys.DOWN);
        interactionsPage.checkoutCountry.sendKeys(Keys.DOWN);
        interactionsPage.checkoutCountry.sendKeys(Keys.RETURN);
        interactionsPage.checkoutTelephone.sendKeys("998765434567");
        interactionsPage.checkoutShippingMethod.click();
        waitElementIsClickable(interactionsPage.checkoutNextStep1);
        interactionsPage.checkoutNextStep1.click();

        //checkout part2
        waitElementIsDisplayed(interactionsPage.checkoutSameBillingAndShippingAddressCheckbox);
        System.out.println(interactionsPage.checkoutSameBillingAndShippingAddressCheckbox.getAttribute("checked"));
        if(!Boolean.parseBoolean(interactionsPage.checkoutSameBillingAndShippingAddressCheckbox.getAttribute("checked"))) {
            interactionsPage.checkoutSameBillingAndShippingAddressCheckbox.click();
        }
        waitElementIsDisplayed(interactionsPage.checkoutPlaceOrderButton);
        interactionsPage.checkoutPlaceOrderButton.click();

        //order success
        waitElementIsDisplayed(interactionsPage.orderSuccessMessage1);

        Thread.sleep(20000);

    }
}
