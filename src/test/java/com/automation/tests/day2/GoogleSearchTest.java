package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchTest {

    public static void main(String[] args) throws Exception{

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://google.com");
        Thread.sleep(2000);
        // By.name("q") --> name="q"
        // name - it's one of the selenium locators
        // there are 8 locators
        // we use locators to find elements
        // to choose locator, just use
        WebElement search = driver.findElement(By.name("q"));
        // once we found an element, how to enter text?
        // to enter text, use sendKeys() method
        // how to press Enter after entering the text?
        // use Key.ENTER - perform keyboard click
        search.sendKeys("Java", Keys.ENTER);
        Thread.sleep(4000);
        WebElement news = driver.findElement(By.linkText("News"));
        news.click();
        Thread.sleep(4000);
        driver.quit();

    }
}
