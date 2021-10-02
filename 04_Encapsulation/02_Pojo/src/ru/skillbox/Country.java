package ru.skillbox;

public class Country {
    private String name;
    private int population; //человек
    private double square; //площадь, кв. км.
    private String capital;
    private boolean areaSea; //По умолчанию false

    public Country(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public double getSquare() {
        return square;
    }

    public void setSquare(double square) {
        this.square = square;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public boolean isAreaSea() {
        return areaSea;
    }

    public void setAreaSea(boolean areaSea) {
        this.areaSea = areaSea;
    }



    public String toString(){
        return "\n" + "Страна: " + name + " .\n" + "Население: " + population + " человек.\nПлощадь: " + square + " кв. км. \n" +
                "Столица: " + capital + "\n" + "Выход в море: " + isAreaSea();
    }

    public void printInfo(){
        System.out.println("\n" + "Страна: " + getName() + " .\n" + "Население: " + getPopulation() + " человек.\nПлощадь: " + getSquare()+ " кв. км. \n" +
                "Столица: " + getCapital());
        if (isAreaSea() == true){
            System.out.println("Выход к морю есть.");
        }else {
            System.out.println("Выхода к морю нет.");
        }
    }



}
