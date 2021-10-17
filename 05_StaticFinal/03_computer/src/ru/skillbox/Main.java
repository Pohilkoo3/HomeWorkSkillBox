package ru.skillbox;

public class Main {

    public static void main(String[] args) {

        Processor processorApple = new Processor(Processor.Core.CORE4, Processor.Frequency.CPU1200, Processor.VendorCPU.APPLE,569);
        Processor processorLenovo = new Processor(Processor.Core.CORE8, Processor.Frequency.CPU1400, Processor.VendorCPU.LENOVA,
                123);
        RAM ram1 = new RAM(RAM.VolumeRam.R2000, RAM.TypeRAM.DDR3,564);
        HardDisk hardDiskApple = new HardDisk(56, HardDisk.VolumeHardDisk.GB1000, HardDisk.TypeHardDisk.SSD);
        Monitor monitorSamsung = new Monitor(890, Monitor.TypeScreen.TN, Monitor.SizeScreen.S21);
        Keyboard keyboardPerfeo = new Keyboard(125, Keyboard.LightKeyboard.NO, Keyboard.TypeKeyboard.MECHANICAL);
        Computer computerOleg = new Computer("IBM","Игровой компьютер.",processorApple,ram1,hardDiskApple,monitorSamsung,
                keyboardPerfeo);
        System.out.println(computerOleg);
        System.out.println("Общий вес всех комплектующих: " + computerOleg.getTotalWeight() + " гр.");
        computerOleg.setProcessor(processorLenovo);
        System.out.println(computerOleg);
        System.out.println("Общий вес всех комплектующих: " + computerOleg.getTotalWeight() + " гр.");





    }
}
