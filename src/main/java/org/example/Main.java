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

        ConstellationParser.parseCruises(Arrays.asList(
                new ConstellationParser.ShipUrl("https://s-cruises.com/ships/Rossia_/", "Россия"),
                new ConstellationParser.ShipUrl("https://s-cruises.com/ships/ogni_bolshogo_goroda/", "Огни большого города"),
                new ConstellationParser.ShipUrl("https://s-cruises.com/ships/little_prince/", "Маленький принц"),
                new ConstellationParser.ShipUrl("https://s-cruises.com/ships/simfonija_severa/", "Симфония севера"),
                new ConstellationParser.ShipUrl("https://s-cruises.com/ships/lebedinoye_ozero/", "Лебединое озеро"),
                new ConstellationParser.ShipUrl("https://s-cruises.com/ships/lunnaya_sonata/", "Лунная соната"),
                new ConstellationParser.ShipUrl("https://s-cruises.com/ships/severnaya_skazka/", "Северная сказка"),
                new ConstellationParser.ShipUrl("https://s-cruises.com/ships/nekrasov/", "Н.А. Некрасов"),
                new ConstellationParser.ShipUrl("https://s-cruises.com/ships/benua/", "Александ Бенуа"),
                new ConstellationParser.ShipUrl("https://s-cruises.com/ships/imperia/", "Империя"),
                new ConstellationParser.ShipUrl("https://s-cruises.com/ships/admiral/", "Гранд Адмирал"),
                new ConstellationParser.ShipUrl("https://s-cruises.com/ships/Jaz_Crown_Jubilee/", "Crown Jubilee"),
                new ConstellationParser.ShipUrl("https://s-cruises.com/ships/Steigenberger_Omar_El_Khayam/", "Omar El Khayam"),
                new ConstellationParser.ShipUrl("https://s-cruises.com/ships/Iberotel_Amara/", "Amara"),
                new ConstellationParser.ShipUrl("https://s-cruises.com/ships/MS_Century_Paragon/", "Century Paragon ")
        ));
//        ConstellationParser.parseDate("25 апр 2025");
    }
}
