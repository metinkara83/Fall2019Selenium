package com.automation.tests.day4;

import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class VerifyThatElementIsGone {
    static WebDriver driver;
    /**
     * interview question:
     * how to check if element doesn't exist anymore
     */
    public static void main(String[] args) throws Exception {

        driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        Thread.sleep(2000);

        driver.findElement(By.id("disappearing_button")).click();
        Thread.sleep(2000);

        if(driver.findElements(By.id("disappearing_button")).size()==0){
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }

        Thread.sleep(2000);

        List<WebElement> buttons = driver.findElements(By.tagName("button"));

        for(WebElement button : buttons){
            button.click();
            Thread.sleep(2000);
        }

        driver.quit();
    }
}
