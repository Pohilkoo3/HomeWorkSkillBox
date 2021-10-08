public class Main {

    public static void main(String[] args) {
        Basket basket = new Basket("колбаса", 10);
        System.out.printf("\n Средняя цена товаров во всех корзинах составляет %.2f руб./шт.",Basket.getBasketAverageValue() );
        System.out.printf("\n Средняя стоимость покупок одной корзины = %.2f руб.", Basket.getBasketAverageTotalPrice());
        clear();
    }

    public static void clear(){
        Basket basket = new Basket();
        basket.add("колбаса", 10,10);
        Basket basket1 = new Basket(500000);
        basket1.add("колеса",2000,4);
        basket1.clear();
        System.out.printf("\n Средняя цена товаров во всех корзинах составляет %.2f руб./шт.",Basket.getBasketAverageValue() );
        System.out.printf("\n Средняя стоимость покупок одной корзины = %.2f руб.", Basket.getBasketAverageTotalPrice());
    }
}
