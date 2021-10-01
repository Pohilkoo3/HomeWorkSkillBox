package ru.skillbox;

import java.lang.annotation.Target;

public class Main {

    public static void main(String[] args) {

       Country russia = new Country("Россия");
       russia.setPopulation(150000000);
       russia.setSea("Да");
       russia.setCapital("Москва");

        System.out.println(russia);

        Table table = new Table("Белый", "Дерево");// проверка для стола
        System.out.println("Цвет стола " + table.getColorTable());



    }
}
