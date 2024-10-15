package com.saucedemo.automatedtests.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.saucedemo.automatedtests.base.BaseClass;
import com.saucedemo.automatedtests.pageobjects.AddToCartPage;
import com.saucedemo.automatedtests.utils.ConfigFileReader;
import com.saucedemo.automatedtests.utils.ExtentReportManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class AddToCartTests extends BaseClass {
    ConfigFileReader configFileReader = new ConfigFileReader();
    private AddToCartPage addToCartPage;

    ExtentReports extent = ExtentReportManager.html_configuration();


    @BeforeMethod
    public void setUp() {
        launchApp(configFileReader.getBrowserName());
    }

    @AfterMethod()
    public void tearDown() {
        extent.flush();
        getDriver().quit();
    }

    @Test
    public void setConfig(){
        ExtentReportManager.html_configuration();
    }


    @Test()
    public void verifyAddToProductToCart() throws IOException, InterruptedException {
        ExtentTest test = extent.createTest("Verifying adding products to cart").assignAuthor("Abraham").assignCategory("Functional Test");
        addToCartPage = new AddToCartPage();
        addToCartPage.login();


        addToCartPage.clickOnProductName();
        addToCartPage.clickOnAddToCartButton();

        Thread.sleep(2000);
        String cartBadgeNumber = addToCartPage.getCartBadgeCount();

        if (cartBadgeNumber.equals("1")){
            test.pass("Test passed." + "The cart badge number is: " + cartBadgeNumber);
        }
        else {
            test.fail("Test failed." + "The cart badge number is: " + cartBadgeNumber);
            test.addScreenCaptureFromPath(ExtentReportManager.captureScreenshots(getDriver()), "Failed Test Screenshot");
        }

        Thread.sleep(1000);
        addToCartPage.clickOnShoppingCartIcon();
        String cart_qty = addToCartPage.getCartQuantity();
        if (cart_qty.equals("1")){
            test.pass("Test passed." + "The cart quantity is: " + cart_qty);

        }
        else {
            test.fail("Test failed." + "The cart quantity is: " + cart_qty);
            test.addScreenCaptureFromPath(ExtentReportManager.captureScreenshots(getDriver()), "Failed Test Screenshot");
        }

        Thread.sleep(1000);
        String item_price = addToCartPage.getItemPrice();
        if (item_price.equals("$29.99")){
            test.pass("Test passed." + "The item price is: " + item_price);
        }
        else {
            test.fail("Test failed." + "The item price is: " + item_price);
        }

    }
}
