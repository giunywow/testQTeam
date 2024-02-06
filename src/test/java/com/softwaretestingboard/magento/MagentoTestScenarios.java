package com.softwaretestingboard.magento;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.github.javafaker.Faker;
import data.StaticData;
import dev.failsafe.internal.util.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MagentoTestScenarios extends Hooks {

    //Test scenario - Guest user; add item to cart; do the order checkout
    @Test
    public void checkoutAsGuestUser() {
        StepsDefinitions.navigateHomepage();

        System.out.println("Page title: " + driver.getTitle());
        System.out.println("Page url: " + driver.getCurrentUrl());

        //search for a product
        StepsDefinitions.searchProduct();

        //select from search result select item details and add to basket
        StepsDefinitions.selectItemFromPLP();

        //cart
        waitForPageLoadComplete();
        waitForJQuery();
        waitElementIsClickable(interactionsPage.cartShowCartContent);
        interactionsPage.cartShowCartContent.click();
        waitElementIsClickable(interactionsPage.cartProceedToCheckoutButton);
        interactionsPage.cartProceedToCheckoutButton.click();

        //checkout
        StepsDefinitions.checkoutPart1();

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
    }

    //Test scenario - Login as already registered user
    @Test
    public void loginAsExistingUser() {
        StepsDefinitions.navigateHomepage();
        interactionsPage.loginLink.click();

        //loginPage
        waitForPageLoadComplete();
        waitElementIsDisplayed(interactionsPage.loginEmail);
        interactionsPage.loginEmail.clear();
        interactionsPage.loginEmail.sendKeys(StaticData.LOGIN_EMAIL_ADDRESS.getData());
        interactionsPage.loginPassword.clear();
        interactionsPage.loginPassword.sendKeys(StaticData.LOGIN_PASSWD.getData());
        interactionsPage.loginSignInButton.click();

        //check login success
        waitForPageLoadComplete();
        waitElementIsDisplayed(interactionsPage.loginGreetingMessage.get(0));
    }

    //Test scenario - Register user
    @Test
    public void registerUser() {
        StepsDefinitions.navigateHomepage();
        interactionsPage.registrationLink.click();

        //registration page
        StepsDefinitions.registration();

        //check registration success
        waitForPageLoadComplete();
        waitElementIsDisplayed(interactionsPage.registrationSuccessMessage);
    }

    //Test Scenario - Buy item as Registered user
    @Test
    public void registeredUserBuyItem() {
        StepsDefinitions.navigateHomepage();
        interactionsPage.registrationLink.click();

        //registration page
        StepsDefinitions.registration();

        //check registration success
        waitForPageLoadComplete();
        waitElementIsDisplayed(interactionsPage.registrationSuccessMessage);

        //search for a product
        StepsDefinitions.searchProduct();

        //select from search result select item details and add to basket
        StepsDefinitions.selectItemFromPLP();

        //cart
        waitForPageLoadComplete();
        waitForJQuery();
        waitElementIsClickable(interactionsPage.cartShowCartContent);
        interactionsPage.cartShowCartContent.click();
        waitElementIsClickable(interactionsPage.cartProceedToCheckoutButton);
        interactionsPage.cartProceedToCheckoutButton.click();

        //checkout
        StepsDefinitions.checkoutRegisteredUserPart1();

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
    }

    //Test scenario - Check error messages and failed login on login page
    @Test
    public void checkErrorMessagesLoginPage() throws InterruptedException {
        Faker faker = new Faker();

        StepsDefinitions.navigateHomepage();
        interactionsPage.loginLink.click();

        //loginPage

        //trigger email error message - invalid email address
        waitForPageLoadComplete();
        waitElementIsDisplayed(interactionsPage.loginEmail);
        interactionsPage.loginEmail.clear();
        interactionsPage.loginEmail.sendKeys(StaticData.LOGIN_INVALID_EMAIL_ADDRESS.getData());
        interactionsPage.loginPassword.clear();
        interactionsPage.loginPassword.sendKeys(StaticData.LOGIN_PASSWD.getData());
        interactionsPage.loginSignInButton.click();

        //check email error message - invalid email address
        Assert.isTrue(interactionsPage.errorMessageLoginPageEmail.getText().contains("Please enter a valid email address"), "Error message not as expected");

        //trigger both email (invalid email address) and passwd error messages
        interactionsPage.loginPassword.clear();
        interactionsPage.loginSignInButton.click();

        //check both email (invalid email address) and passwd error messages
        Assert.isTrue(interactionsPage.errorMessageLoginPageEmail.getText().contains("Please enter a valid email address"), "Error message not as expected");
        Assert.isTrue(interactionsPage.getErrorMessageLoginPagePasswd.getText().contains("This is a required field"), "Error message not as expected");

        //trigger both email (empty field) and passed error messages
        interactionsPage.loginEmail.clear();
        interactionsPage.loginSignInButton.click();

        //check both email (empty field) and passed error messages
        Assert.isTrue(interactionsPage.errorMessageLoginPageEmail.getText().contains("This is a required field"), "Error message not as expected");
        Assert.isTrue(interactionsPage.getErrorMessageLoginPagePasswd.getText().contains("This is a required field"), "Error message not as expected");

        //login with already registered email and invalid passwd
        interactionsPage.loginEmail.sendKeys(StaticData.LOGIN_EMAIL_ADDRESS.getData());
        interactionsPage.loginPassword.sendKeys(faker.internet().password());
        interactionsPage.loginSignInButton.click();

        //check invalid login message
        waitElementIsDisplayed(interactionsPage.errorMessageLoginPageFailedLogin);
        waitElementIsDisplayed(interactionsPage.errorMessageLoginPageFailedLogin2);
        Assert.isTrue(interactionsPage.errorMessageLoginPageFailedLogin2.isDisplayed(), "Error message not as expected");
    }
}
