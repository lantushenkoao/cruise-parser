package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.example.ParserUtils.clickButtonIfVisible;

public class Parser_Vodohod {
    public void Course(String url, String fileName) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--blink-settings=imagesEnabled=false"); // Disable image loading


        WebDriver webDriver = new ChromeDriver(options);
        Format format = new Format();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName,true))) {
            webDriver.get(url);
            System.out.println("Parsing " + url + " into file: " + fileName);
            List<WebElement> elemets = webDriver.findElements(By.cssSelector(".p-content__inner__wrapper a"));
            for(WebElement elemet : elemets){
                ArrayList<String> city = new ArrayList<>();
                ArrayList<String> timeIn = new ArrayList<>();
                ArrayList<String> timeOut = new ArrayList<>();
                ArrayList<String> timeDay = new ArrayList<>();

                String strhref  = elemet.getAttribute("href");
                ((JavascriptExecutor) webDriver).executeScript("window.open('" + strhref + "', '_blank');");
                String originalTab = webDriver.getWindowHandle();
                Set<String> allTabs = webDriver.getWindowHandles();
                for (String tab : allTabs) {
                    if (!tab.equals(originalTab)) {
                        webDriver.switchTo().window(tab);
                        break;
                    }
                }
                WebElement expandWholeTripButton;
                //иногда показыватся кнопка Показать подробности
                clickButtonIfVisible(webDriver, By.className("popmechanic-close"));
                try {
                    expandWholeTripButton = ParserUtils.waitForElementVisible(webDriver, By.className("b-rc__view-all-btn"));
                }catch (Exception e){
                    System.out.println("Элемент Expand b-rc__view-all-btn не найден для маршрута " + strhref);
                    throw e;
                }
                ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView({block: 'center', behavior: 'smooth'});", expandWholeTripButton);
                ((JavascriptExecutor)webDriver).executeScript("arguments[0].click();", expandWholeTripButton);

                while(!ParserUtils.isElementVisible(webDriver, By.cssSelector(".b-rc__view-all-btn.b-rc__view-all-btn--hide"))){
                    //кнопка Показать весь круиз иногда не срабатывает. Пока не появилась кнопка Скрыть все, продолжаем попытки её нажать
                    System.out.println("waiting for collapse button");
                    ((JavascriptExecutor)webDriver).executeScript("arguments[0].click();", expandWholeTripButton);
                }

                WebElement teplohod = webDriver.findElement(By.cssSelector(".booking__left-item.booking__left-ship"));
                WebElement pteplohod = teplohod.findElement(By.cssSelector(".booking__i-value"));
                String nameTeplohod = pteplohod.getText();

                List<WebElement> days = webDriver.findElements(By.cssSelector(".b-spoiler__content"));
                for (WebElement day : days){
                    List<WebElement> bdays = day.findElements(By.cssSelector(".b-day"));
                    int condition = 0;
                    for(WebElement bday : bdays){
                        timeIn.add("00:00");
                        timeOut.add("00:00");
                        WebElement acity = bday.findElement(By.cssSelector(".body-content__text-title-main.link"));
                        city.add(acity.getText());
                        List<WebElement> dates = bday.findElements(By.cssSelector(".b-day__grid-item"));

                        for(WebElement date : dates){
                            String temp1 = date.getText();
                            System.out.println(temp1);

                            String[] parts = temp1.split("\n");
                            String temp2 = parts[0];
                            String temp3 = parts.length > 1 ? parts[1] : "00:00";

                            if (temp2.length() == 5) {
                                temp3 = temp3.split(" ")[0];
                                timeDay.add(temp3);
                                System.out.print(" Date: " + timeDay.get(condition));
                            }
                            if (temp2.length() == 9) {
                                timeIn.removeLast();
                                timeIn.addLast(temp3);
                                System.out.print(" Arrival time: " + timeIn.get(condition));
                            }
                            if (temp2.length() == 12) {

                                timeOut.removeLast();
                                timeOut.addLast(temp3);
                                System.out.print(" Departure time: " + timeOut.get(condition));
                            }
                            System.out.println();
                        }
                        condition++;
                    }
                }
//                Thread.sleep(3000);
                format.FormatVodohodStopFromTXT(nameTeplohod, strhref, timeDay, city, timeIn, timeOut, writer);
                webDriver.close();
                webDriver.switchTo().window(originalTab);
            }
        } catch (Throwable e) {
            System.err.println("Failed with error " + e.getMessage() + "; file name " + fileName + "; url " + url);
            e.printStackTrace();
        } finally {
            webDriver.manage().deleteAllCookies();
            webDriver.quit();
        }
    }
}
