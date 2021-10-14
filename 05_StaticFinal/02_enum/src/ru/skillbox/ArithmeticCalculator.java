package ru.skillbox;

public class ArithmeticCalculator {
    private static int a;
    private static int b;

    public ArithmeticCalculator (int a, int b){
        this.a = a;
        this.b = b;
    }

    public void calculate(Operation operation){
        if (operation == Operation.ADD){
            System.out.println("a+b=" + (a+b));
        } else if (operation == Operation.MULTIPLY){
            System.out.println("a*b=" +(a*b));
        } else {
            System.out.println("a-b=" + (a-b));
        }
    }

}
