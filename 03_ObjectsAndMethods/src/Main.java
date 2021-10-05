public class Main {

    public static void main(String[] args) {

        Basket basket = new Basket();
        basket.add("колбаса", 10,10);
        basket.add("молоко",100,10);
        basket.print("Товары баскет:");
        System.out.println("Общая цена покупок баскет = " + basket.getTotalPrice() + " руб.");
        System.out.println("Цена покупок Всех КОРЗИН класса = " + Basket.getBasketTotalPrice() + " руб.");
        System.out.println("Общее количество товаров Всех КОРЗИН класса = " + Basket.getBasketTotalAmount()+ " шт.");

        Basket basket1 = new Basket(500000);
        basket1.add("колеса",2000,4);
        basket1.add("болты", 20,16);
        System.out.println();
        basket1.print("Товары баскет 1:");
        System.out.println("Общая цена покупок баскет1 = " + basket1.getTotalPrice() + " руб.");
        System.out.println("Цена покупок Всех КОРЗИН класса = " + Basket.getBasketTotalPrice() + " руб.");
        System.out.println("Общее количество товаров Всех КОРЗИН класса = " + Basket.getBasketTotalAmount() + " шт.");

        System.out.printf("\n Средняя цена товаров во всех корзинах составляет %.1f",Basket.getBasketAverageValue());
        System.out.println("\n Средняя стоимость покупок одной корзины = " + Basket.getBasketAverageTotalPrice() + " руб.");



    }
}
