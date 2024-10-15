package com.saucedemo.automatedtests.base;

import com.saucedemo.automatedtests.utils.ConfigFileReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.time.Duration;

public class BaseClass {

    ConfigFileReader configFileReader = new ConfigFileReader();

    // Declare ThreadLocal Driver
    public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        // Get Driver from threadLocalmap
        return driver.get();
    }


    public void launchApp(String browserName) {
        if (browserName.equalsIgnoreCase("Chrome")) {
            WebDriverManager.chromedriver().setup();
            driver.set(new ChromeDriver());

        } else if (browserName.equalsIgnoreCase("FireFox")) {
            WebDriverManager.firefoxdriver().setup();
            driver.set(new FirefoxDriver());

        } else if (browserName.equalsIgnoreCase("IE")) {
            WebDriverManager.iedriver().setup();
            driver.set(new InternetExplorerDriver());

        }

        //Setting the url to the driver
        getDriver().get(configFileReader.getURL());

        //Maximize the screen
        getDriver().manage().window().maximize();

        //Delete all the cookies
        getDriver().manage().deleteAllCookies();

        //Implicit TimeOuts
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(configFileReader.getTimeout()));
    }

}
