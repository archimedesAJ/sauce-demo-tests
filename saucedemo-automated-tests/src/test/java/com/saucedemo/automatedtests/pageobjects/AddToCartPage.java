package com.saucedemo.automatedtests.pageobjects;

import com.saucedemo.automatedtests.base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCartPage extends BaseClass {

    private LoginPage loginPage;

    @FindBy(className = "inventory_item_name")
    private WebElement itemName;

    @FindBy(className = "shopping_cart_badge")
    private WebElement cartBadge;


    @FindBy(id = "add-to-cart")
    private WebElement addToCartButton;

    @FindBy(id = "back-to-products")
    private WebElement backToProductsButton;

    @FindBy(className = "shopping_cart_link")
    private WebElement shoppingCartIcon;

    @FindBy(className = "cart_quantity")
    private WebElement cartQuantity;

    @FindBy(className = "inventory_item_price")
    private WebElement itemPrice;



    public AddToCartPage() {
        PageFactory.initElements(getDriver(), this);
    }

    //Method to login
    public void login(){
        loginPage = new LoginPage();
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();
    }

    //Method to get cart badge count
    public String getCartBadgeCount(){
        return cartBadge.getText();
    }

    //Method to click on product name
    public void clickOnProductName() {
        itemName.click();
    }

    //Method to click on add to cart button
    public void clickOnAddToCartButton() {
        addToCartButton.click();
    }

    //Method to click on back to product button
    public void clickOnBackToProductsButton() {
        backToProductsButton.click();
    }

    //Method to click on shopping cart icon
    public void clickOnShoppingCartIcon() {
        shoppingCartIcon.click();
    }

    //Method to get cart quantity
    public String getCartQuantity() {
        return cartQuantity.getText();
    }

    //Method to get item price
    public String getItemPrice() {
        return itemPrice.getText();
    }

}
