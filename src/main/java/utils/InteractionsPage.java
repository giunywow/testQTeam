package utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class InteractionsPage {
    @FindBy(id = "search") public WebElement searchTextInput;
    @FindBy(css = "[type='submit']") public WebElement searchSubmitButton;

    //products
    @FindBy(css = "[class = 'product-image-photo']") public List<WebElement> searchResults;

    //product detail page
    @FindBy(css = "[class = 'swatch-option text']") public  List<WebElement> itemSizes;
    @FindBy(css = "[class = 'swatch-option color']") public  List<WebElement> itemColors;
    @FindBy(id = "qty") public WebElement itemQuantity;
    @FindBy(id = "product-addtocart-button") public WebElement itemAddToCartButton;
    @FindBy(css = "[class = 'product-addto-links']") public WebElement itemAddToWishList;
    @FindBy(xpath = "//div[contains(text(),'You added')]") public WebElement itemAddToCartSuccessMessage;


    //cart
    @FindBy(css = "[class ='action showcart']") public WebElement cartShowCartContent;
    @FindBy(id = "top-cart-btn-checkout") public WebElement cartProceedToCheckoutButton;

    //checkout
    @FindBy(css = "[class='field required'] > div > input") public WebElement checkoutEmailAddressField;
    @FindBy(css = "[id = 'co-shipping-form'] > div > div > div > input") public WebElement checkoutFirstName;
    @FindBy(css = "[id = 'co-shipping-form'] > div > div:nth-child(2) > div > input") public WebElement checkoutLastName;
    @FindBy(css = "[name='street[0]']") public WebElement checkoutStreetAddress;
    @FindBy(css = "[name='city']") public WebElement checkoutCity;
    @FindBy(css = "[name = 'region_id'") public WebElement checkoutStateSelect;
    @FindBy(css = "[name = 'postcode']") public WebElement checkoutPostalCode;
    @FindBy(css = "[name = 'country_id']") public WebElement checkoutCountry;
    @FindBy(css = "[name = 'telephone']") public WebElement checkoutTelephone;
    @FindBy(css = "[value = 'flatrate_flatrate']") public WebElement checkoutShippingMethod;
    @FindBy(css = "[class = 'button action continue primary'") public WebElement checkoutNextStep1;

    //checkout part2
    @FindBy(css = "[name = 'billing-address-same-as-shipping']") public WebElement checkoutSameBillingAndShippingAddressCheckbox;
    @FindBy(css = "[class= 'action primary checkout']") public WebElement checkoutPlaceOrderButton;

    //order success
    @FindBy(xpath = "//span[contains(text(),'Thank you for your purchase!')]") public WebElement orderSuccessMessage1;
    @FindBy(css = "[class = 'marked-element-temp']") public WebElement orderSuccessMessage2;

    //login
    @FindBy(xpath = "//a[contains(text(), 'Sign In')]") public WebElement loginLink;
    @FindBy(id = "email") public WebElement loginEmail;
    @FindBy(id = "pass") public WebElement loginPassword;
    @FindBy(css = "[class = 'action login primary']") public WebElement loginSignInButton;
    @FindBy(css = "[class = 'logged-in']") public List<WebElement> loginGreetingMessage;
    @FindBy(css = "[class='logo']") public WebElement websitePageLogo;

    //registration
    @FindBy(xpath = "//a[contains(text(), 'Create an Account')]") public WebElement registrationLink;
    @FindBy(id = "firstname") public WebElement registrationFirstName;
    @FindBy(id = "lastname") public WebElement registrationLastName;
    @FindBy(id = "email_address") public WebElement registrationEmailAddress;
    @FindBy(id = "password") public WebElement registrationPassword;
    @FindBy(id = "password-confirmation") public WebElement registrationConfirmPassword;
    @FindBy(css = "[class='action submit primary']") public WebElement registrationCreateAccountButton;
    @FindBy(xpath = "//div[contains(text(), 'Thank you for registering with Main Website Store')]") public WebElement registrationSuccessMessage;

    //login error check
    @FindBy(id = "email-error") public WebElement errorMessageLoginPageEmail;
    @FindBy(id = "pass-error") public WebElement getErrorMessageLoginPagePasswd;
    @FindBy(css = "[class = 'messages']") public WebElement errorMessageLoginPageFailedLogin;
    @FindBy(xpath = "//div[contains(text(), 'The account sign-in was incorrect')]") public WebElement errorMessageLoginPageFailedLogin2;




}