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
                new ParserUtils.ShipUrl("https://www.mosturflot.ru/river-cruises/?ship_id=5&date_from=01.01.2025", "��������� ����"),
                new ParserUtils.ShipUrl("https://www.mosturflot.ru/river-cruises/?ship_id=3&date_from=01.01.2025", "������ ��������"),
                new ParserUtils.ShipUrl("https://www.mosturflot.ru/river-cruises/?ship_id=7&date_from=01.01.2025", "������ ��������"),
                new ParserUtils.ShipUrl("https://www.mosturflot.ru/river-cruises/?ship_id=2&date_from=01.01.2025", "������ ���˨�"),
                new ParserUtils.ShipUrl("https://www.mosturflot.ru/river-cruises/?ship_id=1&date_from=01.01.2025", "������ ������"),
                new ParserUtils.ShipUrl("https://www.mosturflot.ru/river-cruises/?ship_id=8&date_from=01.01.2025", "������� �������"),
                new ParserUtils.ShipUrl("https://www.mosturflot.ru/river-cruises/?ship_id=9&date_from=01.01.2025", "���� �����"),
                new ParserUtils.ShipUrl("https://www.mosturflot.ru/river-cruises/?ship_id=10&date_from=01.01.2025", "������� ��������"),
                new ParserUtils.ShipUrl("https://www.mosturflot.ru/river-cruises/?ship_id=12&date_from=01.01.2025", "�.�.������"),
                new ParserUtils.ShipUrl("https://www.mosturflot.ru/river-cruises/?ship_id=13&date_from=01.01.2025", "������ ���������"),
                new ParserUtils.ShipUrl("https://www.mosturflot.ru/river-cruises/?ship_id=14&date_from=01.01.2025", "������ ������"),
                new ParserUtils.ShipUrl("https://www.mosturflot.ru/river-cruises/?ship_id=11&date_from=01.01.2025", "�.�. ������"),
                new ParserUtils.ShipUrl("https://www.mosturflot.ru/river-cruises/?ship_id=79&date_from=01.01.2025", "������ ��������")
                ));


//        List<String> urls = Arrays.asList(
//                "https://volgawolga.ru/kutuzov/");
//        //������������ ��� ��� ����������� �������� ������ https://r12a.github.io/app-conversion/
//        String shipName = "������ �������";
//
//        parseVolgaVolgaCruises(shipName, urls);

//        VodohodParser.parseVolgaVolgaCruises(
//                Arrays.asList(
//                        new ParserUtils.ShipUrl("https://vodohod.com/ships/shashkov/", "������ ������"),
//                        new ParserUtils.ShipUrl("https://vodohod.com/ships/andropov/", "���� ��������"),
//                        new ParserUtils.ShipUrl("https://vodohod.com/ships/biryusa/", "������ (���)"),
//                        new ParserUtils.ShipUrl("https://vodohod.com/ships/gorky/", "������ �������"),
//                        new ParserUtils.ShipUrl("https://vodohod.com/ships/nikolaj-zarkov/", "������� ������"),
//                        new ParserUtils.ShipUrl("https://vodohod.com/ships/mustai-karim/", "������ �����"),
//                        new ParserUtils.ShipUrl("https://vodohod.com/ships/rostropovich/", "�������� �����������"),
//                        new ParserUtils.ShipUrl("https://vodohod.com/ships/korotkov/", "���������� ��������"),
//                        new ParserUtils.ShipUrl("https://vodohod.com/ships/sankt-peterburg/", "�����-���������"),
//                        new ParserUtils.ShipUrl("https://vodohod.com/ships/pushkin/", "��������� ������"),
//                        new ParserUtils.ShipUrl("https://vodohod.com/ships/tolstoy/", "��� �������"),
//                        new ParserUtils.ShipUrl("https://vodohod.com/ships/nnovgorod/", "������ ��������"),
//                        new ParserUtils.ShipUrl("https://vodohod.com/ships/chernyshevsky/", "������� ������������"),
//                        new ParserUtils.ShipUrl("https://vodohod.com/ships/zhukov/", "������� �����"),
//                        new ParserUtils.ShipUrl("https://vodohod.com/ships/dzerzhinsky/", "������ �����������"),
//                        new ParserUtils.ShipUrl("https://vodohod.com/ships/radishchev/", "��������� �������"),
//                        new ParserUtils.ShipUrl("https://vodohod.com/ships/simonov/", "���������� �������"),
//                        new ParserUtils.ShipUrl("https://vodohod.com/ships/frunze/", "������ ������"),
//                        new ParserUtils.ShipUrl("https://vodohod.com/ships/suvorov/", "��������� �������"),
//                        new ParserUtils.ShipUrl("https://vodohod.com/ships/kuchkin/", "������ ������"),
//                        new ParserUtils.ShipUrl("https://vodohod.com/ships/sobolev/", "������ �������"),
//                        new ParserUtils.ShipUrl("https://vodohod.com/ships/budyonny/", "����� ��������"),
//                        new ParserUtils.ShipUrl("https://vodohod.com/ships/chicherin/", "������� �������"),
//                        new ParserUtils.ShipUrl("https://vodohod.com/ships/russ/", "����"),
//                        new ParserUtils.ShipUrl("https://vodohod.com/ships/lenin/", "�����"),
//                        new ParserUtils.ShipUrl("https://vodohod.com/ships/belinsky/", "��������� ���������"),
//                        new ParserUtils.ShipUrl("https://vodohod.com/ships/fedin/", "���������� �����"),
//                        new ParserUtils.ShipUrl("https://vodohod.com/ships/kronshtadt/", "���������")
//                        ));
//        ConstellationParser.parseCruises(Arrays.asList(
//                new ParserUtils.ShipUrl("https://s-cruises.com/ships/Rossia_/", "������"),
//                new ParserUtils.ShipUrl("https://s-cruises.com/ships/ogni_bolshogo_goroda/", "���� �������� ������"),
//                new ParserUtils.ShipUrl("https://s-cruises.com/ships/little_prince/", "��������� �����"),
//                new ParserUtils.ShipUrl("https://s-cruises.com/ships/simfonija_severa/", "�������� ������"),
//                new ParserUtils.ShipUrl("https://s-cruises.com/ships/lebedinoye_ozero/", "��������� �����"),
//                new ParserUtils.ShipUrl("https://s-cruises.com/ships/severnaya_skazka/", "�������� ������"),
//                new ParserUtils.ShipUrl("https://s-cruises.com/ships/nekrasov/", "��������"),
//                new ParserUtils.ShipUrl("https://s-cruises.com/ships/benua/", "�����")
//        ));
        ConstellationParser.parseDate("25 ��� 2025");
    }
}
