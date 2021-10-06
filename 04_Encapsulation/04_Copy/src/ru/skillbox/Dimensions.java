package ru.skillbox;

public class Dimensions {
    private double height; //см.
    private double length; //см.
    private double width; // см.
    private double volume;

    public Dimensions(double height, double length, double width) {
        this.height = height;
        this.length = length;
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public void setWidth(double width) {
        this.width = width;
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
