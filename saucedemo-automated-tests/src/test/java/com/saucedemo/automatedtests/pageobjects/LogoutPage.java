package com.saucedemo.automatedtests.pageobjects;

import com.saucedemo.automatedtests.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage extends BaseClass {
    private LoginPage loginPage;

    @FindBy(className = "bm-burger-button")
    private WebElement menuButton;

    @FindBy(id = "logout_sidebar_link")
    private WebElement logoutLink;

    @FindBy(className = "login_logo")
    private WebElement loginPageTitle;

    public LogoutPage() {
        PageFactory.initElements(getDriver(), this);
    }

    //Method to login
    public void login(){
        loginPage = new LoginPage();
        loginPage = new LoginPage();
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();
    }

    //Method to click on Menu button
    public void clickOnMenuButton() {
        menuButton.click();
    }

    //Method to click on Logout link
    public void clickOnLogoutLink() {
        logoutLink.click();
    }

    //Method to get Login page title
    public String getLoginPageTitle() {
        return loginPageTitle.getText();
    }

}
