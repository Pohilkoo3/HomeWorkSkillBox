package ru.skillbox;

public class Main {

    public static void main(String[] args) {
        Book book = new Book("Считай, что ты мертв.", "Дж. Хедли Чейз", 6, 1245);
        System.out.println(book);

        Product product = new Product("Колбаса", 2134565465);
        product.setPrice(564);
        System.out.println(product);
        product.print();

    }








}
