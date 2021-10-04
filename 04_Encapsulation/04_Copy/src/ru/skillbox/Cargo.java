package ru.skillbox;

public class Cargo {
    private final String regNumber; // регистрационный номер (может содержать буквы)
    private Dimensions dimensions;   // габариты
    private double massa; // масса
    private String adress; // адрес доставки
    private final boolean twist; // свойство — можно ли переворачивать
    private final boolean fragil ; // является ли груз хрупким.

    public Cargo(String regNumber, Dimensions dimensions, double massa, String adress, boolean twist, boolean fragil) {
        this.regNumber = regNumber;
        this.dimensions = dimensions;
        this.massa = massa;
        this.adress = adress;
        this.twist = twist;
        this.fragil = fragil;
    }


    public Cargo setRegNumber(String regNumber) {
        return new Cargo(regNumber, dimensions, massa, adress, twist, fragil);
    }
    public Cargo setTwist(boolean twist) {
        return new Cargo(regNumber, dimensions, massa, adress, twist, fragil);
    }

    public Cargo setFragil(boolean fragil) {
        return new Cargo(regNumber, dimensions, massa, adress, twist, fragil);
    }
    public void setDimensions(Dimensions dimensions) {
        this.dimensions = dimensions;
    }

    public void setMassa(double massa) {
        this.massa = massa;
    }
    public String getRegNumber() {
        return regNumber;
    }

    public double getMassa() {
        return massa;
    }

    public Dimensions getDimensions() {
        return dimensions;
    }
    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public boolean isTwist() {
        return twist;
    }



    public boolean isFragil() {
        return fragil;
    }


    public String toString(){
        return "\n №: " + getRegNumber() + " Масса = " + getMassa() + " Адресс: " + getAdress() + " Только вертикально:" +
                isTwist() + " Хрупко: " + isFragil() + "\n Размеры: " + dimensions;


    }


}
