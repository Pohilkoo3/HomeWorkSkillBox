package ru.skillbox;

public class Cargo {
    private final String regNumber; // регистрационный номер (может содержать буквы)
    private final Dimensions dimensions;   // габариты
    private final double mass; // масса
    private final String address; // адрес доставки
    private final boolean twist; // свойство — можно ли переворачивать
    private final boolean isFragile; // является ли груз хрупким.

    public Cargo(String regNumber, Dimensions dimensions, double mass, String address, boolean twist, boolean isFragile) {
        this.regNumber = regNumber;
        this.dimensions = dimensions;
        this.mass = mass;
        this.address = address;
        this.twist = twist;
        this.isFragile = isFragile;
    }


    public Cargo setRegNumber(String regNumber) {
        return new Cargo(regNumber, dimensions, mass, address, twist, isFragile);
    }
    public Cargo setTwist(boolean twist) {
        return new Cargo(regNumber, dimensions, mass, address, twist, isFragile);
    }

    public Cargo setFragile(boolean fragile) {
        return new Cargo(regNumber, dimensions, mass, address, twist, fragile);
    }
    public Cargo setDimensions(Dimensions dimensions) {
        return new Cargo(regNumber, dimensions, mass, address, twist, isFragile);
    }

    public Cargo setMass(double mass) {
        return new Cargo(regNumber, dimensions, mass, address, twist, isFragile);
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
        return new Cargo(regNumber, dimensions, mass, address, twist, isFragile);
    }

    public boolean isTwist() {
        return twist;
    }



    public boolean isFragile() {
        return isFragile;
    }


    public String toString(){
        return "\n №: " + getRegNumber() + " Масса = " + getMass() + " Адресс: " + getAddress() + " Только вертикально:" +
                isTwist() + " Хрупко: " + isFragile() + "\n Размеры: " + dimensions;


    }


}
