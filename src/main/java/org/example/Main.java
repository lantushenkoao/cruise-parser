package org.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setProperty("webdriver.chrome.driver", "geckodriver-v0.35.0-win64\\geckodriver.exe");
//        vodohod();
//        doninturflot();
//        gamma();
    }
    static public void gamma(){
        Parser_gama parserGama = new Parser_gama();
        String[] urlsGama = {
                "https://gama-nn.ru/booking/tours/pts149pcc84593689/",
                "https://gama-nn.ru/booking/tours/pts148pcc29542278/",
                "https://gama-nn.ru/booking/tours/pts14pcc13714655/",
                "https://gama-nn.ru/booking/tours/pts13pcc38234936/",
                "https://gama-nn.ru/booking/tours/pts8pcc36673453/",
                "https://gama-nn.ru/booking/tours/pts5pcc52784997/",
                "https://gama-nn.ru/booking/tours/pts95pcc25571565/",
                "https://gama-nn.ru/booking/tours/pts84pcc82125868/",
                "https://gama-nn.ru/booking/tours/pts1pcc17213891/",
                "https://gama-nn.ru/booking/tours/pts42pcc54817396/",
                "https://gama-nn.ru/booking/tours/pts2pcc55564253/",
                "https://gama-nn.ru/booking/tours/pts50pcc79485183/",
                "https://gama-nn.ru/booking/tours/pts39pcc72195411/",
                "https://gama-nn.ru/booking/tours/pts11pcc55549257/",
                "https://gama-nn.ru/booking/tours/pts52pcc36118367/",
                "https://gama-nn.ru/booking/tours/pts12pcc42788147/",
                "https://gama-nn.ru/booking/tours/pts64pcc94343936/",
                "https://gama-nn.ru/booking/tours/pts7pcc36112675/",
                "https://gama-nn.ru/booking/tours/pts4pcc18777798/"
        };
        for (String url : urlsGama) {
            parserGama.Course(url);
        }
    }
    static public void doninturflot(){
        Parser parser = new Parser();
        int NumberFile = 0;

        //запуск одного resulta
        parser.Course2("https://doninturflot.com/catalog/cruises-from-rostov_on_don/to-moscow/date-from-01.01.2025-to-31.12.2025/ship-maksim_litvinov/", NumberFile);
        //прогон всех рейсов Александра 2025 года
        for (int numberPage = 1; numberPage<4; numberPage++){
            parser.Course2("https://doninturflot.com/catalog/date-from-01.01.2025-to-31.12.2025/ship-shevthenko_aleksandra/?PAGEN_1="+ numberPage, NumberFile);
        }
        NumberFile ++;
        //прогон всех рейсов Чехов 2025 года
        for (int numberPage = 1; numberPage<4; numberPage++){
            parser.Course2("https://doninturflot.com/catalog/date-from-01.01.2025-to-31.12.2025/ship-anton_chehov/?PAGEN_1="+numberPage, NumberFile);
        }
        NumberFile ++;
        //прогон всех рейсов Лавриненков 2025 года
        for (int numberPage = 1; numberPage<4; numberPage++){
            parser.Course2("https://doninturflot.com/catalog/date-from-01.01.2025-to-31.12.2025/ship-general_lavrinenkov/?PAGEN_1="+numberPage, NumberFile);
        }
        NumberFile ++;
        //прогон всех рейсов Стравинский 2025 года
        for (int numberPage = 1; numberPage<3; numberPage++){
            parser.Course2("https://doninturflot.com/catalog/date-from-01.01.2025-to-31.12.2025/ship-igor_stravinsky/?PAGEN_1="+numberPage, NumberFile);
        }
        NumberFile ++;
        //прогон всех рейсов Тихий дон 2025 года
        for (int numberPage = 1; numberPage<2; numberPage++){
            parser.Course2("https://doninturflot.com/catalog/date-from-01.01.2025-to-31.12.2025/ship-tikhiy_don_2024/?PAGEN_1="+numberPage, NumberFile);
        }
        NumberFile ++;
        //прогон всех рейсов ВолгаСтар 2025 года
        for (int numberPage = 1; numberPage<3; numberPage++){
            parser.Course2("https://doninturflot.com/catalog/date-from-01.01.2025-to-31.12.2025/ship-volga_star/?PAGEN_1="+numberPage, NumberFile);
        }
        NumberFile ++;
        //прогон всех рейсов н Бунин 2025 года
        for (int numberPage = 1; numberPage<4; numberPage++){
            parser.Course2("https://doninturflot.com/catalog/date-from-01.01.2025-to-31.12.2025/ship-ivan_bunin_2024/?PAGEN_1="+numberPage, NumberFile);
        }
        NumberFile ++;
        //прогон всех рейсов Максим Литвинов 2025 года
        for (int numberPage = 1; numberPage<3; numberPage++){
            parser.Course2("https://doninturflot.com/catalog/date-from-01.01.2025-to-31.12.2025/ship-maksim_litvinov/?PAGEN_1="+numberPage, NumberFile);
        }
        NumberFile ++;
        //прогон всех рейсов Сергей Дягилев 2025 года
        for (int numberPage = 1; numberPage<3; numberPage++){
            parser.Course2("https://doninturflot.com/catalog/date-from-01.01.2025-to-31.12.2025/ship-sergey_dyagilev/?PAGEN_1="+numberPage, NumberFile);
        }
    }
    static public void vodohod(){
        int table = 0;
        Parser_Vodohod vodohodParser = new Parser_Vodohod();
        String folderName = "vodohod"; //Create folder before start parser
        List<String[]> tasks = new ArrayList<>();

        //СВП
        for (int numberPage = 1; numberPage <= 3; numberPage++) {
            String[] task = new String[]{
                    "https://vodohod.com/cruises/?arrPreFilter[PROPERTY_CATEGORY]=354235&set_filter=y&arrFilter_33_705853973=Y&arrFilter_8_MIN=01.01.2025&arrFilter_8_MAX=31.12.2025&arrFilter_566_3838745332=Y" +numberPage,
                    folderName+ "/vodohod-SBP.txt"
            };
            tasks.add(task);
            table++;
        }
//        Александр Пушкин
        for (int numberPage = 1; numberPage <= 2; numberPage++) {
            String[] task = new String[]{
                    "https://vodohod.com/cruises/?arrPreFilter%5BPROPERTY_CATEGORY%5D=354235&set_filter=y&arrFilter_33_2737816558=Y&arrFilter_8_MIN=01.01.2025&arrFilter_8_MAX=31.12.2025&arrFilter_566_3838745332=Y&PAGEN_1=#anchor-cruises-list" +numberPage,
                    folderName+ "/vodohod"+ Integer.toString(table) +".txt"
            };
            tasks.add(task);
            table++;
        }

        for (int numberPage = 1; numberPage <= 3; numberPage++) {
            String[] task = new String[]{
                    "https://vodohod.com/cruises/?arrPreFilter[PROPERTY_CATEGORY]=354235&set_filter=y&arrFilter_33_281082452=Y&arrFilter_8_MIN=01.01.2025&arrFilter_8_MAX=31.12.2025&arrFilter_566_3838745332=Y" + "&PAGEN_1="+numberPage,
                    folderName+ "/vodohod"+ Integer.toString(table) +".txt"
            };
            tasks.add(task);
            table++;
        }
        for (int numberPage = 1; numberPage <= 3; numberPage++) {
            String[] task = new String[]{
                    "https://vodohod.com/cruises/?arrPreFilter[PROPERTY_CATEGORY]=354235&set_filter=y&arrFilter_33_609249036=Y&arrFilter_8_MIN=01.01.2025&arrFilter_8_MAX=31.12.2025&arrFilter_566_3838745332=Y"+  "&PAGEN_1="+ numberPage,
                    folderName+ "/vodohod"+ Integer.toString(table) +".txt"
            };
            tasks.add(task);
            table++;
        }
        for (int numberPage = 1; numberPage <= 3; numberPage++) {
            String[] task = new String[]{
                    "https://vodohod.com/cruises/?arrPreFilter[PROPERTY_CATEGORY]=354235&set_filter=y&arrFilter_33_1294049986=Y&arrFilter_8_MIN=01.01.2025&arrFilter_8_MAX=31.12.2025&arrFilter_566_3838745332=Y"+  "&PAGEN_1="+ numberPage,
                    folderName+ "/vodohod"+ Integer.toString(table) +".txt"
            };
            tasks.add(task);
            table++;
        }
        //Жуков
        for (int numberPage = 1; numberPage <= 3; numberPage++) {
            String[] task = new String[]{
                    "https://vodohod.com/cruises/?arrPreFilter[PROPERTY_CATEGORY]=354235&set_filter=y&arrFilter_33_3176740534=Y&arrFilter_8_MIN=01.01.2025&arrFilter_8_MAX=31.12.2025&arrFilter_566_3838745332=Y"+  "&PAGEN_1="+ numberPage,
                    folderName+ "/vodohod"+ Integer.toString(table) +".txt"
            };
            tasks.add(task);
            table++;
        }
        for (int numberPage = 1; numberPage <= 8; numberPage++) {
            String[] task = new String[]{
                    "https://vodohod.com/cruises/?arrPreFilter[PROPERTY_CATEGORY]=354235&set_filter=y&arrFilter_33_2755790839=Y&arrFilter_8_MIN=01.01.2025&arrFilter_8_MAX=31.12.2025&arrFilter_566_3838745332=Y"+  "&PAGEN_1="+ numberPage,
                    folderName+ "/vodohod"+ Integer.toString(table) +".txt"
            };
            tasks.add(task);
            table++;
        }
        //Созима
        for (int numberPage = 1; numberPage <= 5; numberPage++) {
            String[] task = new String[]{
                    "https://vodohod.com/cruises/?arrPreFilter[PROPERTY_CATEGORY]=354235&set_filter=y&arrFilter_33_1413124995=Y&arrFilter_8_MIN=01.01.2025&arrFilter_8_MAX=31.12.2025&arrFilter_566_3838745332=Y"+  "&PAGEN_1="+ numberPage,
                    folderName+ "/vodohod"+ Integer.toString(table) +".txt"
            };
            tasks.add(task);
            table++;
        }
        for (int numberPage = 1; numberPage <= 4; numberPage++) {
            String[] task = new String[]{
                    "https://vodohod.com/cruises/?arrPreFilter[PROPERTY_CATEGORY]=354235&set_filter=y&arrFilter_33_2311695342=Y&arrFilter_8_MIN=01.01.2025&arrFilter_8_MAX=31.12.2025&arrFilter_566_3838745332=Y"+  "&PAGEN_1="+ numberPage,
                    folderName+ "/vodohod"+ Integer.toString(table) +".txt"
            };
            tasks.add(task);
            table++;
        }
        for (int numberPage = 1; numberPage <= 3; numberPage++) {
            String[] task = new String[]{
                    "https://vodohod.com/cruises/?arrPreFilter[PROPERTY_CATEGORY]=354235&set_filter=y&arrFilter_33_427210367=Y&arrFilter_8_MIN=01.01.2025&arrFilter_8_MAX=31.12.2025&arrFilter_566_3838745332=Y"+  "&PAGEN_1="+ numberPage,
                    folderName+ "/vodohod"+ Integer.toString(table) +".txt"
            };
            tasks.add(task);
            table++;
        }
        for (int numberPage = 1; numberPage <= 6; numberPage++) {
            String[] task = new String[]{
                    "https://vodohod.com/cruises/?arrPreFilter[PROPERTY_CATEGORY]=354235&set_filter=y&arrFilter_33_3442721337=Y&arrFilter_8_MIN=01.01.2025&arrFilter_8_MAX=31.12.2025&arrFilter_566_3838745332=Y"+  "&PAGEN_1="+ numberPage,
                    folderName+ "/vodohod"+ Integer.toString(table) +".txt"
            };
            tasks.add(task);
            table++;
        }
        for (int numberPage = 1; numberPage <= 11; numberPage++) {
            String[] task = new String[]{
                    "https://vodohod.com/cruises/?arrPreFilter[PROPERTY_CATEGORY]=354235&set_filter=y&arrFilter_33_3559453560=Y&arrFilter_8_MIN=01.01.2025&arrFilter_8_MAX=31.12.2025&arrFilter_566_3838745332=Y"+  "&PAGEN_1="+ numberPage,
                    folderName+ "/vodohod"+ Integer.toString(table) +".txt"
            };
            tasks.add(task);
            table++;
        }

        for (int numberPage = 1; numberPage <= 3; numberPage++) {
            String[] task = new String[]{
                    "https://vodohod.com/cruises/?arrPreFilter[PROPERTY_CATEGORY]=354235&set_filter=y&arrFilter_33_4188233569=Y&arrFilter_8_MIN=01.01.2025&arrFilter_8_MAX=31.12.2025&arrFilter_566_3838745332=Y"+  "&PAGEN_1="+ numberPage,
                    folderName+ "/vodohod"+ Integer.toString(table) +".txt"
            };
            tasks.add(task);
            table++;
        }
        //Ленин
        for (int numberPage = 1; numberPage <=4; numberPage++) {
            String[] task = new String[]{
                    "https://vodohod.com/cruises/?arrPreFilter[PROPERTY_CATEGORY]=354235&set_filter=y&arrFilter_33_1741146818=Y&arrFilter_8_MIN=01.01.2025&arrFilter_8_MAX=31.12.2025&arrFilter_566_3838745332=Y"+  "&PAGEN_1="+ numberPage,
                    folderName+ "/vodohod"+ Integer.toString(table) +".txt"
            };
            tasks.add(task);
            table++;
        }
        for (int numberPage = 1; numberPage <=5; numberPage++) {
            String[] task = new String[]{
                    "https://vodohod.com/cruises/?arrPreFilter[PROPERTY_CATEGORY]=354235&set_filter=y&arrFilter_33_591242005=Y&arrFilter_8_MIN=01.01.2025&arrFilter_8_MAX=31.12.2025&arrFilter_566_3838745332=Y"+  "&PAGEN_1="+ numberPage,
                    folderName+ "/vodohod"+ Integer.toString(table) +".txt"
            };
            tasks.add(task);
            table++;
        }
        for (int numberPage = 1; numberPage <=2; numberPage++) {
            String[] task = new String[]{
                    "https://vodohod.com/cruises/?arrPreFilter[PROPERTY_CATEGORY]=354235&set_filter=y&arrFilter_33_1852933865=Y&arrFilter_8_MIN=01.01.2025&arrFilter_8_MAX=31.12.2025&arrFilter_566_3838745332=Y"+  "&PAGEN_1="+ numberPage,
                    folderName+ "/vodohod"+ Integer.toString(table) +".txt"
            };
            tasks.add(task);
            table++;
        }
        for (int numberPage = 1; numberPage <=4; numberPage++) {
            String[] task = new String[]{
                    "https://vodohod.com/cruises/?arrPreFilter[PROPERTY_CATEGORY]=354235&set_filter=y&arrFilter_33_3395159584=Y&arrFilter_8_MIN=01.01.2025&arrFilter_8_MAX=31.12.2025&arrFilter_566_3838745332=Y"+  "&PAGEN_1="+ numberPage,
                    folderName+ "/vodohod"+ Integer.toString(table) +".txt"
            };
            tasks.add(task);
            table++;
        }
        for (int numberPage = 1; numberPage <=3; numberPage++) {
            String[] task = new String[]{
                    "https://vodohod.com/cruises/?arrPreFilter[PROPERTY_CATEGORY]=354235&set_filter=y&arrFilter_33_975606356=Y&arrFilter_8_MIN=01.01.2025&arrFilter_8_MAX=31.12.2025&arrFilter_566_3838745332=Y"+  "&PAGEN_1="+ numberPage,
                    folderName+ "/vodohod"+ Integer.toString(table) +".txt"
            };
            tasks.add(task);
            table++;
        }
        for (int numberPage = 1; numberPage <=4; numberPage++) {
            String[] task = new String[]{
                    "https://vodohod.com/cruises/?arrPreFilter[PROPERTY_CATEGORY]=354235&set_filter=y&arrFilter_33_2262374431=Y&arrFilter_8_MIN=01.01.2025&arrFilter_8_MAX=31.12.2025&arrFilter_566_3838745332=Y"+  "&PAGEN_1="+ numberPage,
                    folderName+ "/vodohod"+ Integer.toString(table) +".txt"
            };
            tasks.add(task);
            table++;
        }
        //Нижний новогород
        for (int numberPage = 1; numberPage <=4; numberPage++) {
            String[] task = new String[]{
                    "https://vodohod.com/cruises/?arrPreFilter[PROPERTY_CATEGORY]=354235&set_filter=y&arrFilter_33_2393141239=Y&arrFilter_8_MIN=01.01.2025&arrFilter_8_MAX=31.12.2025&arrFilter_566_3838745332=Y"+  "&PAGEN_1="+ numberPage,
                    folderName+ "/vodohod"+ Integer.toString(table) +".txt"
            };
            tasks.add(task);
            table++;
        }
        for (int numberPage = 1; numberPage <=2; numberPage++) {
            String[] task = new String[]{
                    "https://vodohod.com/cruises/?arrPreFilter[PROPERTY_CATEGORY]=354235&set_filter=y&arrFilter_33_3165157610=Y&arrFilter_8_MIN=01.01.2025&arrFilter_8_MAX=31.12.2025&arrFilter_566_3838745332=Y"+  "&PAGEN_1="+ numberPage,
                    folderName+ "/vodohod"+ Integer.toString(table) +".txt"
            };
            tasks.add(task);
            table++;
        }
        for (int numberPage = 1; numberPage <=3; numberPage++) {
            String[] task = new String[]{
                    "https://vodohod.com/cruises/?arrPreFilter[PROPERTY_CATEGORY]=354235&set_filter=y&arrFilter_33_4274953080=Y&arrFilter_8_MIN=01.01.2025&arrFilter_8_MAX=31.12.2025&arrFilter_566_3838745332=Y"+  "&PAGEN_1="+ numberPage,
                    folderName+ "/vodohod"+ Integer.toString(table) +".txt"
            };
            tasks.add(task);
            table++;
        }
        for (int numberPage = 1; numberPage <=3; numberPage++) {
            String[] task = new String[]{
                    "https://vodohod.com/cruises/?arrPreFilter[PROPERTY_CATEGORY]=354235&set_filter=y&arrFilter_33_3124032175=Y&arrFilter_8_MIN=01.01.2025&arrFilter_8_MAX=31.12.2025&arrFilter_566_3838745332=Y"+  "&PAGEN_1="+ numberPage,
                    folderName+ "/vodohod"+ Integer.toString(table) +".txt"
            };
            tasks.add(task);
            table++;
        }
        for (int numberPage = 1; numberPage <=4; numberPage++) {
            String[] task = new String[]{
                    "https://vodohod.com/cruises/?arrPreFilter[PROPERTY_CATEGORY]=354235&set_filter=y&arrFilter_33_3035593373=Y&arrFilter_8_MIN=01.01.2025&arrFilter_8_MAX=31.12.2025&arrFilter_566_3838745332=Y"+  "&PAGEN_1="+ numberPage,
                    folderName+ "/vodohod"+ Integer.toString(table) +".txt"
            };
            tasks.add(task);
            table++;
        }
        for (int numberPage = 1; numberPage <=4; numberPage++) {
            String[] task = new String[]{
                    "https://vodohod.com/cruises/?arrPreFilter[PROPERTY_CATEGORY]=354235&set_filter=y&arrFilter_33_3286780427=Y&arrFilter_8_MIN=01.01.2025&arrFilter_8_MAX=31.12.2025&arrFilter_566_3838745332=Y"+  "&PAGEN_1="+ numberPage,
                    folderName+ "/vodohod"+ Integer.toString(table) +".txt"
            };
            tasks.add(task);
            table++;
        }
        for (int numberPage = 1; numberPage <=5; numberPage++) {
            String[] task = new String[]{
                    "https://vodohod.com/cruises/?arrPreFilter[PROPERTY_CATEGORY]=354235&set_filter=y&arrFilter_33_3544528737=Y&arrFilter_8_MIN=01.01.2025&arrFilter_8_MAX=31.12.2025&arrFilter_566_3838745332=Y"+  "&PAGEN_1="+ numberPage,
                    folderName+ "/vodohod"+ Integer.toString(table) +".txt"
            };
            tasks.add(task);
            table++;
        }
        for (int numberPage = 1; numberPage <=4; numberPage++) {
            String[] task = new String[]{
                    "https://vodohod.com/cruises/?arrPreFilter[PROPERTY_CATEGORY]=354235&set_filter=y&arrFilter_33_3478905690=Y&arrFilter_8_MIN=01.01.2025&arrFilter_8_MAX=31.12.2025&arrFilter_566_3838745332=Y"+  "&PAGEN_1="+ numberPage,
                    folderName+ "/vodohod"+ Integer.toString(table) +".txt"
            };
            tasks.add(task);
            table++;
        }
        for (int numberPage = 1; numberPage <=7; numberPage++) {
            String[] task = new String[]{
                    "https://vodohod.com/cruises/?arrPreFilter[PROPERTY_CATEGORY]=354235&set_filter=y&arrFilter_33_2281869357=Y&arrFilter_8_MIN=01.01.2025&arrFilter_8_MAX=31.12.2025&arrFilter_566_3838745332=Y"+  "&PAGEN_1="+ numberPage,
                    folderName+ "/vodohod"+ Integer.toString(table) +".txt"
            };
            tasks.add(task);
            table++;
        }
        ExecutorService executorService = Executors.newFixedThreadPool(3);
//
        for (String[] task : tasks) {
            executorService.submit(() -> {
                try {
                    vodohodParser.Course(task[0], task[1]);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
//
        executorService.shutdown();
        while (!executorService.isTerminated()) {
        }
    }
}
