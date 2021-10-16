package ru.skillbox;

public class Processor {
    private final Core core;
    private final Frequency frequency;
    private final VendorCPU vendorCPU;
    private final double weight;

    public Processor(Core core, Frequency frequency, VendorCPU vendorCPU, double weight) {
        this.core = core;
        this.frequency = frequency;
        this.vendorCPU =vendorCPU;
        this.weight = weight;
    }
    public String toString(){
        return "Ядро - " + core + " Частота - " + frequency + " Производитель - " + vendorCPU + " Вес - " + weight;
    }

    public double getWeight() {
        return weight;
    }

    public enum Frequency {
        CPU600, CPU800, CPU1200, CPU1400
    }

    public enum VendorCPU {
        SAMSUNG, APPLE, LENOVA
    }

    public enum Core {
    CORE2, CORE4, CORE6, CORE8
    }
}
