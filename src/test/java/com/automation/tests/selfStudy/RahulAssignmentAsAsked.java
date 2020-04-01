package com.automation.tests.selfStudy;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RahulAssignmentAsAsked {
    private WebDriver driver;
    private By departOnBy = By.id("DepartDate");
    private By departDaySelect = By.xpath("(//tbody/tr/td/a[text()='22'])[1]");
    private By adults = By.id("Adults");
    private By children = By.id("Childrens");
    private By infants = By.id("Infants");
    private By moreOptions = By.id("MoreOptionsDiv");
    private By classSelect = By.id("Class");
    private By airline = By.name("airline");
    private By searchButton = By.xpath("//input[@id='SearchBtn']");
    private By alertMessage = By.id("homeErrorMessage");

    @Test
    public void Test2(){
        driver.findElement(departOnBy).click();
        BrowserUtils.wait(2);
        driver.findElement(departDaySelect).click();
        BrowserUtils.wait(2);
        Select adultSelection = new Select(driver.findElement(adults));
        adultSelection.selectByValue("2");
        BrowserUtils.wait(2);
        Select childSelection = new Select(driver.findElement(children));
        childSelection.selectByValue("1");
        BrowserUtils.wait(2);
        Select infantSelection = new Select(driver.findElement(infants));
        infantSelection.selectByValue("1");
        BrowserUtils.wait(2);
        driver.findElement(moreOptions).click();
        BrowserUtils.wait(2);
        Select classSelection = new Select(driver.findElement(classSelect));
        classSelection.selectByVisibleText("First");
        BrowserUtils.wait(2);
        driver.findElement(airline).sendKeys("Turkish Airlines(TK)");
        BrowserUtils.wait(2);
        driver.findElement(searchButton).click();
        BrowserUtils.wait(2);
        String actual = driver.findElement(alertMessage).getText();
        BrowserUtils.wait(2);
        String expected = "Sorry, but we can't continue until you fix everything that's marked in RED";
        Assert.assertEquals(actual,expected);
        BrowserUtils.wait(2);
    }

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        driver = DriverFactory.createDriver("chrome");
        driver.get("http://cleartrip.com");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown(){
        if (driver!=null){
            driver.quit();
            driver=null;
        }
    }

}
