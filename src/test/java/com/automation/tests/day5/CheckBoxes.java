package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CheckBoxes {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/checkboxes");
        BrowserUtils.wait(2);

        List<WebElement> checkBoxes = driver.findElements(By.tagName("input"));
//        checkBoxes.get(0).click(); // click on first checkbox

        BrowserUtils.wait(2);

        // go over collection of checkboxes

        for (int i = 0 ; i < checkBoxes.size() ; i++){
            //          if visible,                     eligible to click       and         not clicked yet
            if(checkBoxes.get(i).isDisplayed() && checkBoxes.get(i).isEnabled() && !checkBoxes.get(i).isSelected()){
                // if checkbox is not selected, click
                checkBoxes.get(i).click(); // click on second checkbox
                System.out.println("Checkbox "+(i+1) +" is clicked");
            }
            else {
                System.out.println("Checkbox "+(i+1) +" is NOT clicked");
            }
        }


        BrowserUtils.wait(2);
        driver.quit();
    }
}
