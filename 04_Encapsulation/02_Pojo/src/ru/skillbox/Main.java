package ru.skillbox;

public class Main {

    public static void main(String[] args) {

       Country russia = new Country("Россия");
       russia.setPopulation(150000000);
       russia.setSea(true);
        System.out.println("Наименование " + russia.getName() + "\n" + "Население " + russia.getPopulation() + "\n" + "Выход в море " +
                russia.isSea());


    }
}
