import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<String> test = CoolNumbers.generateCoolNumbers();

        BigInteger start = new BigInteger(String.valueOf(System.currentTimeMillis()));
        BigInteger startHC = start.multiply(new BigInteger("1000000"));//Х999ХХ199
        BigInteger timeProcess = new BigInteger("0");
        if (CoolNumbers.bruteForceSearchInList(test, "Х999ХХ199")) {
            BigInteger stop = new BigInteger(String.valueOf(System.currentTimeMillis()));
            BigInteger stopHC = stop.multiply(new BigInteger("1000000"));
            timeProcess = stopHC.subtract(startHC);
            System.out.println("Поиск перебором: номер найден, поиск занял " + timeProcess + " наносекунд");
        } else {
            System.out.println("Поиск перебором: номер не найден, поиск занял " + timeProcess + " наносекунд");
        }

        Collections.sort(test);
        BigInteger start1 = new BigInteger(String.valueOf(System.currentTimeMillis()));
        BigInteger startHC1 = start1.multiply(new BigInteger("1000000"));
        BigInteger timeProcess1 = new BigInteger("0");
        if (CoolNumbers.binarySearchInList(test, "Х999ХХ199")) {
            BigInteger stop1 = new BigInteger(String.valueOf(System.currentTimeMillis()));
            BigInteger stopHC1 = stop1.multiply(new BigInteger("1000000"));
            timeProcess1 = stopHC1.subtract(startHC1);
            System.out.println("Бинарный поиск: номер найден, поиск занял "  + timeProcess1 + " наносекунд");
        }else {
            System.out.println("Бинарный поиск: номер не найден, поиск занял " + timeProcess1 + " наносекунд");
        }

        HashSet<String> copyHash = new HashSet<>(test);
        BigInteger start2 = new BigInteger(String.valueOf(System.currentTimeMillis()));
        BigInteger startHC2 = start2.multiply(new BigInteger("1000000"));
        BigInteger timeProcess2 = new BigInteger("0");
        if (CoolNumbers.searchInHashSet(copyHash, "Х999ХХ199")) {
            BigInteger stop2 = new BigInteger(String.valueOf(System.currentTimeMillis()));
            BigInteger stopHC2 = stop2.multiply(new BigInteger("1000000"));
            timeProcess2 = stopHC2.subtract(startHC2);
            System.out.println("Поиск в HashSet: номер найден, поиск занял "  + timeProcess2 + " наносекунд");
        }else {
            System.out.println("Поиск в HashSet: номер не найден, поиск занял " + timeProcess2 + " наносекунд");
        }

        TreeSet<String> copyTreeSet = new TreeSet<>(test);
        BigInteger start3 = new BigInteger(String.valueOf(System.currentTimeMillis()));
        BigInteger startHC3 = start3.multiply(new BigInteger("1000000"));
        BigInteger timeProcess3 = new BigInteger("0");
        if (CoolNumbers.searchInTreeSet(copyTreeSet, "Х999ХХ199")) {
            BigInteger stop3 = new BigInteger(String.valueOf(System.currentTimeMillis()));
            BigInteger stopHC3 = stop3.multiply(new BigInteger("1000000"));
            timeProcess3 = stopHC3.subtract(startHC3);
            System.out.println("Поиск в TreeSet: номер найден, поиск занял "  + timeProcess3 + " наносекунд");
        }else {
            System.out.println("Поиск в TreeSet: номер не найден, поиск занял " + timeProcess3 + " наносекунд");
        }




    }
}
   /*
    TODO:
     - реализовать методы класса CoolNumbers
     - посчитать время поиска введимого номера в консоль в каждой из структуры данных
     - проанализоровать полученные данные
     */