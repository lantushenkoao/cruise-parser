package org.example;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import static org.example.ParserUtils.clickButtonIfVisible;
import static org.example.ParserUtils.isElementVisible;

public class MosturflotParser {
    public static void parseMosturflotCruises(List<ParserUtils.ShipUrl> urls) throws Exception{
        FileWriter textFile = new FileWriter("./result.txt");
        try {
            WebDriver driver;
            ChromeOptions options = new ChromeOptions();
            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
            driver.manage().window().maximize();

            SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm");
            for (ParserUtils.ShipUrl ship : urls) {
                driver.get(ship.url);
                System.out.println("Parsing " + ship.name);

                clickCookiesBtn(driver);

                //??????? ?????? ????????? ???
                clickMoreButtonWhileVisible(driver);

                //???????? ??? ?????? ?? ????????
                List<WebElement> elements = driver.findElements(By.className("result__list-item"));

                for (WebElement trip : elements) {
                    WebElement date = trip.findElement(By.className("result__list-item-date"));
                    String dateStr = date.getText();
                    Dates dates = parseMosturflotDate(dateStr);
                    WebElement stops = trip.findElement(By.className("card__list"));
                    String stopsStr = parseMosturflotStops(stops);
                    String link = trip.findElement(By.tagName("a")).getAttribute("href");

                    textFile.write(ship.name + "\t" + format.format(dates.startDate)
                            + "\t" + format.format(dates.endDate)
                            + "\t" + stopsStr
                            + "\t" + link
                            + "\n");
                }
                System.out.println("Found " + elements.size() + " trips");
            }
        }finally {
            textFile.close();
        }
    }


    private static void clickCookiesBtn(WebDriver driver) {
        clickButtonIfVisible(driver, By.id("btn_cookiesID"));
    }

    private static void clickMoreButtonWhileVisible(WebDriver driver) throws InterruptedException {
        String xpath = "//*[contains(text(),'\u0417\u0430\u0433\u0440\u0443\u0437\u0438\u0442\u044C\u0020\u0435\u0449\u0435')]";
        while (isElementVisible(driver, By.xpath(xpath))) {
            driver.findElement(By.xpath(xpath)).click();
            Thread.sleep(2000);
        }
    }

    private static String parseMosturflotStops(WebElement elem) {
        String result = "";
        for(WebElement li: elem.findElements(By.tagName("li"))){
            result += li.getText() + "_";
        }
        return result.substring(0, result.length()-1);
    }

    private static Dates parseMosturflotDate(String date) throws ParseException {
        //?? ??????? ?????? ???? 02 ??? 12:30 (???????) - 04 ??? 22:00 (???????????) 2025
        //3 ???
        /// 2 ????
        String dateStr = date;
        //??????? ??? ??? ???? ????? 2025
        dateStr = dateStr.substring(0, dateStr.indexOf("2025")-1);
        //??????? ??? ??????
        dateStr = dateStr.replace("\u0028\u043F\u043E\u043D\u0435\u0434\u0435\u043B\u044C\u043D\u0438\u043A\u0029", "")
                .replace("\u0028\u0432\u0442\u043E\u0440\u043D\u0438\u043A\u0029", "")
                .replace("\u0028\u0441\u0440\u0435\u0434\u0430\u0029", "")
                .replace("\u0028\u0447\u0435\u0442\u0432\u0435\u0440\u0433\u0029", "")
                .replace("\u0028\u043F\u044F\u0442\u043D\u0438\u0446\u0430\u0029", "")
                .replace("\u0028\u0441\u0443\u0431\u0431\u043E\u0442\u0430\u0029", "")
                .replace("\u0028\u0432\u043E\u0441\u043A\u0440\u0435\u0441\u0435\u043D\u044C\u0435\u0029", "");

        //????????? ?? ???? ?????? ? ?????
        String startDate = dateStr.split("-")[0].trim();
        String endDate = dateStr.split("-")[1].trim();

        //????????? ? ????? ???
        startDate = startDate.substring(0, startDate.length()-5) + " 2025 " + startDate.substring(startDate.length()-5);
        endDate = endDate.substring(0, endDate.length()-5) + " 2025 " + endDate.substring(endDate.length()-5);
        SimpleDateFormat parser = new SimpleDateFormat("dd MMMM yyyy HH:mm",  new Locale("ru"));
        Dates result = new Dates();
        result.startDate = parser.parse(startDate);
        result.endDate = parser.parse(endDate);
        return result;
    }
    static class Dates {
        public Date startDate;
        public Date endDate;
    }
}
