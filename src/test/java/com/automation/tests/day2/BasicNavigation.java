package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BasicNavigation {

    public static void main(String[] args) throws Exception {

        // to start selenium script we need:
        // setup webdriver (browser driver) and create webdriver object
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        // RemoteWebDriver driver = new FirefoxDriver(); // Polymorphism
        // In Selenium, everything starts from WebDriver interface
        driver.get("http://google.com"); // to open a website
        driver.manage().window().maximize(); // to maximize the browser

        // driver.manage().window().fullscreen(); // to make the browser full screen
        Thread.sleep(3000); // for demo, wait 3 seconds
        String title = driver.getTitle(); // returns <title>Some title</title> text
        String expectedTitle = "Google";
        System.out.println("Title is : "+title);
//        if (expectedTitle.equals(title)){
//            System.out.println("TEST PASSED!");
//        } else {
//            System.out.println("TEST FAILED!");
//        }
        verifyEquals(driver.getTitle(),"Google");

        driver.navigate().to("http://amazon.com");

        if(driver.getTitle().toLowerCase().contains("amazon")){
            System.out.println("TEST PASSED!");
        } else {
            System.out.println("TEST FAILED!");
        }

        Thread.sleep(3000);
        driver.navigate().back();

        Thread.sleep(3000);
        driver.navigate().forward();
        Thread.sleep(3000);
        System.out.println("Title is : "+driver.getTitle());
        System.out.println("URL is : "+driver.getCurrentUrl());
        driver.navigate().refresh();
        Thread.sleep(3000);
        driver.close(); // to close browser
    }

    public static void verifyEquals(String arg1, String arg2){
        if(arg1.equalsIgnoreCase(arg2)){
            System.out.println("TEST PASSED!");
        } else {
            System.out.println("TEST FAILED!");
        }
    }

}
