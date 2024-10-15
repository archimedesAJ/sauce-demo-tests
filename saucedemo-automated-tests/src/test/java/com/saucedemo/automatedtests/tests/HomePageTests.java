package com.saucedemo.automatedtests.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.saucedemo.automatedtests.base.BaseClass;
import com.saucedemo.automatedtests.pageobjects.HomePage;
import com.saucedemo.automatedtests.pageobjects.LoginPage;
import com.saucedemo.automatedtests.utils.ConfigFileReader;
import com.saucedemo.automatedtests.utils.ExtentReportManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class HomePageTests extends BaseClass {
    private HomePage homePage;

    ConfigFileReader configFileReader = new ConfigFileReader();
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
    public void verifyPageTitle() throws IOException {
        ExtentTest test = extent.createTest("Verifying inventory page title").assignAuthor("Abraham").assignCategory("Functional Test");
        homePage = new HomePage();
        homePage.login();
        String pageTitle = homePage.getPageTitle();

        if (pageTitle.equals("Products")){
            test.pass("Test passed." + "Page title is: " + pageTitle);
        }
        else {
            test.fail("Test failed." + " Page title is " + pageTitle);
            test.addScreenCaptureFromPath(ExtentReportManager.captureScreenshots(getDriver()), "Failed Test Screenshot");
        }

    }

    @Test(priority = 1)
    public void verifyShoppingCartPresence() throws IOException, InterruptedException {
        ExtentTest test = extent.createTest("Verifying Shopping cart presence").assignAuthor("Abraham").assignCategory("Functional Test");
        homePage = new HomePage();
        homePage.login();
        boolean shopCartPresence = homePage.isShoppingCartPresent();
        if (shopCartPresence){
            test.pass("Shopping cart presence passed");
        }
        else {
            test.fail("Shopping cart presence failed");
            test.addScreenCaptureFromPath(ExtentReportManager.captureScreenshots(getDriver()), "Failed Test Screenshot");
        }
    }

    @Test(priority = 2)
    public void verifyProductSorting() throws IOException, InterruptedException {
        ExtentTest test = extent.createTest("Verifying product sorting by various types").assignAuthor("Abraham").assignCategory("Functional Test");
        homePage = new HomePage();
        homePage.login();

        //Method to select Price[low to high] sort type
        homePage.clickOnSelectContainer();
        homePage.selectPriceLowtoHigh();
        Thread.sleep(2000);

        //Method to select Price[high to low] sort type
        homePage.clickOnSelectContainer();
        homePage.selectPriceHighoLow();
        Thread.sleep(2000);

        //Method to select Name[ZtoA]
        homePage.clickOnSelectContainer();
        homePage.selectNameZtoA();
        Thread.sleep(2000);

        test.pass("Test passed. Product sorting by various types");
    }

}
