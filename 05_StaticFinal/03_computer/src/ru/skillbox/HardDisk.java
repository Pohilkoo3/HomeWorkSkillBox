package ru.skillbox;

public class HardDisk {
    public final double weight;
    public final VolumeHardDisk volumeHardDisk;
    public final TypeHardDisk typeHardDisk;

    public HardDisk(double weight, VolumeHardDisk volumeHardDisk, TypeHardDisk typeHardDisk) {
        this.weight = weight;
        this.volumeHardDisk = volumeHardDisk;
        this.typeHardDisk = typeHardDisk;
    }

    public String toString(){
        return "Объем памяти - " + volumeHardDisk + " Тип жесткого диска - " + typeHardDisk + " Вес - " +weight;
    }

    public double getWeight() {
        return weight;
    }

    public enum VolumeHardDisk {
        GB1000, GB500, GB2000
    }

    public enum TypeHardDisk {
    HDD, SSD, SSHD
    }
}
