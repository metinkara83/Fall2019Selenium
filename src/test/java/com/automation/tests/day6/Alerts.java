package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.*;

import java.util.List;

public class Alerts {

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        BrowserUtils.wait(3);

        List<WebElement> buttons = driver.findElements(By.tagName("button"));

        buttons.get(0).click();
        BrowserUtils.wait(3);

        String popupText = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept(); // to click OK
        String expected = "You successfully clicked an alert";
        String actual = driver.findElement(By.id("result")).getText();

        if (expected.equals(actual)){
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
            System.out.println("Expected :: "+expected);
            System.out.println("Actual :: "+actual);
        }

        BrowserUtils.wait(3);

        buttons.get(1).click(); // to click on the 2nd button
        BrowserUtils.wait(3);
        // to click cancel
        driver.switchTo().alert().dismiss();
        String expected2 = "You clicked: Ok";
        String actual2 = driver.findElement(By.id("result")).getText();
        if (expected2.equals(actual2)){
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
            System.out.println("Expected :: "+expected2);
            System.out.println("Actual :: "+actual2);
        }

        buttons.get(2).click(); // to click on the 2nd button
        BrowserUtils.wait(3);
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Sahip Hosgeldin, Hello, World!");
        alert.accept();
        String expected3 = "Sahip Hosgeldin, Hello, World!";
        String actual3 = driver.findElement(By.id("result")).getText();
        if (actual3.endsWith("Hello, World!")){
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
            System.out.println("Expected :: "+expected3);
            System.out.println("Actual :: "+actual3);
        }

        BrowserUtils.wait(3);
        driver.quit();
    }
}
