package ru.skillbox;

public class RAM {
    private final VolumeRam volumeRam;
    private final TypeRAM typeRAM;
    private final double weight;

    public RAM(VolumeRam volumeRam, TypeRAM typeRAM, double weight) {
        this.volumeRam = volumeRam;
        this.typeRAM = typeRAM;
        this.weight = weight;
    }
    public String toString(){
        return "Объем памяти - " + volumeRam + " Тип памяти - " + typeRAM + " Вес - " + weight;
    }

    public double getWeight() {
        return weight;
    }

    public enum TypeRAM {
        DDR, DDR2, DDR3, DDR4
    }

    public enum VolumeRam {
       R500, R1000, R2000, R3000

    }
}
