package ru.skillbox;

public class Main {

    public static void main(String[] args) {
        Dimensions dimensions = new Dimensions(15,25,35);
        Cargo oleg = new Cargo("a12345678", dimensions,654.23,"volgograd", false,true);
        System.out.println(oleg);

        Dimensions copyDimensions = new Dimensions(dimensions.getHeight(),500,dimensions.getWidth());//создаю копию Dimencions
        // c измененной длиной груза
        Cargo copyCargoOleg = new Cargo(oleg.getRegNumber(), copyDimensions,1200,"Москва",
                oleg.isTwist(), oleg.isFragile()); // создаю копию с измененной массой, адресом доставки, и размерами.
        System.out.println(copyCargoOleg);




        System.out.println(oleg); //проверяю первый объект oleg. Он не изменился.


    }
}
