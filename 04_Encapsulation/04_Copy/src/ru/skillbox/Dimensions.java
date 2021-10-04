package ru.skillbox;

public class Dimensions {
    private final double height; //см.
    private final  double lenght; //см.
    private final  double width; // см.

    public Dimensions(double height, double lenght, double width) {
        this.height = height;
        this.lenght = lenght;
        this.width = width;
    }

    public double getHeight() {
        return height;
    }


    public double getLenght() {
        return lenght;
    }


    public double getWidth() {
        return width;
    }


    public double getVolume(){
        double volume = height * width * lenght; //см.
        return volume;
    }

    public String toString(){
        return "Длина: " + getLenght() + " Высота: " + getHeight() + " Ширина: " + getWidth() + " Объем: " + getVolume();
    }
}
