package ru.skillbox;

public class Country {


    private String name;
    private int population; //человек
    private double square; //площадь, кв. км.
    private String capital;
    private boolean sea; //если тру, то есть выход в море, если false, то нет.

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

    public boolean isSea() {
        return sea;
    }

    public void setSea(boolean sea) {
        this.sea = sea;
    }









}
