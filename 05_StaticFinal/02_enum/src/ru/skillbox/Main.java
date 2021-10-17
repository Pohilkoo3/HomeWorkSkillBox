package ru.skillbox;

public class Main {

    public static void main(String[] args) {
        ArithmeticCalculator calc = new ArithmeticCalculator(2, 2);
        ArithmeticCalculator calc1 = new ArithmeticCalculator(3, 2);
        System.out.println("2 + 2 = " + calc.calculate(Operation.ADD));
        System.out.print("(3 + 2) * (12 - 6) = " +
        new ArithmeticCalculator(new ArithmeticCalculator(3, 2).calculate(Operation.ADD),
        new ArithmeticCalculator(12, 6).calculate(Operation.SUBTRACT)).calculate(Operation.MULTIPLY));
    }
}

