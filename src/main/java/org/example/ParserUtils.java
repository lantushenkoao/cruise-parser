package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

public class ParserUtils {

    public static void writeToFile(List<TripData> data, Writer textFile) throws Exception {
        System.out.println("Writting data to file");

        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm");

        for(ParserUtils.TripData row: data) {
            textFile.write(row.shipName + "\t" + (null == row.startDate ? "пусто" : format.format(row.startDate))
                    + "\t" + (null == row.endDate ? "пусто" : format.format(row.endDate))
                    + "\t" + row.cities
                    + "\t" + row.link
                    + "\n");
        }
    }
    public static boolean isElementVisible(WebDriver driver, By by) {
        try{
            driver.findElement(by);
            return true;
        }catch (NoSuchElementException e){
            return false;
        }
    }

    public static WebDriver openBrowser(){
        WebDriver driver;
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().window().maximize();
        return driver;
    }

    public static void clickButtonIfVisible(WebDriver driver, By by) {
        if(isElementVisible(driver, by)){
            driver.findElement(by).click();
        }
    }

    public static class TripData {
        public String shipName;
        public String stops;
        public String link;
        public Date startDate;
        public Date endDate;
        public String cities;
    }

}
