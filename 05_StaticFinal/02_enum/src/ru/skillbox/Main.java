package ru.skillbox;

public class Main {

    public static void main(String[] args) {
      System.out.print("(3 + 2) * (12 - 6) = " +
      new ArithmeticCalculator(new ArithmeticCalculator(3, 2).calculate(Operation.ADD),
      new ArithmeticCalculator(12, 6).calculate(Operation.SUBTRACT)).calculate(Operation.MULTIPLY));
    }
}

