package ru.skillbox;

public class Country {


    private String name;
    private int population; //человек
    private double square; //площадь, кв. км.
    private String capital;
    private String areaSea; //Да или нет.

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

    public String isSea() {
        return areaSea;
    }

    public void setSea(String sea) {
        this.areaSea = sea;
    }

    public String toString(){
        return "Страна: " + name + " .\n" + "Население: " + population + " человек.\nПлощадь: " + square + " кв. км. \n" +
                "Столица: " + capital + ".\n" + "Выход в море: " + areaSea;
    }









}
