package ru.skillbox;

public class Keyboard {
    public final double weight;
    public final LightKeyboard lightKeyboard;
    public final TypeKeyboard typeKeyboard;

    public Keyboard(double weight, LightKeyboard lightKeyboard, TypeKeyboard typeKeyboard) {
        this.weight = weight;
        this.lightKeyboard = lightKeyboard;
        this.typeKeyboard = typeKeyboard;
    }

    public double getWeight() {
        return weight;
    }

    public String toString(){
        return "Подсветка - " + lightKeyboard + " Тип клавиатуры - " + typeKeyboard + " Вес - " +weight;
    }



    public enum TypeKeyboard {
        MEMBRANE, SCISSOR_SWITCH, MECHANICAL
    }

    public enum LightKeyboard {
        YES,
        NO
    }
}
