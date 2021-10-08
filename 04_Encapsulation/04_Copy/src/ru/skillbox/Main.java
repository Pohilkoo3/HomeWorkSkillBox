package ru.skillbox;

public class Main {

    public static void main(String[] args) {
        Dimensions dimensions = new Dimensions(15,25,35);
        Cargo oleg = new Cargo("a12345678", dimensions,654.23,"Москва", false,true);
        System.out.println(oleg);

        Dimensions copyDimensions = new Dimensions(dimensions.getHeight(), dimensions.getLength(),
                dimensions.getWidth());//создаю полную копию Dimencions
        copyDimensions = copyDimensions.setHeight(100);
        copyDimensions = copyDimensions.setLength(100);
        copyDimensions = copyDimensions.setWidth(100);
        Cargo copyCargoOleg = new Cargo(oleg.getRegNumber(), copyDimensions, oleg.getMass(), oleg.getAddress(),
                oleg.isTwist(), oleg.isFragile());
        copyCargoOleg = copyCargoOleg.setAddress("Волгоград");
        copyCargoOleg = copyCargoOleg.setMass(1000.00);
        System.out.println(copyCargoOleg);


        System.out.println(oleg); //проверяю первый объект oleg. Он не изменился.
    }
}
