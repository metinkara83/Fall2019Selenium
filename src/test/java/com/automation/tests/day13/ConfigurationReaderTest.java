package com.automation.tests.day13;

import com.automation.utilities.ConfigurationReader;
import org.testng.annotations.Test;

public class ConfigurationReaderTest {

    @Test
    public void readProperties(){
        String browser = ConfigurationReader.getProperty("browser");
        String url = ConfigurationReader.getProperty("ga2");

        System.out.println(browser);
        System.out.println(url);

        String storeManager = ConfigurationReader.getProperty("storeManager1");
        String password = ConfigurationReader.getProperty("password");
        String driver = ConfigurationReader.getProperty("truckDriver1");

        System.out.println(storeManager);
        System.out.println(password);
        System.out.println(driver);

    }
}
