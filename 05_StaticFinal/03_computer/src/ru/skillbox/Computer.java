package ru.skillbox;

public class Computer {
    public final Processor processor;
    public final RAM ram;
    public final HardDisk hardDisk;
    public final Monitor monitor;
    public final Keyboard keyboard;
    public final String vendor; //продавец
    public final String name; //название компьютера


    public Computer(String vendor, String name,Processor processor, RAM ram, HardDisk hardDisk, Monitor monitor,
                    Keyboard keyboard) {
        this.processor = processor;
        this.ram = ram;
        this.hardDisk = hardDisk;
        this.monitor = monitor;
        this.keyboard = keyboard;
        this.vendor = vendor;
        this.name = name;
    }

    public Computer setProcessor(Processor processor) {
        return new Computer(vendor, name, processor, ram, hardDisk, monitor, keyboard);
    }

    public Computer setRam(RAM ram) {
        return new Computer(vendor, name, processor, ram, hardDisk, monitor, keyboard);
    }

    public Computer setHardDisk(HardDisk hardDisk) {
        return new Computer(vendor, name, processor, ram, hardDisk, monitor, keyboard);
    }

    public Computer setMonitor(Monitor monitor) {
        return new Computer(vendor, name, processor, ram, hardDisk, monitor, keyboard);
    }

    public Computer setKeyboard(Keyboard keyboard) {
        return new Computer(vendor, name, processor, ram, hardDisk, monitor, keyboard);
    }

    public Processor getProcessor() {
        return processor;
    }

    public RAM getRam() {
        return ram;
    }

    public HardDisk getHardDisk() {
        return hardDisk;
    }

    public Monitor getMonitor() {
        return monitor;
    }

    public Keyboard getKeyboard() {
        return keyboard;
    }

    public String getVendor() {
        return vendor;
    }

    public String getName() {
        return name;
    }

    public String toString(){
        return "Производитель: " + vendor + ". Название компьютера - " + name + "\n Комплектующие:\n Процессор: " +
                processor + "\n Оперативная память: " + ram + "\n Жесткий диск: " + hardDisk + "\n Монитор: " +
                monitor + "\n Клавиатура: " + keyboard;
    }

    public double getTotalWeight(){
        double totalWeightComputer = processor.getWeight() + ram.getWeight() + monitor.getWeight() + keyboard.getWeight() +
                hardDisk.getWeight();
        return totalWeightComputer;
    }



}
