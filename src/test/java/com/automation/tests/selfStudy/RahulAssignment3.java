package com.automation.tests.selfStudy;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.DriverManager;

public class RahulAssignment3 {

    @Test
    public void test(){
        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.itgeared.com/demo/1506-ajax-loading.html");
        driver.findElement(By.linkText("Click to load get data via Ajax!")).click();
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#results")));
        String expected = "Process completed! This response has been loaded via the Ajax request directly from the web server, without reoading this page.";
        String actual = driver.findElement(By.cssSelector("div#results")).getText();
        Assert.assertEquals(actual,expected);
        driver.quit();
    }
}
