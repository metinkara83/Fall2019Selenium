package com.automation.tests.day1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyFirstSeleniumScript {

    private static ChromeDriver ChromeDriverdriver;

    public static void main(String[] args) {
        // setup ChromeDriver
        WebDriverManager.chromedriver().setup();
        // create chromedriver object
        ChromeDriver driver = new ChromeDriver();
        // open some website
        driver.get("http://google.com");

    }
}
