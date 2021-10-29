import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    while (true) {
      String input = scanner.nextLine();
      if (input.equals("0")) {
        break;
      }
      String clearNumber = input.replaceAll("[^0-9]","");
      if (clearNumber.length() == 10){
        clearNumber = "7" + clearNumber;
      }
      String regex = "[7,8][9][0-9]{8,9}";
      if (!Pattern.matches(regex,clearNumber)) {
        System.out.println("Неверный формат номера");
        return;
      }String rightNumber ="7".concat(clearNumber.substring(1));
      System.out.println(rightNumber);
    }
  }
}
