package ru.skillbox;

public class Book {
    private final String name;
    private final String author;
    private final int quantityBook;
    private final int numberISBN;

    public Book(String name, String author, int quantityBook, int numberISBN) {
        this.name = name;
        this.author = author;
        this.quantityBook = quantityBook;
        this.numberISBN = numberISBN;
    }
    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getQuantityBook() {
        return quantityBook;
    }

    public int getNumberISBN() {
        return numberISBN;
    }


    public String  toString(){
        return name + "\n" + "Автор: " + author +"\n" +  "Количество книг: " + quantityBook +"\n" + "Номер ISBN - " + numberISBN;
    }

}
