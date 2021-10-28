import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
  private static final String ERROR = "Введенная строка не является ФИО";
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    while (true) {
      String input = scanner.nextLine();
      if (input.equals("0")) {
        break;
      }
      String regex = "[А-я\\s-]*";
      if (!Pattern.matches(regex, input)){
        System.out.println(ERROR);
        return;
      }
      String[] words = input.split("\\s+");

      if (words.length < 3) {
        System.out.println(ERROR);
        return;
      }
      System.out.println("Фамилия: " + words[0]);
      System.out.println("Имя: " + words[1]);
      System.out.println("Отчество: " + words[2]);
    }
  }
}





