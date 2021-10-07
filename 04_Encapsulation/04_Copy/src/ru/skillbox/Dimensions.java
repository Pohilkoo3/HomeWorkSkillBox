package ru.skillbox;

public class Dimensions {
    private final double height; //см.
    private final double length; //см.
    private final double width; // см.
    private double volume;

    public Dimensions(double height, double length, double width) {
        this.height = height;
        this.length = length;
        this.width = width;
    }

    public Dimensions setHeight(double height) {
        return new Dimensions(height, length, width);
    }

    public Dimensions setLength(double length) {
        return new Dimensions(height, length,width);
    }

    public Dimensions setWidth(double width) {
        return new Dimensions(height, length,width);
    }


    public double getHeight() {
        return height;
    }


    public double getLength() {
        return length;
    }


    public double getWidth() {
        return width;
    }


    public double getVolume(){
        volume = height * width * length; //см.
        return volume;
    }

    public String toString(){
        return "Длина: " + getLength() + " Высота: " + getHeight() + " Ширина: " + getWidth() + " Объем: " + getVolume();
    }
}
