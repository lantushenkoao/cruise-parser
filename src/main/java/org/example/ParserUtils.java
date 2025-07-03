package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.Writer;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

public class ParserUtils {

    public static WebElement waitForElementVisible(WebDriver driver, By by){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // 10-second timeout
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static boolean isElementVisible(WebDriver driver, By by) {
        try{
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3)); // 10-second timeout
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));

            return true;
        }catch (NoSuchElementException e){
            return false;
        }
    }

    public static void clickButtonIfVisible(WebDriver driver, By by) {
        try {
            if(isElementVisible(driver, by)){
                driver.findElement(by).click();
            }
        }catch (Exception e) {
            System.out.println("Cannot click button " + e.getMessage());
        }
    }
}
