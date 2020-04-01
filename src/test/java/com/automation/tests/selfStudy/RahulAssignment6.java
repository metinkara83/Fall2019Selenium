package com.automation.tests.selfStudy;

import com.automation.tests.day6.Alerts;
import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class RahulAssignment6 {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://qaclickacademy.com/practice.php");
        driver.manage().window().maximize();
        WebElement checkedBox = driver.findElement(By.xpath("//div[@id='checkbox-example']//label[3]/input"));
        checkedBox.click();
        String selectedOption = driver.findElement(By.xpath("//div[@id='checkbox-example']//label[3]")).getText().trim();
        Select dropDown = new Select(driver.findElement(By.id("dropdown-class-example")));
        dropDown.selectByVisibleText(selectedOption);
        driver.findElement(By.id("name")).sendKeys(selectedOption);
        driver.findElement(By.id("alertbtn")).click();
        Alert a = driver.switchTo().alert();
        String alertMessage = a.getText();
        if(alertMessage.contains(selectedOption)){
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }
        a.accept();
        driver.quit();
    }
}
