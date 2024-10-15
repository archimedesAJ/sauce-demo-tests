package com.saucedemo.automatedtests.pageobjects;

import com.saucedemo.automatedtests.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass {

    @FindBy(id="user-name")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(xpath = "/html/body/div/div/div[2]/div[1]/div/div/form/div[3]/h3")
    private WebElement getMessage;

    @FindBy (xpath = "/html/body/div/div/div/div[1]/div[2]/span")
    private WebElement pageTitle;

    public LoginPage() {
        PageFactory.initElements(getDriver(), this);
    }

    //Method to enter username
    public void enterUsername(String username) {
        usernameField.sendKeys(username);
    }

    //Method to enter password
    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    //Method to click on login button
    public void clickLoginButton() {
        loginButton.click();
    }

    //Method to click on login button
    public String getMessage() {
        return getMessage.getText();
    }

    //Method to check if message is empty
    public String getPageTitle() {
        return pageTitle.getText();
    }

}
