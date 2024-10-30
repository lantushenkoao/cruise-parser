package org.example;

import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception {
//        List<String> urls = Arrays.asList(
//                "https://www.mosturflot.ru/river-cruises/?ship_id=14&date_from=01.01.2025");
//        parseMosturflotCruises("Леонид КРАСИН", urls);

//        List<String> urls = Arrays.asList(
//                "https://volgawolga.ru/kutuzov/");
//        //использовать это для конвертации русского текста https://r12a.github.io/app-conversion/
//        String shipName = "Михаил Кутузов";
//
//        parseVolgaVolgaCruises(shipName, urls);

        VodohodParser.parseVolgaVolgaCruises(
                Arrays.asList(
                        new ParserUtils.ShipUrl("https://vodohod.com/ships/nnovgorod/", "Нижний Новгород")
                        ));
//        ConstellationParser.parseCruises(Arrays.asList(
//                new ConstellationParser.ShipUrl("https://s-cruises.com/ships/lunnaya_sonata/?year=2025#cruisInfo", "Лунная соната")
//        ));
//        ConstellationParser.parseDate("25 апр 2025");
    }
}
