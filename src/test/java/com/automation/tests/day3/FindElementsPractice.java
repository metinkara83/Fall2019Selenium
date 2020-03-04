package com.automation.tests.day3;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FindElementsPractice {

    public static void main(String[] args) throws Exception{

        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/sign_up");
        WebElement nameInput = driver.findElement(By.name("full_name"));
        Thread.sleep(2000);
        nameInput.sendKeys("Metin Kara");
        Thread.sleep(3000);

        WebElement emailInput = driver.findElement((By.name("email")));
        Thread.sleep(2000);
        emailInput.sendKeys("metinkara@gmail.com");
        Thread.sleep(3000);

        WebElement signUpButton = driver.findElement(By.name("wooden_spoon"));
        Thread.sleep(2000);
        signUpButton.click();
        Thread.sleep(3000);

        String expected = "Thank you for signing up. Click the button below to return to the home page.";
        WebElement message = driver.findElement(By.className("subheader"));
        String actual = message.getText();

        if(expected.equals(actual)){
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }

        driver.quit();

    }
}
