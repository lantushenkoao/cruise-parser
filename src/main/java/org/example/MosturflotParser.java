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
    public static void parseMosturflotCruises(String shipName, List<String> urls) throws Exception{
        FileWriter textFile = new FileWriter("./result.txt");
        try {
            WebDriver driver;
            ChromeOptions options = new ChromeOptions();
            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
            driver.manage().window().maximize();

            SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm");
            for (String url : urls) {
                driver.get(url);
                System.out.println("Сайт открылся");

                clickCookiesBtn(driver);

                //нажатие кнопки загрузить еще
                clickMoreButtonWhileVisible(driver);

                //выбираем все круизы на странице
                List<WebElement> elements = driver.findElements(By.className("result__list-item"));

                for (WebElement trip : elements) {
                    WebElement date = trip.findElement(By.className("result__list-item-date"));
                    String dateStr = date.getText();
                    Dates dates = parseMosturflotDate(dateStr);
                    WebElement stops = trip.findElement(By.className("card__list"));
                    String stopsStr = parseMosturflotStops(stops);
                    String link = trip.findElement(By.tagName("a")).getAttribute("href");

                    textFile.write(shipName + "\t" + format.format(dates.startDate)
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
        String xpath = "//*[contains(text(),'Загрузить еще')]";
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
        //мы получим строку вида 02 мая 12:30 (пятница) - 04 мая 22:00 (воскресенье) 2025
        //3 дня
        /// 2 ночи
        String dateStr = date;
        //удаляем все что идет после 2025
        dateStr = dateStr.substring(0, dateStr.indexOf("2025")-1);
        //удаляем дни недели
        dateStr = dateStr.replace("(понедельник)", "")
                .replace("(вторник)", "")
                .replace("(среда)", "")
                .replace("(четверг)", "")
                .replace("(пятница)", "")
                .replace("(суббота)", "")
                .replace("(воскресенье)", "");

        //разбиваем на дату начала и конца
        String startDate = dateStr.split("-")[0].trim();
        String endDate = dateStr.split("-")[1].trim();

        //добавляем к датам год
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
