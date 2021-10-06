package ru.skillbox;

public class Main {

    public static void main(String[] args) {
        Dimensions dimensions = new Dimensions(15,25,35);
        Cargo oleg = new Cargo("a12345678", dimensions,654.23,"volgograd", false,true);
        System.out.println(oleg);
        Dimensions dimensions2 = new Dimensions(15.00,15.00,15.00);

        Cargo copy = new Cargo(oleg.getRegNumber(), dimensions2,000,"Москва", oleg.isTwist(), oleg.isFragile());
        System.out.println(copy); // создаю копию с измененной массой, адресом доставки, и размерами.
        dimensions2.setLength(50);//поменял длину  dimensions2 с помощью сеттеров в Dimensions
        dimensions2.setWidth(50);//поменял ширину dimensions2 с помощью сеттеров в Dimensions
        dimensions2.setHeight(50);//поменял высоту dimensions2 с помощью сеттеров в Dimensions
        System.out.println(dimensions2); //посмотрел изменение размеров в dimensions2


        System.out.println("Новые размеры копии проверка " + copy);



        System.out.println(oleg); //проверяю первый объект oleg. Он не изменился.


    }
}
