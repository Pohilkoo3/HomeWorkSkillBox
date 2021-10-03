package ru.skillbox;

public class Product {
        private final String name;
        private final int barCode;
        private int price;



        public Product(String name, int barCode) {
            this.name = name;
            this.barCode = barCode;
        }

        public String getName() {
            return name;
        }

        public int getPrice() {
            return price;
        }

        public int getBarCode() {
        return barCode;
        }
        public void setPrice(int price) {
        this.price = price;
        }
        public String toString(){
            return "\n" + name + " - " + "Код: " + barCode + " Цена продукта - " + price;
        }
        public void print(){
            String info = "\n" + name + " - " + " Код: " +barCode + " Цена - " + price ;
            System.out.println(info);
        }


}
