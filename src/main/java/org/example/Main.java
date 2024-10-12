package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.io.FileWriter;
import java.util.Locale;

import static org.example.MosturflotParser.parseMosturflotCruises;
import static org.example.SeleniumUtils.clickButtonIfVisible;
import static org.example.SeleniumUtils.isElementVisible;
import static org.example.VolgaVolgaParser.parseVolgaVolgaCruises;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception {
//        List<String> urls = Arrays.asList(
//                "https://www.mosturflot.ru/river-cruises/?ship_id=14&date_from=01.01.2025");
//        parseMosturflotCruises("Леонид КРАСИН", urls);

        List<String> urls = Arrays.asList(
                "https://volgawolga.ru/mayakovskiy/");
        //использовать это для конвертации русского текста https://r12a.github.io/app-conversion/
        String shipName = "Владимир Маяковский";

        parseVolgaVolgaCruises(shipName, urls);

    }
}
