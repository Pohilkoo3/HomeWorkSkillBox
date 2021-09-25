public class Main {

    public static void main(String[] args) {
        Basket basket = new Basket();
        basket.add("Milk", 40);
        basket.print("Milk");
        Basket olegBasket = new Basket(600);
        olegBasket.add("Колесо", 45,4,25);
        olegBasket.add("Гайки", 5, 100);
        olegBasket.print("Покупки Олега:");
        System.out.println("Общая стоимость покупок = " + olegBasket.getTotalPrice() + " руб.");
        System.out.println("Общий вес покупок = " + olegBasket.getTotalWeight() + " гр.");


        Arithmetic vasyua = new Arithmetic(5,6);
        vasyua.summ();
        vasyua.mult();
        vasyua.findMax();
        vasyua.findMin();

        Printer olegPrint = new Printer();
        olegPrint.append("About Volgograd", "Novel", 45);

        olegPrint.append("Мой родной дом ... конец.","Рассказ.", 10);
        olegPrint.print();
        olegPrint.getPendingPagesCount();
        Printer yanaPrinter = new Printer();
        yanaPrinter.append("Отчет можно начать .. конец.", "Отчет о продажах.", 15);
        yanaPrinter.append("Cправка выдана мне о .....");
        yanaPrinter.print();
        yanaPrinter.print();




        System.out.println("Общее количество распечатанных принтеров страниц за все время - " + Printer.totalPages);
















    }
}
