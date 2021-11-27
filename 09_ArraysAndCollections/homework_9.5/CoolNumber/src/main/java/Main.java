
import java.util.*;

public class Main {
    public static void main (String[]args){
        List<String> test = CoolNumbers.generateCoolNumbers();

        for (;;) {
            System.out.println("Введите искомый номер. Для прекращения поиска введите команду END");
            String search = new Scanner(System.in).nextLine();
            if (search.equals("END")){
                return;
            }
            long start = System.nanoTime();
            String result = CoolNumbers.bruteForceSearchInList(test, search) ? "" : "не ";
            System.out.println("Поиск перебором: номер " + result + "найден, поиск занял " + (System.nanoTime() - start) +
                    " наносекунд");

            Collections.sort(test);
            long start1 = System.nanoTime();
            String result1 = CoolNumbers.binarySearchInList(test, search) ? "" : "не ";
            System.out.println("Бинарный поиск: номер " + result1 + "найден, поиск занял " + (System.nanoTime() - start1) +
                    " наносекунд");

            HashSet<String> copyHash = new HashSet<>(test);
            long start2 = System.nanoTime();
            String result2 = CoolNumbers.searchInHashSet(copyHash, search) ? "" : "не ";
            System.out.println("Поиск в HashSet: номер " + result2 + "найден, поиск занял " + (System.nanoTime() - start2) +
                    " наносекунд");

            TreeSet<String> copyTreeSet = new TreeSet<>(test);
            long start3 = System.nanoTime();
            String result3 = CoolNumbers.searchInTreeSet(copyTreeSet, search) ? "" : "не ";
            System.out.println("Поиск в TreeSet: номер " + result3 + "найден, поиск занял " + (System.nanoTime() - start3) +
                    " наносекунд");
        }
    }
}

