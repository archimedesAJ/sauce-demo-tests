package com.saucedemo.automatedtests.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Random;

public class ExtentReportManager {
    public static ExtentReports extent;

    public static ExtentHtmlReporter htmlReporter;
    public static String filename = "reports";

    public static Random rand = new Random();
    public static int n = rand.nextInt(10000)+1;


    //Configuration for lower version of Extent Report for android
    public static ExtentReports html_configuration() {
        if (extent == null) {
            extent = new ExtentReports();
            htmlReporter = new ExtentHtmlReporter(filename + "/sauce_report"+ n +".html");
            htmlReporter.config().setTheme(Theme.STANDARD);
            htmlReporter.config().setDocumentTitle("Sauce Demo Report");
            htmlReporter.config().setTimeStampFormat("EEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
            htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
            extent.attachReporter(htmlReporter);
        }
        else {
            htmlReporter = new ExtentHtmlReporter(filename + "/sauce_report"+ n +".html");
            extent.attachReporter(htmlReporter);
        }
        return extent;
    }

    //Method to capture screenshot and return a file path
    public static String captureScreenshots(WebDriver driver) throws IOException {
        File srcfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destination_filepath = new File("screenshots/screenshot"+System.currentTimeMillis()+ ".png");

        String absolute_pathlocation = destination_filepath.getAbsolutePath();

        Files.copy(srcfile.toPath(), destination_filepath.toPath());

        return absolute_pathlocation;
    }
}
