package com.saucedemo.automatedtests.pageobjects;

import com.saucedemo.automatedtests.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage extends BaseClass {
    private AddToCartPage addToCartPage;
    private LoginPage loginPage;

    @FindBy(className = "title")
    private WebElement checkoutPageTitle;

    @FindBy(name = "finish")
    private WebElement finishButton;

    @FindBy(className = "complete-header")
    private WebElement checkoutConfirmationMessage;

    @FindBy(className = "shopping_cart_link")
    private WebElement shopCartIcon;

    @FindBy(id = "back-to-products")
    private WebElement backToProductsButton;

    @FindBy(name = "checkout")
    private WebElement checkoutButton;

    @FindBy(id = "first-name")
    private WebElement firstName;

    @FindBy(id = "last-name")
    private WebElement lastName;

    @FindBy(id = "postal-code")
    private WebElement postalCode;

    @FindBy(id = "continue")
    private WebElement continueButton;

    //Method to login
    public void login() {
        loginPage = new LoginPage();
        loginPage = new LoginPage();
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();
    }

    //Method to add item to cart
    public void addProductToCart() {
        addToCartPage = new AddToCartPage();
        addToCartPage.clickOnProductName();
        addToCartPage.clickOnAddToCartButton();
    }

    public CheckOutPage() {
        PageFactory.initElements(getDriver(), this);
    }

    //Method to get checkout page title
    public String getCheckoutPageTitle() {
        return checkoutPageTitle.getText();
    }

    //Method to click on finish button
    public void clickOnFinishButton() {
        finishButton.click();
    }

    //Method to get checkout success message
    public String getCheckoutConfirmationMessage() {
        return checkoutConfirmationMessage.getText();
    }

    //Method to click on back home button
    public void clickOnShopCartIcon() {
        shopCartIcon.click();
    }

    //Method to click on checkout button
    public void clickOnCheckoutButton() {
        checkoutButton.click();
    }

    //Method to click on input first name
    public void enterFirstName(String first_name) {
        firstName.sendKeys(first_name);
    }

    public void enterLastName(String last_name) {
        lastName.sendKeys(last_name);
    }

    public void enterPostalCode(String postal_code) {
        postalCode.sendKeys(postal_code);
    }

    public void clickOnContinueButton() {
        continueButton.click();
    }

    public void clickOnBackHome(){
        backToProductsButton.click();
    }

}
