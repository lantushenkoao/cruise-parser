package org.example;

import java.util.Arrays;
import java.util.List;

import static org.example.MosturflotParser.parseMosturflotCruises;
import static org.example.VolgaVolgaParser.parseVolgaVolgaCruises;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception {
//        List<String> urls = Arrays.asList(
//                "https://www.mosturflot.ru/river-cruises/?ship_id=14&date_from=01.01.2025");
        parseMosturflotCruises(Arrays.asList(
                new ParserUtils.ShipUrl("https://www.mosturflot.ru/river-cruises/?ship_id=5&date_from=01.01.2025", "Александр Грин"),
                new ParserUtils.ShipUrl("https://www.mosturflot.ru/river-cruises/?ship_id=3&date_from=01.01.2025", "Княжна ВИКТОРИЯ"),
                new ParserUtils.ShipUrl("https://www.mosturflot.ru/river-cruises/?ship_id=7&date_from=01.01.2025", "Михаил Булгаков"),
                new ParserUtils.ShipUrl("https://www.mosturflot.ru/river-cruises/?ship_id=2&date_from=01.01.2025", "Андрей РУБЛЁВ"),
                new ParserUtils.ShipUrl("https://www.mosturflot.ru/river-cruises/?ship_id=1&date_from=01.01.2025", "Сергей ЕСЕНИН"),
                new ParserUtils.ShipUrl("https://www.mosturflot.ru/river-cruises/?ship_id=8&date_from=01.01.2025", "Василий СУРИКОВ"),
                new ParserUtils.ShipUrl("https://www.mosturflot.ru/river-cruises/?ship_id=9&date_from=01.01.2025", "Илья РЕПИН"),
                new ParserUtils.ShipUrl("https://www.mosturflot.ru/river-cruises/?ship_id=10&date_from=01.01.2025", "Николай КАРАМЗИН"),
                new ParserUtils.ShipUrl("https://www.mosturflot.ru/river-cruises/?ship_id=12&date_from=01.01.2025", "А.С.Пушкин"),
                new ParserUtils.ShipUrl("https://www.mosturflot.ru/river-cruises/?ship_id=13&date_from=01.01.2025", "Княжна АНАСТАСИЯ"),
                new ParserUtils.ShipUrl("https://www.mosturflot.ru/river-cruises/?ship_id=14&date_from=01.01.2025", "Леонид КРАСИН"),
                new ParserUtils.ShipUrl("https://www.mosturflot.ru/river-cruises/?ship_id=11&date_from=01.01.2025", "И.А. КРЫЛОВ"),
                new ParserUtils.ShipUrl("https://www.mosturflot.ru/river-cruises/?ship_id=79&date_from=01.01.2025", "СЕРГЕЙ ОБРАЗЦОВ")
                ));


//        List<String> urls = Arrays.asList(
//                "https://volgawolga.ru/kutuzov/");
//        //использовать это для конвертации русского текста https://r12a.github.io/app-conversion/
//        String shipName = "Михаил Кутузов";
//
//        parseVolgaVolgaCruises(shipName, urls);

//        VodohodParser.parseVolgaVolgaCruises(
//                Arrays.asList(
//                        new ParserUtils.ShipUrl("https://vodohod.com/ships/shashkov/", "Зосима Шашков"),
//                        new ParserUtils.ShipUrl("https://vodohod.com/ships/andropov/", "Юрий Андропов"),
//                        new ParserUtils.ShipUrl("https://vodohod.com/ships/biryusa/", "Бирюса (СВП)"),
//                        new ParserUtils.ShipUrl("https://vodohod.com/ships/gorky/", "Максим Горький"),
//                        new ParserUtils.ShipUrl("https://vodohod.com/ships/nikolaj-zarkov/", "Николай Жарков"),
//                        new ParserUtils.ShipUrl("https://vodohod.com/ships/mustai-karim/", "Мустай Карим"),
//                        new ParserUtils.ShipUrl("https://vodohod.com/ships/rostropovich/", "Мстислав Ростропович"),
//                        new ParserUtils.ShipUrl("https://vodohod.com/ships/korotkov/", "Константин Коротков"),
//                        new ParserUtils.ShipUrl("https://vodohod.com/ships/sankt-peterburg/", "Санкт-Петербург"),
//                        new ParserUtils.ShipUrl("https://vodohod.com/ships/pushkin/", "Александр Пушкин"),
//                        new ParserUtils.ShipUrl("https://vodohod.com/ships/tolstoy/", "Лев Толстой"),
//                        new ParserUtils.ShipUrl("https://vodohod.com/ships/nnovgorod/", "Нижний Новгород"),
//                        new ParserUtils.ShipUrl("https://vodohod.com/ships/chernyshevsky/", "Николай Чернышевский"),
//                        new ParserUtils.ShipUrl("https://vodohod.com/ships/zhukov/", "Георгий Жуков"),
//                        new ParserUtils.ShipUrl("https://vodohod.com/ships/dzerzhinsky/", "Феликс Дзержинский"),
//                        new ParserUtils.ShipUrl("https://vodohod.com/ships/radishchev/", "Александр Радищев"),
//                        new ParserUtils.ShipUrl("https://vodohod.com/ships/simonov/", "Константин Симонов"),
//                        new ParserUtils.ShipUrl("https://vodohod.com/ships/frunze/", "Михаил Фрунзе"),
//                        new ParserUtils.ShipUrl("https://vodohod.com/ships/suvorov/", "Александр Суворов"),
//                        new ParserUtils.ShipUrl("https://vodohod.com/ships/kuchkin/", "Сергей Кучкин"),
//                        new ParserUtils.ShipUrl("https://vodohod.com/ships/sobolev/", "Леонид Соболев"),
//                        new ParserUtils.ShipUrl("https://vodohod.com/ships/budyonny/", "Семен Буденный"),
//                        new ParserUtils.ShipUrl("https://vodohod.com/ships/chicherin/", "Георгий Чичерин"),
//                        new ParserUtils.ShipUrl("https://vodohod.com/ships/russ/", "Русь"),
//                        new ParserUtils.ShipUrl("https://vodohod.com/ships/lenin/", "Ленин"),
//                        new ParserUtils.ShipUrl("https://vodohod.com/ships/belinsky/", "Виссарион Белинский"),
//                        new ParserUtils.ShipUrl("https://vodohod.com/ships/fedin/", "Константин Федин"),
//                        new ParserUtils.ShipUrl("https://vodohod.com/ships/kronshtadt/", "Кронштадт")
//                        ));
//        ConstellationParser.parseCruises(Arrays.asList(
//                new ParserUtils.ShipUrl("https://s-cruises.com/ships/Rossia_/", "Россия"),
//                new ParserUtils.ShipUrl("https://s-cruises.com/ships/ogni_bolshogo_goroda/", "Огни большого города"),
//                new ParserUtils.ShipUrl("https://s-cruises.com/ships/little_prince/", "Маленький принц"),
//                new ParserUtils.ShipUrl("https://s-cruises.com/ships/simfonija_severa/", "Симфония севера"),
//                new ParserUtils.ShipUrl("https://s-cruises.com/ships/lebedinoye_ozero/", "Лебединое озеро"),
//                new ParserUtils.ShipUrl("https://s-cruises.com/ships/severnaya_skazka/", "Северная сказка"),
//                new ParserUtils.ShipUrl("https://s-cruises.com/ships/nekrasov/", "Некрасов"),
//                new ParserUtils.ShipUrl("https://s-cruises.com/ships/benua/", "Бенуа")
//        ));
        ConstellationParser.parseDate("25 апр 2025");
    }
}
