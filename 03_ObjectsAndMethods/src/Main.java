public class Main {

    public static void main(String[] args) {
        /*Basket basket = new Basket();
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
        vasyua.findMin();*/

        Printer printer1 = new Printer();
        printer1.append("Обращение");
        printer1.append("jk",10);
        printer1.append("kjhkkjgkj",15,"Заява");
        printer1.append("New");
        printer1.print();
        printer1.print();
        printer1.append("заява для проверки");
        printer1.print();
        printer1.print();
        printer1.getTotalPages();

    }
}
