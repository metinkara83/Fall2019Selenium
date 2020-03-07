package com.officeHours;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class OH03042020 {

    public static void main(String[] args){

        /*
        1. Go to http://automationpractice.com
        2. Search for 'tshirt' in a searchbox + click enter OR click search button
        3. validate you got 'no results' message on UI
        4. Search for 't-shirt'
        5. Validate there was 1 result found
         */

        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get("http://automationpractice.com");
        WebElement search_box = driver.findElement(By.id("search_query_top"));
        search_box.sendKeys("tshirt"+ Keys.ENTER);

        try{
            Thread.sleep(3000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        WebElement error = driver.findElement(By.className("alert"));
        String errorText = error.getText();
        // .getText() -> returns String (text) from the element
        System.out.println("Error message: "+errorText);
        // NoSuchElementException - it means we could not locate the element

        search_box = driver.findElement(By.id("search_query_top"));
        search_box.clear();
        // .clear() -
        search_box.sendKeys("t-shirt"+Keys.ENTER);
        // StaleElementReferenceException - element is old/stale
        // we want to find this element again OR refresh page

        try{
            Thread.sleep(5000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        WebElement count = driver.findElement(By.className("product-count"));
        System.out.println("items found: "+count.getText());

        driver.quit();
    }
}
