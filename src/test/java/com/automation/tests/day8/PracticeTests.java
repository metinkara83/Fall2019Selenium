package com.automation.tests.day8;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;

public class PracticeTests {

    private WebDriver driver;

    @Test
    public void loginTest() {
        BrowserUtils.wait(3);
        List<WebElement> tests = driver.findElements(By.xpath("//div[@id='content']//a"));
        tests.get(20).click();
        BrowserUtils.wait(3);
        driver.findElement(By.name("username")).sendKeys("tomsmith");
        BrowserUtils.wait(2);
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");
        BrowserUtils.wait(2);
        driver.findElement(By.id("wooden_spoon")).click();
        BrowserUtils.wait(2);
        String expected = "Welcome to the Secure Area. When you are done click logout below.";
        String actual = driver.findElement(By.tagName("h4")).getText();

        // if assertion fails - it will throw exception and message will be printed
        Assert.assertEquals(expected,actual,"Sub-header message is not matching");
    }

    @Test
    public void forgotPasswordTest(){
        BrowserUtils.wait(3);
        List<WebElement> tests = driver.findElements(By.xpath("//div[@id='content']//a"));
        tests.get(19).click();
        BrowserUtils.wait(3);
        driver.findElement(By.name("email")).sendKeys("abc123@gmail.com");
        BrowserUtils.wait(2);
        driver.findElement(By.id("form_submit")).click();
        BrowserUtils.wait(2);
        String expected = "Your e-mail's been sent!";
        String actual = driver.findElement(By.name("confirmation_message")).getText();
        BrowserUtils.wait(2);
        Assert.assertEquals(expected,actual,"Confirmation message is not matching");
    }

    @Test
    public void checkBoxTest(){
        BrowserUtils.wait(3);
        List<WebElement> tests = driver.findElements(By.xpath("//div[@id='content']//a"));
        tests.get(6).click();
        driver.findElement(By.xpath("//form/input[1]")).click();
        BrowserUtils.wait(3);
        Assert.assertTrue(driver.findElement(By.xpath("//form/input[1]")).isSelected());
    }

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        // Interview Question : How to handle SSL issues in Selenium?
        // ChromeOptions - used to customize browser for tests
        ChromeOptions chromeOptions = new ChromeOptions();
        // to ignore "Your connection is not private" issue
        chromeOptions.setAcceptInsecureCerts(true);
        driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
