import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    while (true) {
      String input = scanner.nextLine();
      for (int i = 0; i < input.length(); i++){
       if (Character.isDigit(input.charAt(i))) {
          if(input.charAt(i) != ' ' || input.charAt(i) != '-' ){
              System.out.println("Введенная строка не является ФИО");
              return;
            }
        }
      }
      int stopSurname = input.indexOf(" ");
      int startMiddleName = input.lastIndexOf(' ');
      if (stopSurname < 0 || startMiddleName < 0){
        System.out.println("Введенная строка не является ФИО");
        break;
      }
      String surname = input.substring(0,stopSurname);
      String middleName = input.substring(startMiddleName + 1);
      String name = (input.substring(stopSurname,startMiddleName)).trim();
      int searchNewSpaces = name.indexOf(' ');
      if (name.isEmpty() || searchNewSpaces > 0){
        System.out.println("Введенная строка не является ФИО");
        break;
      }
      System.out.println("Фамилия: " + surname);
      System.out.println("Имя: " + name);
      System.out.println("Отчество: " + middleName);
      break;
    }
  }
}