package com.automation.tests.selfStudy;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class RahulAssignment7 {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();
        List<WebElement> rows = driver.findElements(By.cssSelector("#product >tbody >tr"));
        int rowsSize = rows.size();
        System.out.println("There are "+rowsSize+" rows in the table.");
        List<WebElement> columns = driver.findElements(By.cssSelector("#product >tbody >tr >th"));
        int columnsSize = columns.size();
        System.out.println("There are "+columnsSize+" columns in the table.");
        WebElement secondRow = driver.findElement(By.cssSelector("#product tbody tr:nth-child(3)"));
        System.out.println(secondRow.getText());
        driver.quit();
    }
}
