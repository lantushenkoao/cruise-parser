package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class SeleniumUtils {
    public static boolean isElementVisible(WebDriver driver, By by) {
        try{
            driver.findElement(by);
            return true;
        }catch (NoSuchElementException e){
            return false;
        }
    }

    public static void clickButtonIfVisible(WebDriver driver, By by) {
        if(isElementVisible(driver, by)){
            driver.findElement(by).click();
        }
    }

}
