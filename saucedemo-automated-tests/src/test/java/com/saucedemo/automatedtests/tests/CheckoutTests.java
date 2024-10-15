package com.saucedemo.automatedtests.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.saucedemo.automatedtests.base.BaseClass;
import com.saucedemo.automatedtests.pageobjects.AddToCartPage;
import com.saucedemo.automatedtests.pageobjects.CheckOutPage;
import com.saucedemo.automatedtests.utils.ConfigFileReader;
import com.saucedemo.automatedtests.utils.ExtentReportManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckoutTests extends BaseClass {

    ConfigFileReader configFileReader = new ConfigFileReader();
    private CheckOutPage checkOutPage;

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
    public void verifyProductCheckout() throws InterruptedException {
        ExtentTest test = extent.createTest("Verifying product checkout").assignAuthor("Abraham").assignCategory("Functional Test");
        checkOutPage = new CheckOutPage();
        checkOutPage.login();

        //Adding to cart
        checkOutPage.addProductToCart();

        //Checking out
        Thread.sleep(2000);
        checkOutPage.clickOnShopCartIcon();
        checkOutPage.clickOnCheckoutButton();

        //Fill out this info
        checkOutPage.enterFirstName(configFileReader.getFirstName());
        checkOutPage.enterLastName(configFileReader.getLastName());
        checkOutPage.enterPostalCode(configFileReader.postalCode());

        checkOutPage.clickOnContinueButton();

        Thread.sleep(2000);
        String checkout_page_title = checkOutPage.getCheckoutPageTitle();

        if(checkout_page_title.equals("Checkout: Overview")){
            test.pass("Test passed." + " " + checkout_page_title);
        }
        else{
            test.fail("Test failed." + " " + checkout_page_title);
        }

        checkOutPage.clickOnFinishButton();

        Thread.sleep(2000);

        String checkout_page_title2 = checkOutPage.getCheckoutPageTitle();
        if(checkout_page_title2.equals("Checkout: Complete!")){
            test.pass("Test passed." + " " + checkout_page_title2);
        }

        else{
            test.fail("Test failed." + " " + checkout_page_title2);
        }

        Thread.sleep(2000);
        String confirmation_message = checkOutPage.getCheckoutConfirmationMessage();
        if (confirmation_message.equals("Thank you for your order!")){
            test.pass("Test passed." + " " + confirmation_message);
        }
        else{
            test.fail("Test failed." + " " + confirmation_message);
        }

        checkOutPage.clickOnBackHome();
    }

}
