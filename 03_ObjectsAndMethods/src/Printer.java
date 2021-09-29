import org.w3c.dom.ls.LSOutput;

import java.util.SplittableRandom;

public class Printer {

    static int totalPages = 0;
    private String queue = "";
    int pendingPagesCount = 0;



    public  Printer() {
        System.out.println("New objekt print:");
    }

    public void append(String text) { //в первом методе мы теперь, имеем возможность распечатать только текст
        append(text,1);
    }

    public void append(String text, int pages){ //во втором методе мы теперь, имеем возможность распечатать текст и
        //определить количество страниц, одна страница будет по умолчанию (меньше ведь быть не может).
        append(text, "",1 );
    }

    public void append(String text, String name, int pages){ //здесь можем заполнить текст, имя документа и количество страниц
        queue = queue + "\n" + text + " " + name + " - " + pages + " стр." ;
        pendingPagesCount = pendingPagesCount + pages;
    }

    public void getPendingPagesCount(){
        System.out.println("Распечатка для объекта " + pendingPagesCount + " стр.");
    }

    public static void getTotalPages(){
        System.out.println("Тест принтера. Распечатано " + totalPages + " стр.");
    }


    public void print(){
        if (pendingPagesCount == 0){
            System.out.println("В очереди нет документов на распечатку.");
        } else {
            System.out.println("В очереди следующие документы: " + queue);
        }

        totalPages = totalPages + pendingPagesCount;
        clear();
    }

    public void clear(){
        queue = "";
        pendingPagesCount = 0;

    }







}
