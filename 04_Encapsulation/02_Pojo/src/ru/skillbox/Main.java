package ru.skillbox;

import java.lang.annotation.Target;

public class Main {

    public static void main(String[] args) {


        Country russia = new Country("Россия");
        russia.setCapital("Москва.");
        russia.setPopulation(1500000);
        russia.setAreaSea(true);
        russia.setSquare(4587263.21);
        System.out.println(russia);
        russia.printInfo();







       Table table = new Table("Стол столовый", "Белый", "Деревянный");
       Table table1 = new Table("Стол письменный", "Бежевый", "ДСП");

        System.out.println(table);
        System.out.println(table1);




    }
}
