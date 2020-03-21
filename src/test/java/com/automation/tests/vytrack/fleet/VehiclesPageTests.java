package com.automation.tests.vytrack.fleet;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.*;

import static org.testng.Assert.*;
import java.util.List;

public class VehiclesPageTests {
    private WebDriver driver;
    private String URL = "https://qa2.vytrack.com/user/login";
    private By usernameBy = By.id("prependedInput");
    private By passwordBy = By.id("prependedInput2");
    private String username = "storemanager77";
    private String password = "UserUser123";
    private By fleetBy = By.xpath("//span[@class='title title-level-1' and contains(text(),'Fleet')]");
    private By subtitleBy = By.className("oro-subtitle");
    private By pageNumberBy = By.xpath("//input[@type='number']");

    @Test
    public void verifyPageSubTitle() {
        WebElement subTitleElement = driver.findElement(subtitleBy);
        System.out.println(subTitleElement.getText());
        String expected = "All Cars";
        String actual = subTitleElement.getText();
        assertEquals(actual,expected);
    }

    @Test
    public void verifyPageNumber(){
        String expected = "1";
        String actual = driver.findElement(pageNumberBy).getAttribute("value");
        System.out.println(actual);
        assertEquals(actual,expected);
    }

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();

        driver.findElement(usernameBy).sendKeys(username);
        driver.findElement(passwordBy).sendKeys(password, Keys.ENTER);
        BrowserUtils.wait(5);
//        driver.findElement(fleetBy).click();
        // Actions class is used for more advanced browser interactions
        Actions actions = new Actions(driver);
        // move to element instead of click
        actions.moveToElement(driver.findElement(fleetBy)).perform();
        // perform - to execute command
        BrowserUtils.wait(2);
        driver.findElement(By.linkText("Vehicles")).click();
        BrowserUtils.wait(5);
    }

    @AfterMethod
    public void tearDown(){
        // if webdriver object is alive
        if (driver!=null){
            // close browser, close session
            driver.quit();
            // destroy driver object for sure
            driver=null;
        }
    }
}
