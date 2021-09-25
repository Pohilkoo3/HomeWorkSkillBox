import org.w3c.dom.ls.LSOutput;

import java.util.SplittableRandom;

public class Printer {

    static int totalPages = 0;
    int pages = 0;
    String name = "";
    String text = "";
    private String queue = "";
    int pendingPagesCount = 0;



    public  Printer() {
        System.out.println("New objekt print:");

    }

    public void append(String text) {
        append(text, name);
    }

    public void append(String text, String name){
        append(text, name, 1);
    }

    public void append(String text, String name, int pages){
        queue = queue + "\n" + text + " " + name + " - " + pages + " стр." ;
        pendingPagesCount = pendingPagesCount + pages;
        totalPages = totalPages + pages;
    }
    public void getPendingPagesCount(){
        System.out.println("Распечатка для объекта " + pendingPagesCount + " стр.");
    }


    public void print(){
        if (pendingPagesCount == 0){
            System.out.println("В очереди нет документов на распечатку.");
        } else {
            System.out.println("В очереди следующие документы: " + queue);
        }
        clear();
    }

    public void clear(){
        queue = "";
        pendingPagesCount = 0;

    }






}
