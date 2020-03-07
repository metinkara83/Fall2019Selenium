package com.automation.tests.warmup;

import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WarmUp0304 {

    static WebDriver driver;

    public static void main(String[] args) throws Exception {

        /**
         *         Go to ebay
         *         enter search term
         *         click on search button
         *         print number of results
         *
         *         go to amazon
         *         enter search term
         *         click on search button
         *         verify title contains search term
         *
         *         Go to wikipedia.org
         *         enter search term `selenium webdriver`
         *         click on search button
         *         click on search result `Selenium (software)`
         *         verify url ends with `Selenium_(software)`
         */

        ebayTest("Nintendo Switch");
        amazonTest("Nintendo Switch");
        wikipediaTest("selenium webdriver");
    }

    public static void ebayTest(String srch){
        WebDriverManager.chromedriver().version("79.0").setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get("http://ebay.com");
        WebElement searchBox = driver.findElement(By.name("_nkw"));
        searchBox.sendKeys(srch + Keys.ENTER);
        WebElement resultsNo = driver.findElement(By.tagName("h1"));
        System.out.println("Number of search results: "+resultsNo.getText().split(" ")[0]);
        driver.quit();
    }

    public static void amazonTest(String srch){
        driver = DriverFactory.createDriver("chrome");
        driver.get("http://amazon.com");
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys(srch+ Keys.ENTER);
        String title = driver.getTitle();
        if (title.contains(srch)){
            System.out.println("Test Passed, title contains the search term");
        } else {
            System.out.println("Test Failed, title does not contain the search term");
        }
        driver.quit();
    }

    public static void wikipediaTest(String srch) throws Exception{
        driver = DriverFactory.createDriver("chrome");
        driver.get("http://wikipedia.org");
        WebElement searchBox = driver.findElement(By.id("searchInput"));
        searchBox.sendKeys(srch+Keys.ENTER);

        driver.findElement(By.linkText("Selenium (software)")).click();
        Thread.sleep(3000);
        String verification = driver.getCurrentUrl();
        if (verification.endsWith("Selenium_(software)")){
            System.out.println("Test Passed, the URL ends with Selenium (software)");
        } else {
            System.out.println("Test Failed, the URL does not end with Selenium (software)");
        }
        driver.quit();
    }

}
