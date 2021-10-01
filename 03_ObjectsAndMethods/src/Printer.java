import org.w3c.dom.ls.LSOutput;

import java.util.SplittableRandom;

public class Printer {

    private int totalPages = 0;
    private String queue = "";
    private int pendingPagesCount;


    public void append(String text) { //в первом методе мы теперь, имеем возможность распечатать только текст
        append(text,1);
    }

    public void append(String text, int pages){ //во втором методе мы теперь, имеем возможность распечатать текст и
        //определить количество страниц.
        append(text, pages, "");
    }

    public void append(String text, int pages, String name){ //здесь можем заполнить текст, имя документа и количество страниц
        queue = queue + "\n" + text + " " + name + " - " + pages + " стр." ;
        pendingPagesCount = pendingPagesCount + pages;
    }

        public int getPendingPagesCount(){
        return pendingPagesCount;
        }

    public void print(){ //метод распечатки, печатает отправленные страницы и очищает очередь печати.
        if (pendingPagesCount == 0){
            System.out.println("В очереди нет документов на распечатку.");
            return;
        } else {
            System.out.println("В очереди следующие документы: " + queue);
        }
        System.out.println("Распечатана " + getPendingPagesCount() + " стр.");
        totalPages = totalPages + pendingPagesCount;

        clear();
    }

    public int getTotalPages(){ //Метод для вывода информации о количестве страниц, распечатанных принтером
        System.out.printf("Всего принтером распечатано %d страниц.\n", totalPages);
        return totalPages;
    }
    public void clear(){
        queue = "";
        pendingPagesCount = 0;

    }

}
