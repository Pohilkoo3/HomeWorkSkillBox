package ru.skillbox;

public class Main {

    public static void main(String[] args) {
        Dimensions dimensions = new Dimensions(15,25,35);
        Cargo oleg = new Cargo("a12345678", dimensions,654.23,"volgograd", false,true);
        System.out.println(oleg);
        Dimensions dimensions2 = new Dimensions(15.00,15.00,15.00);

        Cargo copy = new Cargo(oleg.getRegNumber(), dimensions2,000,"Москва", oleg.isTwist(), oleg.isFragil());
        System.out.println(copy); // создаю копию с измененной массой, адресом доставки, и размерами.

        System.out.println(oleg); //проверяю первый объект oleg. Он не изменился.

    }
}
