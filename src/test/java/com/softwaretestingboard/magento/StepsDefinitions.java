package com.softwaretestingboard.magento;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StepsDefinitions extends Hooks {
    public static String email;

    public static void navigateHomepage() {
        driver.get("https://magento.softwaretestingboard.com/");
        waitForPageLoadComplete();
    }

    public static void searchProduct(){
        waitForPageLoadComplete();
        interactionsPage.searchTextInput.clear();
        interactionsPage.searchTextInput.click();
        interactionsPage.searchTextInput.sendKeys("Maxima Drawstring Short");
        interactionsPage.searchSubmitButton.click();
    }

    public static void checkoutPart1(){
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
    }

    public static void registration() {
        Faker faker = new Faker();
        email = "test_" + DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss").format(LocalDateTime.now()) + "_qteam@testqteam.com";
        System.out.println("email: " + email);
        waitForPageLoadComplete();
        waitElementIsDisplayed(interactionsPage.registrationFirstName);
        interactionsPage.registrationFirstName.sendKeys(faker.name().firstName());
        interactionsPage.registrationLastName.sendKeys(faker.name().lastName());
        interactionsPage.registrationEmailAddress.sendKeys(email);
        interactionsPage.registrationPassword.sendKeys("Parola!2");
        interactionsPage.registrationConfirmPassword.sendKeys("Parola!2");
        waitElementIsClickable(interactionsPage.registrationCreateAccountButton);
        interactionsPage.registrationCreateAccountButton.click();
    }

    public static void selectItemFromPLP() {
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
    }

    public static void checkoutRegisteredUserPart1() {
        waitForPageLoadComplete();
        waitForJQuery();
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
    }
}
