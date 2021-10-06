package ru.skillbox;

public class Cargo {
    private final String regNumber; // регистрационный номер (может содержать буквы)
    private final Dimensions dimensions;   // габариты
    private final double mass; // масса
    private final String address; // адрес доставки
    private final boolean twist; // свойство — можно ли переворачивать
    private final boolean fragile; // является ли груз хрупким.

    public Cargo(String regNumber, Dimensions dimensions, double mass, String address, boolean twist, boolean fragile) {
        this.regNumber = regNumber;
        this.dimensions = dimensions;
        this.mass = mass;
        this.address = address;
        this.twist = twist;
        this.fragile = fragile;
    }


    public Cargo setRegNumber(String regNumber) {
        return new Cargo(regNumber, dimensions, mass, address, twist, fragile);
    }
    public Cargo setTwist(boolean twist) {
        return new Cargo(regNumber, dimensions, mass, address, twist, fragile);
    }

    public Cargo setFragile(boolean fragile) {
        return new Cargo(regNumber, dimensions, mass, address, twist, fragile);
    }
    public Cargo setDimensions(Dimensions dimensions) {
        return new Cargo(regNumber, dimensions, mass, address, twist, fragile);
    }

    public Cargo setMass(double mass) {
        return new Cargo(regNumber, dimensions, mass, address, twist, fragile);
    }
    public String getRegNumber() {
        return regNumber;
    }

    public double getMass() {
        return mass;
    }

    public Dimensions getDimensions() {
        return dimensions;
    }
    public String getAddress() {
        return address;
    }

    public Cargo setAddress(String address) {
        return new Cargo(regNumber, dimensions, mass, address, twist, fragile);
    }

    public boolean isTwist() {
        return twist;
    }



    public boolean isFragile() {
        return fragile;
    }


    public String toString(){
        return "\n №: " + getRegNumber() + " Масса = " + getMass() + " Адресс: " + getAddress() + " Только вертикально:" +
                isTwist() + " Хрупко: " + isFragile() + "\n Размеры: " + dimensions;


    }


}
