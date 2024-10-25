package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import static org.example.ParserUtils.writeToFile;

public class VodohodParser {


    public static void parseVolgaVolgaCruises(List<ParserUtils.ShipUrl> urls) throws Exception {

        WebDriver driver;
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().window().maximize();

        Writer textFile = new OutputStreamWriter(new FileOutputStream("./result.txt"), StandardCharsets.UTF_8);
        try {
            for (ParserUtils.ShipUrl shipUrl : urls) {
                List<ParserUtils.TripData> data = new ArrayList<>();
                driver.get(shipUrl.url);
                System.out.println("Website opened");
                Thread.sleep(2000);
                ParserUtils.clickButtonIfVisible(driver, By.xpath("//*[@id='cookie-alert-close']/button"));
                boolean isLastPage = false;
                while (true) {

                    List<WebElement> cruises = driver.findElements(By.linkText("¬џЅ–ј“№"));

                    List<ParserUtils.TripData> links = cruises.stream().map(e -> {
                        ParserUtils.TripData r = new ParserUtils.TripData();
                        r.shipName = shipUrl.name;
                        r.link = e.getAttribute("href");
                        return r;
                    }).toList();
                    data.addAll(links);
                    WebElement nextBtn = getNextButton(driver);
                    if (isLastPage) {
                        break;
                    }
                    if (nextBtn == null) {
                        isLastPage = true;
                    } else {
                        nextBtn.click();
                    }
                }

                System.out.println("Found " + data.size() + " cruises");

                loadCruiseData(data, driver);
                writeToFile(data, textFile);
            }

        } finally {
            textFile.close();
            driver.close();
        }
    }

    private static WebElement getNextButton(WebDriver driver) {
        WebElement nextButton = driver.findElements(By.className("b-pagination__item--arrow")).get(1);
        if (nextButton.getAttribute("class").contains("disabled")) {
            return null;
        }
        return nextButton;
    }

    private static void loadCruiseData(List<ParserUtils.TripData> rows, WebDriver driver) throws Exception {
        for (ParserUtils.TripData row : rows) {
            driver.get(row.link);
            try {
                String dates = driver.findElement(By.className("booking__i-value--dates")).getText();
                List<WebElement> departures = driver.findElements(By.xpath("//*[contains(text(), 'ќтправление')]/parent::div/*[contains(@class,'b-day__grid-item-value')]"));
                String deptTime = !departures.isEmpty() ? departures.get(0).getAttribute("innerText") : "00:00";
                String startDate = dates.split("Ч")[0];
                row.startDate = parseDate(startDate + " " + deptTime);

                List<WebElement> arrivals = driver.findElements(By.xpath("//*[contains(text(), 'ѕрибытие')]/parent::div/*[contains(@class,'b-day__grid-item-value')]"));
                String endDate = dates.split("Ч")[1];
                String arrivalDate = !arrivals.isEmpty() ? arrivals.get(arrivals.size() - 1).getAttribute("innerText") : "00:00";
                row.endDate = parseDate(endDate + " " + arrivalDate);

                System.out.println(startDate + " - " + endDate);
                List<WebElement> citiesElems = driver.findElement(By.className("booking__i-value--route")).findElements(By.tagName("span"));

                row.cities = citiesElems.stream().map(WebElement::getText).collect(Collectors.joining("_"));
            } catch (Exception e) {
                System.out.println("Failed to load trip: " + row.link);
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static Date parseDate(String date) throws ParseException {
        String dateStr = date.toLowerCase().replace("(пн)", "")
                .replace("(вт)", "")
                .replace("(ср)", "")
                .replace("(чт)", "")
                .replace("(пт)", "")
                .replace("(сб)", "")
                .replace("(вс)", "").trim();

        SimpleDateFormat format = new SimpleDateFormat("dd MMMM yyyy HH:mm", new Locale("ru"));
        return format.parse(dateStr);
    }
}
