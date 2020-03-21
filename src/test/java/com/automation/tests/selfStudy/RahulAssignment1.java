package com.automation.tests.selfStudy;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class RahulAssignment1 {
    private static WebDriver driver;

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        WebElement checkBox1 = driver.findElement(By.id("checkBoxOption1"));
        checkBox1.click();
        BrowserUtils.wait(3);
        if(checkBox1.isSelected()){
            System.out.println("Test-1 Passed");
        } else {
            System.out.println("Test-1 Failed");
        }
        checkBox1.click();
        BrowserUtils.wait(3);
        if(!checkBox1.isSelected()){
            System.out.println("Test-2 Passed");
        } else {
            System.out.println("Test-2 Failed");
        }
        numberOfCheckboxes();
        driver.quit();
    }
    public static void numberOfCheckboxes(){
        List<WebElement> checkBoxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
        System.out.println(checkBoxes.size());
        BrowserUtils.wait(3);
    }
}
