public class Main {
    public static void main(String[] args) {
        //Распечатайте сгенерированный в классе TwoDimensionalArray.java двумерный массив

        for (char[] print : TwoDimensionalArray.getTwoDimensionalArray(7)){
            System.out.println(print);
        }
    }
}
