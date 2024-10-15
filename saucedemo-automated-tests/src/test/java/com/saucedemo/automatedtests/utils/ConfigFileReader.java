package com.saucedemo.automatedtests.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
    File file = new File("configuration/config.properties");

    private final Properties properties;

    public ConfigFileReader() {
        String configFilePath = file.getAbsolutePath();
        File configFile = new File(configFilePath);

        try {
            FileInputStream configFileReader = new FileInputStream(configFile);
            properties = new Properties();

            try {
                properties.load(configFileReader);
                configFileReader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    //Method to get url from config
    public String getURL() {
        String url = properties.getProperty("url");

        if (url != null) {
            return url;
        }
        else {
            throw new RuntimeException("url not set");
        }

    }

    //Method to get browser name from config
    public String getBrowserName() {
        String browser = properties.getProperty("browser");

        if (browser != null) {
            return browser;
        }
        else {
            throw new RuntimeException("browser not set");
        }

    }

    //Method to get timeout from config
    public Long getTimeout() {
        String timeout = properties.getProperty("implicitWaitTimeout");

        if (timeout != null) {
            return Long.parseLong(timeout);
        }
        else {
            throw new RuntimeException("implicitWaitTimeout not set");
        }

    }

    //Method to get first name from config
    public String getFirstName() {
        String first_name = properties.getProperty("first_name");

        if (first_name != null) {
            return first_name;
        }
        else {
            throw new RuntimeException("first_name not set");
        }

    }

    //Method to get lastname from config
    public String getLastName() {
        String last_name = properties.getProperty("last_name");

        if (last_name != null) {
            return last_name;
        }
        else {
            throw new RuntimeException("last_name not set");
        }

    }

    //Method to get lastname from config
    public String postalCode() {
        String postal_code = properties.getProperty("postal_code");

        if (postal_code != null) {
            return postal_code;
        }
        else {
            throw new RuntimeException("postal_code not set");
        }

    }


}
