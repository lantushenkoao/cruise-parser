package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.example.ParserUtils.writeToFile;

/**
 * Созвездие
 */
public class ConstellationParser {
    public static void parseCruises(List<ParserUtils.ShipUrl> ships) throws Exception{
        Writer textFile = new OutputStreamWriter(new FileOutputStream("./result.txt"), StandardCharsets.UTF_8);
        WebDriver driver = null;
        try{
            driver = ParserUtils.openBrowser();
            for(ParserUtils.ShipUrl ship : ships){
                driver.get(ship.url);
                List<WebElement> cruises = driver.findElements(By.xpath("//*[@data-cruise-year]"));
                List<ParserUtils.TripData> data = new ArrayList<ParserUtils.TripData>();
                for(WebElement cruise : cruises){
                    List<WebElement> dates = cruise.findElements(By.className("schedule-item__date"));
                    ParserUtils.TripData row = new ParserUtils.TripData();
                    row.shipName = ship.name;
                    String startDateStr = dates.get(0).getText();
                    row.startDate = parseDate(startDateStr);

                    String endDateStr = dates.get(1).getText();
                    row.endDate = parseDate(endDateStr);

                    WebElement link = cruise.findElement(By.className("text_rout_for_ship_cruises"));
                    row.cities = link.getText().replace(" - ", "_");
                    row.link = link.getAttribute("href");
                    data.add(row);
                    System.out.println("Start date: " + startDateStr + " End date: " + endDateStr);
                }
                writeToFile(data, textFile);
            }

        }finally {
            textFile.close();
            driver.close();
        }

    }

    public static Date parseDate(String date) throws ParseException {

        SimpleDateFormat format = new SimpleDateFormat("dd MM yyyy", new Locale("ru"));
        String dateFormatted = date
                .replace("янв", "01")
                .replace("фев", "02")
                .replace("мар", "03")
                .replace("апр", "04")
                .replace("мая", "05")
                .replace("июн", "06")
                .replace("июл", "07")
                .replace("авг", "08")
                .replace("сен", "09")
                .replace("окт", "10")
                .replace("ноя", "11")
                .replace("дек", "12");
        return format.parse(dateFormatted);
    }


}
