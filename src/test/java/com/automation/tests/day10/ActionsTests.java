package com.automation.tests.day10;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionsTests {
    private WebDriver driver;
    private Actions actions;

    @Test
    public void hoverOnImage(){
        driver.get("http://practice.cybertekschool.com/hovers");
        BrowserUtils.wait(3);
        WebElement img1 = driver.findElement(By.xpath("(//img)[1]"));
        WebElement img2 = driver.findElement(By.xpath("(//img)[2]"));
        WebElement img3 = driver.findElement(By.xpath("(//img)[3]"));
        // build() is needed when you have couple of actions
        // always ends with perform()
        // pause(1000). - like Thread.sleep(1000)
        actions.moveToElement(img1).pause(1000).moveToElement(img2).pause(1000).moveToElement(img3).build().perform();
        // hover on the first image
        // verify that "name: user1" is displayed
        // hover over image to make text visible
        actions.moveToElement(img1).perform();
        WebElement imgText1 = driver.findElement(By.xpath("//h5[text()='name: user1']"));
        // verify that webelement containing the text is visible
        Assert.assertTrue(imgText1.isDisplayed());

        // move to the second image
        actions.moveToElement(img2).perform();
        WebElement imgText2 = driver.findElement(By.xpath("//h5[text()='name: user2']"));
        Assert.assertTrue(imgText2.isDisplayed());
    }

    @Test
    public void jQueryMenuTest(){
        driver.get("http://practice.cybertekschool.com/jqueryui/menu#");
        WebElement enabledButton = driver.findElement(By.id("ui-id-3"));
        WebElement downloadsButton = driver.findElement(By.id("ui-id-4"));
        WebElement pdfButton = driver.findElement(By.id("ui-id-5"));
        actions.moveToElement(enabledButton).pause(1000).moveToElement(downloadsButton).
                pause(1000).click(pdfButton).build().perform();
    }

    @Test
    public void dragAndDropTest(){
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        driver.manage().window().maximize();
        BrowserUtils.wait(3);
        driver.findElement(By.xpath("//button[text()='Accept Cookies']")).click();
        BrowserUtils.wait(3);
        WebElement earth = driver.findElement(By.id("droptarget"));
        WebElement moon = driver.findElement(By.id("draggable"));
        actions.dragAndDrop(moon, earth).pause(1000).perform();
        String expected = "You did great!";
        String actual = earth.getText();
        Assert.assertEquals(actual,expected);
    }

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        actions = new Actions(driver);
    }

    @AfterMethod
    public void tearDown(){
        BrowserUtils.wait(3);
        driver.quit();
    }
}
