package com.saucedemo.automatedtests.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.saucedemo.automatedtests.base.BaseClass;
import com.saucedemo.automatedtests.pageobjects.LogoutPage;
import com.saucedemo.automatedtests.utils.ConfigFileReader;
import com.saucedemo.automatedtests.utils.ExtentReportManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogoutTests extends BaseClass {

    ConfigFileReader configFileReader = new ConfigFileReader();
    private LogoutPage logoutPage;

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

    @Test(priority = 1)
    public void verifyLogout(){
        ExtentTest test = extent.createTest("Verifying user logout").assignAuthor("Abraham").assignCategory("Functional Test");
        logoutPage = new LogoutPage();

        //login
        logoutPage.login();

        logoutPage.clickOnMenuButton();
        logoutPage.clickOnLogoutLink();

        String confirm_logout = logoutPage.getLoginPageTitle();

        if (confirm_logout.equals("Swag Labs")){
            test.pass("Verifying user logout successful" + " " + confirm_logout);
        }
        else {
            test.fail("Verifying user logout failed");
        }

    }

}
