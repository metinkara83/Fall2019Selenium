package com.automation.tests.selfStudy;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class RahulAssignment8 {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();
        WebElement suggestionBox = driver.findElement(By.id("autocomplete"));
        suggestionBox.sendKeys("uni");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        String script = "return document.getElementById('autocomplete').value;";
        String text = (String) js.executeScript(script);
        while (!text.equalsIgnoreCase("United States (USA)")){
            suggestionBox.sendKeys(Keys.ARROW_DOWN);
            text = (String) js.executeScript(script);
            BrowserUtils.wait(1);
        }
        System.out.println(text);
        driver.quit();
    }
}
