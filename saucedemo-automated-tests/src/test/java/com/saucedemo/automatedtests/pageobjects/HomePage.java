package com.saucedemo.automatedtests.pageobjects;

import com.saucedemo.automatedtests.base.BaseClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends BaseClass {

    private LoginPage loginPage;

    @FindBy(id = "shopping_cart_container")
    private WebElement shoppingCartContainer;

    @FindBy(className = "product_sort_container")
    private WebElement selectContainer;

    @FindBy(xpath = "/html/body/div/div/div/div[1]/div[2]/div/span/select/option[2]")
    private WebElement selectOption2;

    @FindBy(xpath = "/html/body/div/div/div/div[1]/div[2]/div/span/select/option[3]")
    private WebElement selectOption3;

    @FindBy(xpath = "/html/body/div/div/div/div[1]/div[2]/div/span/select/option[4]")
    private WebElement selectOption4;


    @FindBy(className = "title")
    private WebElement pageTitle;

    public HomePage() {
        PageFactory.initElements(getDriver(), this);
    }

    //Method to click on select container
    public void clickOnSelectContainer() {
        selectContainer.click();
    }

    //Method to select option (Name[Z to A]
    public void selectNameZtoA() {
        selectOption2.click();
    }

    //Method to select PriceLowtoHigh
    public void selectPriceLowtoHigh() {
        selectOption3.click();
    }

    //Method to select PriceHighoLow
    public void selectPriceHighoLow() {
        selectOption4.click();
    }

    //Method to verify existence of shopping cart
    public boolean isShoppingCartPresent() {
        return shoppingCartContainer.isDisplayed();
    }

    //Method to login
    public void login(){
        loginPage = new LoginPage();
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();
    }

    //Method to verify page title is Products
    public String getPageTitle() {
        return pageTitle.getText();
    }
}
