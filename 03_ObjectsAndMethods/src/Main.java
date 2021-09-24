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

    }
}
