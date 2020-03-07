package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RegistrationForm {

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/registration_form");
        BrowserUtils.wait(5);
        // enter first name
        driver.findElement(By.name("firstname")).sendKeys("Metin");
        driver.findElement(By.name("lastname")).sendKeys("Kara");
        driver.findElement(By.name("username")).sendKeys("metinkara");
        driver.findElement(By.name("email")).sendKeys("metinkara@gmail.com");
        driver.findElement(By.name("password")).sendKeys("123456789");
        driver.findElement(By.name("phone")).sendKeys("404-638-2648");

        List<WebElement> genders = driver.findElements(By.name("gender"));
        genders.get(0).click();

        driver.findElement(By.name("birthday")).sendKeys("01/01/2000");


        driver.findElement(By.id("inlineCheckbox2")).click();

        BrowserUtils.wait(2);
        driver.findElement(By.id("wooden_spoon")).click();
        BrowserUtils.wait(2);




        driver.quit();
    }
}
