package ru.skillbox;

public class Monitor {
   public final double weight;
   public final TypeScreen typeScreen;
   public final SizeScreen sizeScreen;

    public Monitor(double weight, TypeScreen typeScreen, SizeScreen sizeScreen) {
        this.weight = weight;
        this.typeScreen = typeScreen;
        this.sizeScreen = sizeScreen;
    }
    public String toString(){
        return "Размер экрана - " + sizeScreen + " Тип монитора - " + typeScreen + " Вес - " +weight;
    }

    public double getWeight() {
        return weight;
    }

    public enum TypeScreen {
        IPS, TN, VA
    }

    public enum SizeScreen {
        S24, S21, S27, S32
    }
}
