public class Basket {

    private static int count = 0;
    private String items = "";
    private int totalPrice = 0;
    private int limit;
    private double totalWeight = 0;
    private static int basketTotalPrice;
    private static int basketTotalAmount;
    private int totalamount = 0;


    public Basket() {
        increaseCount(1);

        items = "Список товаров:";
        this.limit = 1000000;
    }

    public Basket(int limit) {
        this();
        this.limit = limit;

    }

    public Basket(String items, int totalPrice) {
        this();
        this.items = this.items + items;
        this.totalPrice = totalPrice;
    }

    public static int getCount() {
        return count;
    }

    public static void increaseCount(int count) {
        Basket.count = Basket.count + count;
    }

    public static void basketTotalPrice(String name, int price, int count){
        basketTotalPrice = basketTotalPrice + count * price;
    }

    public void clear() {
        items = "";
        totalWeight = 0;
        basketTotalPrice = basketTotalPrice - totalPrice;
        totalPrice = 0;
        basketTotalAmount = basketTotalAmount - totalamount;
        count--;

    }


    public static void basketTotalAmount (String name, int count){
            basketTotalAmount = basketTotalAmount + count;
    }
    public void add(String name, int price) {
        add(name, price, 1);
    }

    public void add(String name, int price, int count) {
        add(name, price, count, 0);
    }

    public void add(String name, int price, int count, double weight) {
        boolean error = false;
        if (contains(name)) {
            error = true;
        }

        if (totalPrice + count * price >= limit) {
            error = true;
        }

        if (error) {
            System.out.println("Error occured :(");
            return;
        }
        items = items + "\n" + name + " - " +
                count + " шт. - " + price + " руб./шт."  + " - " + weight + " - гр.";
        totalPrice = totalPrice + count * price;
        totalWeight = totalWeight + weight * count;
        totalamount = totalamount + count;
        basketTotalPrice(name, price, count);
        basketTotalAmount (name,count);
    }

    public static int getBasketTotalPrice(){
        return basketTotalPrice;
    }
    public static int getBasketTotalAmount(){
        return basketTotalAmount;
    }

    public static double getBasketAverageValue(){
        return (double) basketTotalPrice/basketTotalAmount;
    }
    public static double getBasketAverageTotalPrice(){
        return (double) basketTotalPrice/count;
    }

    public double getTotalWeight() {
        return totalWeight;
    }



    public int getTotalPrice() {
        return totalPrice;
    }

    public boolean contains(String name) {
        return items.contains(name);
    }

    public void print(String title) {
        System.out.println(title);
        if (items.isEmpty()) {
            System.out.println("Корзина пуста");
        } else {
            System.out.println(items);
        }
    }
}
