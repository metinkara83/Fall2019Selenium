package com.automation.tests.day7;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IQLexisNexis {

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://google.com");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("LexisNexis", Keys.ENTER);
        BrowserUtils.wait(4);
        WebElement thirdOne = driver.findElement(By.xpath("//div[@id='search']/div/div/div[5]//a"));
        BrowserUtils.wait(4);
        thirdOne.click();
        BrowserUtils.wait(4);
        String title = driver.getTitle();
        System.out.println(title);
        BrowserUtils.wait(4);
        driver.quit();
    }
}
