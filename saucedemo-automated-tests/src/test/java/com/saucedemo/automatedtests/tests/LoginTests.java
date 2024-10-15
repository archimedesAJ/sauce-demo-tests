package com.saucedemo.automatedtests.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.saucedemo.automatedtests.base.BaseClass;
import com.saucedemo.automatedtests.pageobjects.HomePage;
import com.saucedemo.automatedtests.pageobjects.LoginPage;
import com.saucedemo.automatedtests.utils.ConfigFileReader;
import com.saucedemo.automatedtests.utils.ExtentReportManager;
import com.saucedemo.automatedtests.utils.ReadExcelFile;
import org.testng.annotations.*;

import java.io.IOException;

public class LoginTests extends BaseClass {

    ConfigFileReader configFileReader = new ConfigFileReader();
    private LoginPage loginPage;

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


    //Test to verify locked out user login
    @Test(priority = 1)
    public void unSuccessfulLoginWithLockedOutUsernameAndPassword() throws InterruptedException, IOException {
        ExtentTest test = extent.createTest("Verifying unsuccessful login using problem username and password").assignAuthor("Abraham").assignCategory("Functional Test");
        loginPage = new LoginPage();
        loginPage.enterUsername("locked_out_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();
        Thread.sleep(2000);
        String error_msg = loginPage.getMessage();
        if (error_msg.equals("Epic sadface: Sorry, this user has been locked out.")) {
            test.pass("Test passed" + error_msg);
        } else {
            test.fail("Test failed");
            test.addScreenCaptureFromPath(ExtentReportManager.captureScreenshots(getDriver()), "Failed Test Screenshot");
        }
    }


    //Test to verify successful login with performance glitch username and password
    @Test(priority = 2)
    public void unSuccessfulLoginWithPerformanceGlitchUsernameAndPassword() throws InterruptedException, IOException {
        ExtentTest test = extent.createTest("Verifying unsuccessful login using performance glitch username and password").assignAuthor("Abraham").assignCategory("Functional Test");
        loginPage = new LoginPage();
        loginPage.enterUsername("invalid_user");
        loginPage.enterPassword("invalid_password");
        loginPage.clickLoginButton();

        Thread.sleep(2000);
        String error_msg = loginPage.getMessage();

        if (error_msg.equals("Epic sadface: Username and password do not match any user in this service")){
            test.pass("Test passed" + error_msg);
        }
        else {
            test.fail("Test failed");
            test.addScreenCaptureFromPath(ExtentReportManager.captureScreenshots(getDriver()), "Failed Test Screenshot");
        }
    }

    //Test to verify login with provided username and password [Data driven testing]
    @Test(priority = 3, dataProvider = "testdata")
    public void loginWithUsernameAndPassword(String username, String password) throws InterruptedException {
        ExtentTest test = extent.createTest("Verifying unsuccessful login using locked out username and password").assignAuthor("Abraham").assignCategory("Functional Test");
        loginPage = new LoginPage();
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
        Thread.sleep(2000);
        String page_title = loginPage.getPageTitle();
        if (page_title.equals("Products")){
            test.pass("Test passed" + page_title);
        }
        else {
            test.fail("Test failed");
        }

    }


    //Test to verify successful login with standard username and password
    @Test(priority = 4)
    public void successfulLoginWithStandardUsernameAndPassword() throws InterruptedException, IOException {
        ExtentTest test = extent.createTest("Verifying successful login using valid username and password").assignAuthor("Abraham").assignCategory("Functional Test");
        loginPage = new LoginPage();
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();
        Thread.sleep(2000);
        String page_title = loginPage.getPageTitle();
        if (page_title.equals("Products")){
            test.pass("Test passed" + page_title);
        }
        else {
            test.fail("Test failed");
            test.addScreenCaptureFromPath(ExtentReportManager.captureScreenshots(getDriver()), "Failed Test Screenshot");
        }
    }



    //Method to retrieve test data from the xls file to be used by the tests
    @DataProvider(name="testdata")
    public Object[][] TestDataFeed() {
        ReadExcelFile config = new ReadExcelFile("TestData/Credentials.xls");

        int rows = config.getRowCount(0);
        System.out.println(rows);

        Object[][] credentials = new Object[rows][2];

        for (int i=0; i<rows; i++){
            credentials[i][0] = config.getData(0, i, 0);
            credentials[i][1] = config.getData(0, i, 1);

        }
        return credentials;
    }


}
