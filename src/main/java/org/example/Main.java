package org.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setProperty("webdriver.chrome.driver", "chromedriver-134-win64/chromedriver.exe");

//        CeasarTravel();
//        WhiteSwan();
//        volgaPlace();
//        sCruises();
//        mosturFlot();
//        vodohod();
        doninturflot();
//        gamma();
        //sCruises();
    }
    static public void CeasarTravel(){
        ParseCaesarTravel parseCaesarTravel = new ParseCaesarTravel();
        String[] urls = {
                "https://www.cezar-travel.ru/president-ship",
                "https://www.cezar-travel.ru/muromets-ship"
        };
        for (String url : urls){
            parseCaesarTravel.Course(url,"CeasarTravel.txt");
        }
    }

    static public void WhiteSwan(){
        ParserWhiteSwan parserWhiteSwan = new ParserWhiteSwan();
        String[] urls = {
                "https://www.bely-lebed.ru/ship.asp?t=147",
                "https://www.bely-lebed.ru/ship.asp?t=132"
        };
        for (String url : urls){
            parserWhiteSwan.Course(url,"WhiteSwan.txt");
        }
    }
    static public void volgaPlace(){
        ParseVolgaPles parveVolga = new ParseVolgaPles();
        String[] urls = {
                "https://volgaples.ru/boats/boat-1.html",
                "https://volgaples.ru/boats/boat-2.html",
                "https://volgaples.ru/boats/boat-3.html",
                "https://volgaples.ru/boats/boat-4.html"
        };
        for(String url : urls){
            parveVolga.Course(url, "VolgaPles.txt");
        }
    }
    static public void mosturFlot(){
        Parser_Mosturflot parserMosturflot = new Parser_Mosturflot();
        String[] urlsSozv = {
                "https://www.mosturflot.ru/ships/5/",
                "https://www.mosturflot.ru/ships/3/",
                "https://www.mosturflot.ru/ships/11/",
                "https://www.mosturflot.ru/ships/79/",
                "https://www.mosturflot.ru/ships/7/",
                "https://www.mosturflot.ru/ships/2/",
                "https://www.mosturflot.ru/ships/1/",
                "https://www.mosturflot.ru/ships/8/",
                "https://www.mosturflot.ru/ships/9/",
                "https://www.mosturflot.ru/ships/12/",
                "https://www.mosturflot.ru/ships/13/",
                "https://www.mosturflot.ru/ships/14/",
                "https://www.mosturflot.ru/ships/10/",
        };
        for (String url : urlsSozv) {
            parserMosturflot.Course(url,"mosturflot.txt");
        }
    }
    static public void sCruises(){
        S_Cruises sCruises = new S_Cruises();
        String[] urlsSozv = {
                "https://s-cruises.com/cruises/filter/date_cruise_start-from-01.01.2025-to-10.11.2025/date_cruise_end-from-15.11.2024-to-13.11.2025/numbers_of_days-from-3-to-31/ships-is-rossia_/count_persont-from-0/apply/?Pagen_1=2&PAGEN_1=",
                "https://s-cruises.com/cruises/filter/date_cruise_start-from-01.01.2025-to-10.11.2025/date_cruise_end-from-15.11.2024-to-13.11.2025/numbers_of_days-from-3-to-31/ships-is-rossia_/count_persont-from-0/apply/?Pagen_1=2&PAGEN_1=2",
                "https://s-cruises.com/cruises/filter/date_cruise_start-from-01.01.2025-to-10.11.2025/date_cruise_end-from-15.11.2024-to-13.11.2025/numbers_of_days-from-3-to-31/ships-is-ogni_bolshogo_goroda/count_persont-from-0/apply/?Pagen_1=2&PAGEN_1=",
                "https://s-cruises.com/cruises/filter/date_cruise_start-from-01.01.2025-to-10.11.2025/date_cruise_end-from-15.11.2024-to-13.11.2025/numbers_of_days-from-3-to-31/ships-is-ogni_bolshogo_goroda/count_persont-from-0/apply/?Pagen_1=2&PAGEN_1=2",
                "https://s-cruises.com/cruises/filter/date_cruise_start-from-01.01.2025-to-10.11.2025/date_cruise_end-from-15.11.2024-to-13.11.2025/numbers_of_days-from-3-to-31/ships-is-little_prince/count_persont-from-0/apply/?Pagen_1=2&PAGEN_1=",
                "https://s-cruises.com/cruises/filter/date_cruise_start-from-01.01.2025-to-10.11.2025/date_cruise_end-from-15.11.2024-to-13.11.2025/numbers_of_days-from-3-to-31/ships-is-little_prince/count_persont-from-0/apply/?Pagen_1=2&PAGEN_1=2",
                "https://s-cruises.com/cruises/filter/date_cruise_start-from-01.01.2025-to-10.11.2025/date_cruise_end-from-15.11.2024-to-13.11.2025/numbers_of_days-from-3-to-31/ships-is-simfonija_severa/count_persont-from-0/apply/?Pagen_1=2&PAGEN_1=",
                "https://s-cruises.com/cruises/filter/date_cruise_start-from-01.01.2025-to-10.11.2025/date_cruise_end-from-15.11.2024-to-13.11.2025/numbers_of_days-from-3-to-31/ships-is-simfonija_severa/count_persont-from-0/apply/?Pagen_1=2&PAGEN_1=2",
                "https://s-cruises.com/cruises/filter/date_cruise_start-from-01.01.2025-to-10.11.2025/date_cruise_end-from-15.11.2024-to-13.11.2025/numbers_of_days-from-3-to-31/ships-is-lebedinoye_ozero/count_persont-from-0/apply/?Pagen_1=2&PAGEN_1=",
                "https://s-cruises.com/cruises/filter/date_cruise_start-from-01.01.2025-to-10.11.2025/date_cruise_end-from-15.11.2024-to-13.11.2025/numbers_of_days-from-3-to-31/ships-is-lebedinoye_ozero/count_persont-from-0/apply/?Pagen_1=2&PAGEN_1=2",
                "https://s-cruises.com/cruises/filter/date_cruise_start-from-01.01.2025-to-10.11.2025/date_cruise_end-from-15.11.2024-to-13.11.2025/numbers_of_days-from-3-to-31/ships-is-lunnaya_sonata/count_persont-from-0/apply/?Pagen_1=2&PAGEN_1=",
                "https://s-cruises.com/cruises/filter/date_cruise_start-from-01.01.2025-to-10.11.2025/date_cruise_end-from-15.11.2024-to-13.11.2025/numbers_of_days-from-3-to-31/ships-is-lunnaya_sonata/count_persont-from-0/apply/?Pagen_1=2&PAGEN_1=2",
                "https://s-cruises.com/cruises/filter/date_cruise_start-from-01.01.2025-to-10.11.2025/date_cruise_end-from-15.11.2024-to-13.11.2025/numbers_of_days-from-3-to-31/ships-is-severnaya_skazka/count_persont-from-0/apply/?Pagen_1=2&PAGEN_1=",
                "https://s-cruises.com/cruises/filter/date_cruise_start-from-01.01.2025-to-10.11.2025/date_cruise_end-from-15.11.2024-to-13.11.2025/numbers_of_days-from-3-to-31/ships-is-nekrasov/count_persont-from-0/apply/?Pagen_1=2&PAGEN_1=",
                "https://s-cruises.com/cruises/filter/date_cruise_start-from-01.01.2025-to-10.11.2025/date_cruise_end-from-15.11.2024-to-13.11.2025/numbers_of_days-from-3-to-31/ships-is-nekrasov/count_persont-from-0/apply/?Pagen_1=2&PAGEN_1=2",
                "https://s-cruises.com/cruises/filter/date_cruise_start-from-01.01.2025-to-10.11.2025/date_cruise_end-from-15.11.2024-to-13.11.2025/numbers_of_days-from-3-to-31/ships-is-benua/count_persont-from-0/apply/?Pagen_1=2&PAGEN_1=",
                "https://s-cruises.com/cruises/filter/date_cruise_start-from-01.01.2025-to-10.11.2025/date_cruise_end-from-15.11.2024-to-13.11.2025/numbers_of_days-from-3-to-31/ships-is-benua/count_persont-from-0/apply/?Pagen_1=2&PAGEN_1=2",
                "https://s-cruises.com/cruises/filter/date_cruise_start-from-01.01.2025-to-10.11.2025/date_cruise_end-from-15.11.2024-to-13.11.2025/numbers_of_days-from-3-to-31/ships-is-imperia/count_persont-from-0/apply/?Pagen_1=2&PAGEN_1="
        };
        for (String url : urlsSozv) {
            sCruises.s_cruises(url);
        }
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
    static public void gammaInfo(){
        Parser_gama parserGama = new Parser_gama();
        String[] urlsGama = {
                "https://gama-nn.ru/cruise/aurum/",
                "https://gama-nn.ru/cruise/zolotoekolco/",
                "https://gama-nn.ru/cruise/popov/",
                "https://gama-nn.ru/cruise/aldan/",
                "https://gama-nn.ru/cruise/sveshnikov/",
                "https://gama-nn.ru/cruise/nikitin/",
                "https://gama-nn.ru/cruise/kulibin/",
                "https://gama-nn.ru/cruise/okt-revolution/"
        };
        for (String url : urlsGama) {
            parserGama.CourseInfo(url,"gammaInfo.txt");
        }
    }

    public static void parseDoninturflotSheep(String shipName, int pagesCount, String url){
        System.out.println("Parsing sheep " + shipName);
        Parser parser = new Parser();
        if(pagesCount == 1){
            parser.Course2(url, shipName);
            return;
        }
        for (int numberPage = 1; numberPage <= pagesCount; numberPage++) {
            parser.Course2(url + numberPage, shipName);
        }
    }

    //подразумевает что на одной странице до 20 строк
    public static int calculatePagesCount(int itemsCount) {
        return (itemsCount + 20 - 1) / 20;
    }

    static public void doninturflot(){
        //этот парсер пока не определяет автоматически сколько страниц на каждый теплоход ему надо пройти
        //поэтому число рейсов для теплохода надо проставить вручную, в методе calculatePagesCount

        parseDoninturflotSheep("Litvinov", calculatePagesCount(49), "https://doninturflot.com/catalog/ship-maksim_litvinov/?PAGEN_1=");
//        parseDoninturflotSheep("Александра", calculatePagesCount(57), "https://doninturflot.com/catalog/date-from-01.01.2025-to-31.12.2025/ship-shevthenko_aleksandra/?PAGEN_1=");
//        parseDoninturflotSheep("Чехов", calculatePagesCount(52), "https://doninturflot.com/catalog/date-from-01.01.2025-to-31.12.2025/ship-anton_chehov/?PAGEN_1=");
//
//        parseDoninturflotSheep("Лавриненков", calculatePagesCount(45), "https://doninturflot.com/catalog/date-from-01.01.2025-to-31.12.2025/ship-general_lavrinenkov/?PAGEN_1=");
//        parseDoninturflotSheep("Стравинский", calculatePagesCount(36), "https://doninturflot.com/catalog/date-from-01.01.2025-to-31.12.2025/ship-igor_stravinsky/?PAGEN_1=");
//        parseDoninturflotSheep("Тихий дон", calculatePagesCount(46), "https://doninturflot.com/catalog/date-from-01.01.2025-to-31.12.2025/ship-tikhiy_don_2024/?PAGEN_1=");
//        parseDoninturflotSheep("ВолгаСтар", calculatePagesCount(54), "https://doninturflot.com/catalog/date-from-01.01.2025-to-31.12.2025/ship-volga_star/?PAGEN_1=");
//        parseDoninturflotSheep("Бунин", calculatePagesCount(77), "https://doninturflot.com/catalog/date-from-01.01.2025-to-31.12.2025/ship-ivan_bunin_2024/?PAGEN_1=");
//        parseDoninturflotSheep("Максим Литвинов", calculatePagesCount(49), "https://doninturflot.com/catalog/date-from-01.01.2025-to-31.12.2025/ship-maksim_litvinov/?PAGEN_1=");
//        parseDoninturflotSheep("Сергей Дягилев", calculatePagesCount(49), "https://doninturflot.com/catalog/date-from-01.01.2025-to-31.12.2025/ship-sergey_dyagilev/?PAGEN_1=");

    }

    /**
     * В этом методе задаем какие задачи мы хотим исключить из обработки
     * @param tasks
     * @param task
     * @param table
     */
    static void addTask(List<String[]> tasks, String[] task, Integer table){
        List<Integer> tablesToInclude = Arrays.asList(114,33,51,68,77,97);
        if(!tablesToInclude.contains(table)){
            return;
        }
        tasks.add(task);
    }

    static public void vodohod(){
        int table = 0;
        Parser_Vodohod vodohodParser = new Parser_Vodohod();
        String folderName = "vodohod"; //Create folder before start parser
        List<String[]> tasks = new ArrayList<>();

        //СВП
        for (int numberPage = 1; numberPage <= 3; numberPage++) {
            String[] task = new String[]{
                    "https://vodohod.com/cruises/?&set_filter=y&arrFilter_33_705853973=Y&arrFilter_8_MIN=01.01.2025&arrFilter_8_MAX=31.12.2025&arrFilter_566_3838745332=Y" +numberPage,
                    folderName+ "/vodohod-SBP.txt"
            };
            addTask(tasks, task, table);
            table++;
        }
//        Александр Пушкин
        for (int numberPage = 1; numberPage <= 2; numberPage++) {
            String[] task = new String[]{
                    "https://vodohod.com/cruises/?set_filter=y&arrFilter_33_2737816558=Y&arrFilter_8_MIN=01.01.2025&arrFilter_8_MAX=31.12.2025&arrFilter_566_3838745332=Y&PAGEN_1=#anchor-cruises-list" +numberPage,
                    folderName+ "/vodohod"+ Integer.toString(table) +".txt"
            };
            addTask(tasks, task, table);
            table++;
        }

        for (int numberPage = 1; numberPage <= 3; numberPage++) {
            String[] task = new String[]{
                    "https://vodohod.com/cruises/?&set_filter=y&arrFilter_33_281082452=Y&arrFilter_8_MIN=01.01.2025&arrFilter_8_MAX=31.12.2025&arrFilter_566_3838745332=Y" + "&PAGEN_1="+numberPage,
                    folderName+ "/vodohod"+ Integer.toString(table) +".txt"
            };
            addTask(tasks, task, table);
            table++;
        }
        for (int numberPage = 1; numberPage <= 3; numberPage++) {
            String[] task = new String[]{
                    "https://vodohod.com/cruises/?&set_filter=y&arrFilter_33_609249036=Y&arrFilter_8_MIN=01.01.2025&arrFilter_8_MAX=31.12.2025&arrFilter_566_3838745332=Y"+  "&PAGEN_1="+ numberPage,
                    folderName+ "/vodohod"+ Integer.toString(table) +".txt"
            };
            addTask(tasks, task, table);
            table++;
        }
        for (int numberPage = 1; numberPage <= 3; numberPage++) {
            String[] task = new String[]{
                    "https://vodohod.com/cruises/?&set_filter=y&arrFilter_33_1294049986=Y&arrFilter_8_MIN=01.01.2025&arrFilter_8_MAX=31.12.2025&arrFilter_566_3838745332=Y"+  "&PAGEN_1="+ numberPage,
                    folderName+ "/vodohod"+ Integer.toString(table) +".txt"
            };
            addTask(tasks, task, table);
            table++;
        }
        //Жуков
        for (int numberPage = 1; numberPage <= 3; numberPage++) {
            String[] task = new String[]{
                    "https://vodohod.com/cruises/?&set_filter=y&arrFilter_33_3176740534=Y&arrFilter_8_MIN=01.01.2025&arrFilter_8_MAX=31.12.2025&arrFilter_566_3838745332=Y"+  "&PAGEN_1="+ numberPage,
                    folderName+ "/vodohod"+ Integer.toString(table) +".txt"
            };
            addTask(tasks, task, table);
            table++;
        }
        for (int numberPage = 1; numberPage <= 8; numberPage++) {
            String[] task = new String[]{
                    "https://vodohod.com/cruises/?&set_filter=y&arrFilter_33_2755790839=Y&arrFilter_8_MIN=01.01.2025&arrFilter_8_MAX=31.12.2025&arrFilter_566_3838745332=Y"+  "&PAGEN_1="+ numberPage,
                    folderName+ "/vodohod"+ Integer.toString(table) +".txt"
            };
            addTask(tasks, task, table);
            table++;
        }
        //Созима
        for (int numberPage = 1; numberPage <= 5; numberPage++) {
            String[] task = new String[]{
                    "https://vodohod.com/cruises/?&set_filter=y&arrFilter_33_1413124995=Y&arrFilter_8_MIN=01.01.2025&arrFilter_8_MAX=31.12.2025&arrFilter_566_3838745332=Y"+  "&PAGEN_1="+ numberPage,
                    folderName+ "/vodohod"+ Integer.toString(table) +".txt"
            };
            addTask(tasks, task, table);
            table++;
        }
        for (int numberPage = 1; numberPage <= 4; numberPage++) {
            String[] task = new String[]{
                    "https://vodohod.com/cruises/?&set_filter=y&arrFilter_33_2311695342=Y&arrFilter_8_MIN=01.01.2025&arrFilter_8_MAX=31.12.2025&arrFilter_566_3838745332=Y"+  "&PAGEN_1="+ numberPage,
                    folderName+ "/vodohod"+ Integer.toString(table) +".txt"
            };
            tasks.add(task);
            table++;
        }
        for (int numberPage = 1; numberPage <= 3; numberPage++) {
            String[] task = new String[]{
                    "https://vodohod.com/cruises/?&set_filter=y&arrFilter_33_427210367=Y&arrFilter_8_MIN=01.01.2025&arrFilter_8_MAX=31.12.2025&arrFilter_566_3838745332=Y"+  "&PAGEN_1="+ numberPage,
                    folderName+ "/vodohod"+ Integer.toString(table) +".txt"
            };
            addTask(tasks, task, table);
            table++;
        }
        for (int numberPage = 1; numberPage <= 6; numberPage++) {
            String[] task = new String[]{
                    "https://vodohod.com/cruises/?&set_filter=y&arrFilter_33_3442721337=Y&arrFilter_8_MIN=01.01.2025&arrFilter_8_MAX=31.12.2025&arrFilter_566_3838745332=Y"+  "&PAGEN_1="+ numberPage,
                    folderName+ "/vodohod"+ Integer.toString(table) +".txt"
            };
            addTask(tasks, task, table);
            table++;
        }
        for (int numberPage = 1; numberPage <= 11; numberPage++) {
            String[] task = new String[]{
                    "https://vodohod.com/cruises/?&set_filter=y&arrFilter_33_3559453560=Y&arrFilter_8_MIN=01.01.2025&arrFilter_8_MAX=31.12.2025&arrFilter_566_3838745332=Y"+  "&PAGEN_1="+ numberPage,
                    folderName+ "/vodohod"+ Integer.toString(table) +".txt"
            };
            tasks.add(task);
            table++;
        }

        for (int numberPage = 1; numberPage <= 3; numberPage++) {
            String[] task = new String[]{
                    "https://vodohod.com/cruises/?&set_filter=y&arrFilter_33_4188233569=Y&arrFilter_8_MIN=01.01.2025&arrFilter_8_MAX=31.12.2025&arrFilter_566_3838745332=Y"+  "&PAGEN_1="+ numberPage,
                    folderName+ "/vodohod"+ Integer.toString(table) +".txt"
            };
            addTask(tasks, task, table);
            table++;
        }
        //Ленин
        for (int numberPage = 1; numberPage <=4; numberPage++) {
            String[] task = new String[]{
                    "https://vodohod.com/cruises/?&set_filter=y&arrFilter_33_1741146818=Y&arrFilter_8_MIN=01.01.2025&arrFilter_8_MAX=31.12.2025&arrFilter_566_3838745332=Y"+  "&PAGEN_1="+ numberPage,
                    folderName+ "/vodohod"+ Integer.toString(table) +".txt"
            };
            addTask(tasks, task, table);
            table++;
        }
        for (int numberPage = 1; numberPage <=5; numberPage++) {
            String[] task = new String[]{
                    "https://vodohod.com/cruises/?&set_filter=y&arrFilter_33_591242005=Y&arrFilter_8_MIN=01.01.2025&arrFilter_8_MAX=31.12.2025&arrFilter_566_3838745332=Y"+  "&PAGEN_1="+ numberPage,
                    folderName+ "/vodohod"+ Integer.toString(table) +".txt"
            };
            addTask(tasks, task, table);
            table++;
        }
        for (int numberPage = 1; numberPage <=2; numberPage++) {
            String[] task = new String[]{
                    "https://vodohod.com/cruises/?&set_filter=y&arrFilter_33_1852933865=Y&arrFilter_8_MIN=01.01.2025&arrFilter_8_MAX=31.12.2025&arrFilter_566_3838745332=Y"+  "&PAGEN_1="+ numberPage,
                    folderName+ "/vodohod"+ Integer.toString(table) +".txt"
            };
            addTask(tasks, task, table);
            table++;
        }
        for (int numberPage = 1; numberPage <=4; numberPage++) {
            String[] task = new String[]{
                    "https://vodohod.com/cruises/?&set_filter=y&arrFilter_33_3395159584=Y&arrFilter_8_MIN=01.01.2025&arrFilter_8_MAX=31.12.2025&arrFilter_566_3838745332=Y"+  "&PAGEN_1="+ numberPage,
                    folderName+ "/vodohod"+ Integer.toString(table) +".txt"
            };
            addTask(tasks, task, table);
            table++;
        }
        for (int numberPage = 1; numberPage <=3; numberPage++) {
            String[] task = new String[]{
                    "https://vodohod.com/cruises/?&set_filter=y&arrFilter_33_975606356=Y&arrFilter_8_MIN=01.01.2025&arrFilter_8_MAX=31.12.2025&arrFilter_566_3838745332=Y"+  "&PAGEN_1="+ numberPage,
                    folderName+ "/vodohod"+ Integer.toString(table) +".txt"
            };
            addTask(tasks, task, table);
            table++;
        }
        for (int numberPage = 1; numberPage <=4; numberPage++) {
            String[] task = new String[]{
                    "https://vodohod.com/cruises/?&set_filter=y&arrFilter_33_2262374431=Y&arrFilter_8_MIN=01.01.2025&arrFilter_8_MAX=31.12.2025&arrFilter_566_3838745332=Y"+  "&PAGEN_1="+ numberPage,
                    folderName+ "/vodohod"+ Integer.toString(table) +".txt"
            };
            addTask(tasks, task, table);
            table++;
        }
        //Нижний новогород
        for (int numberPage = 1; numberPage <=4; numberPage++) {
            String[] task = new String[]{
                    "https://vodohod.com/cruises/?&set_filter=y&arrFilter_33_2393141239=Y&arrFilter_8_MIN=01.01.2025&arrFilter_8_MAX=31.12.2025&arrFilter_566_3838745332=Y"+  "&PAGEN_1="+ numberPage,
                    folderName+ "/vodohod"+ Integer.toString(table) +".txt"
            };
            addTask(tasks, task, table);
            table++;
        }
        for (int numberPage = 1; numberPage <=2; numberPage++) {
            String[] task = new String[]{
                    "https://vodohod.com/cruises/?&set_filter=y&arrFilter_33_3165157610=Y&arrFilter_8_MIN=01.01.2025&arrFilter_8_MAX=31.12.2025&arrFilter_566_3838745332=Y"+  "&PAGEN_1="+ numberPage,
                    folderName+ "/vodohod"+ Integer.toString(table) +".txt"
            };
            addTask(tasks, task, table);
            table++;
        }
        for (int numberPage = 1; numberPage <=3; numberPage++) {
            String[] task = new String[]{
                    "https://vodohod.com/cruises/?&set_filter=y&arrFilter_33_4274953080=Y&arrFilter_8_MIN=01.01.2025&arrFilter_8_MAX=31.12.2025&arrFilter_566_3838745332=Y"+  "&PAGEN_1="+ numberPage,
                    folderName+ "/vodohod"+ Integer.toString(table) +".txt"
            };
            addTask(tasks, task, table);
            table++;
        }
        for (int numberPage = 1; numberPage <=3; numberPage++) {
            String[] task = new String[]{
                    "https://vodohod.com/cruises/?&set_filter=y&arrFilter_33_3124032175=Y&arrFilter_8_MIN=01.01.2025&arrFilter_8_MAX=31.12.2025&arrFilter_566_3838745332=Y"+  "&PAGEN_1="+ numberPage,
                    folderName+ "/vodohod"+ Integer.toString(table) +".txt"
            };
            addTask(tasks, task, table);
            table++;
        }
        for (int numberPage = 1; numberPage <=4; numberPage++) {
            String[] task = new String[]{
                    "https://vodohod.com/cruises/?&set_filter=y&arrFilter_33_3035593373=Y&arrFilter_8_MIN=01.01.2025&arrFilter_8_MAX=31.12.2025&arrFilter_566_3838745332=Y"+  "&PAGEN_1="+ numberPage,
                    folderName+ "/vodohod"+ Integer.toString(table) +".txt"
            };
            addTask(tasks, task, table);
            table++;
        }
        for (int numberPage = 1; numberPage <=4; numberPage++) {
            String[] task = new String[]{
                    "https://vodohod.com/cruises/?&set_filter=y&arrFilter_33_3286780427=Y&arrFilter_8_MIN=01.01.2025&arrFilter_8_MAX=31.12.2025&arrFilter_566_3838745332=Y"+  "&PAGEN_1="+ numberPage,
                    folderName+ "/vodohod"+ Integer.toString(table) +".txt"
            };
            addTask(tasks, task, table);
            table++;
        }
        for (int numberPage = 1; numberPage <=5; numberPage++) {
            String[] task = new String[]{
                    "https://vodohod.com/cruises/?&set_filter=y&arrFilter_33_3544528737=Y&arrFilter_8_MIN=01.01.2025&arrFilter_8_MAX=31.12.2025&arrFilter_566_3838745332=Y"+  "&PAGEN_1="+ numberPage,
                    folderName+ "/vodohod"+ Integer.toString(table) +".txt"
            };
            addTask(tasks, task, table);
            table++;
        }
        for (int numberPage = 1; numberPage <=4; numberPage++) {
            String[] task = new String[]{
                    "https://vodohod.com/cruises/?&set_filter=y&arrFilter_33_3478905690=Y&arrFilter_8_MIN=01.01.2025&arrFilter_8_MAX=31.12.2025&arrFilter_566_3838745332=Y"+  "&PAGEN_1="+ numberPage,
                    folderName+ "/vodohod"+ Integer.toString(table) +".txt"
            };
            addTask(tasks, task, table);
            table++;
        }
        for (int numberPage = 1; numberPage <=7; numberPage++) {
            String[] task = new String[]{
                    "https://vodohod.com/cruises/?&set_filter=y&arrFilter_33_2281869357=Y&arrFilter_8_MIN=01.01.2025&arrFilter_8_MAX=31.12.2025&arrFilter_566_3838745332=Y"+  "&PAGEN_1="+ numberPage,
                    folderName+ "/vodohod"+ Integer.toString(table) +".txt"
            };
            addTask(tasks, task, table);
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
