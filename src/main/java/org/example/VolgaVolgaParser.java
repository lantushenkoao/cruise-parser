package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VolgaVolgaParser {

    public static void parseVolgaVolgaCruises(String shipName, List<String> urls) throws Exception {

        WebDriver driver;
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().window().maximize();
        List<VolgaVolgaData> data = new ArrayList<>();
        try {

            for (String url : urls) {
                driver.get(url);
                System.out.println("Website opened");
                driver.findElement(By.xpath("//*[@href='#t_5']")).click();
                List<WebElement> rows = driver.findElements(By.className("product-row"));
                for (WebElement row : rows) {

                    String stops = row.findElement(By.className("kruiz-ways")).getText()
                            .replace("\u2013", "_")
                            .replace(" _ ", "_")
                            .replace(" - ", "_")
                            .replace(" + ", "_");
                    String link = row.findElement(By.xpath("./*[@id='th-info']/a")).getAttribute("href");
                    VolgaVolgaData dataRow = new VolgaVolgaData();
                    dataRow.shipName = shipName;
                    dataRow.link = link;
                    dataRow.stops = stops;
                    data.add(dataRow);
                }
            }
            loadCruiseData(data, driver);
            writeToFile(data);
        }finally {

            driver.close();
        }
    }

    private static void loadCruiseData(List<VolgaVolgaData> rows, WebDriver driver) throws Exception {
        for (VolgaVolgaData row: rows){
            driver.get(row.link);
            try {
                String startDate = driver.findElement(By.xpath("//*[contains(text(), 'Отправление теплохода:')]/..")).getText();
                startDate = startDate.replace("Отправление теплохода:", "").trim();
                row.startDate = parseDate(startDate);

                String endDate = driver.findElement(By.xpath("//*[contains(text(), 'Прибытие теплохода:')]/..")).getText();
                endDate = endDate.replace("Прибытие теплохода:", "").trim();
                row.endDate = parseDate(endDate);

                System.out.println(startDate + " - " + endDate);
                List<WebElement> cities = driver.findElements(By.xpath("//*[contains(@class,\"active\")]//table[1]//td[4]"));
//          //*[contains(@class,"active")]//table[1]//td[4]
                String citiesFin = "";
                for (WebElement city : cities) {
                    citiesFin += city.getText() + "_";
                }
                row.cities = citiesFin.substring(0, citiesFin.length() - 1);
            }catch (Exception e) {
                System.out.println("Failed to load trip: " + row.link);
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static void writeToFile(List<VolgaVolgaData> data) throws Exception {
        Writer textFile = new OutputStreamWriter(new FileOutputStream("./result.txt"), StandardCharsets.UTF_8);
        try{
            SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm");

            for(VolgaVolgaData row: data) {
                textFile.write(row.shipName + "\t" + (null == row.startDate ? "пусто" : format.format(row.startDate))
                        + "\t" + (null == row.endDate ? "пусто" : format.format(row.endDate))
                        + "\t" + row.cities
                        + "\t" + row.link
                        + "\n");
            }
        }finally {
            textFile.close();
        }
    }

    private static class VolgaVolgaData {
        public String shipName;
        public String stops;
        public String link;
        public Date startDate;
        public Date endDate;
        public String cities;
    }
    private static Date parseDate(String date) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        String dateTrimmed = date.substring(0, date.indexOf("г.") - 1);
        return format.parse(dateTrimmed);
    }
}
