import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static final String regex = "(\\+*\\d{11,12})";
    private static final Pattern pattern = Pattern.compile(regex);
    private final static String save = "Контакт сохранен!";

    public static void main(String[] args) {
        PhoneBook test = new PhoneBook();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите номер, имя или команду:");
            String input = scanner.nextLine();
            Matcher matcher = pattern.matcher(input.trim());
            if (matcher.matches()) {
                if (test.checkNumber(input)) {
                    System.out.println(test.getContactByPhone(input));
                    System.out.println("Хотите перезаписать имя абонената? YES or NO");
                    String command = scanner.nextLine();
                    if (command.equals("YES")){
                        System.out.println("Введите новое имя абонента для номера " + input);
                        String rewriteName = scanner.nextLine();
                        test.addContact(input, rewriteName);
                        if (test.addContact(input, rewriteName)){
                            System.out.println(save);
                        }
                    }
                } else {
                    System.out.println("Такого номера нет в телефонной книге.");
                    System.out.println("Введите имя абонента для номера " + input + ":");
                    String name = scanner.nextLine();
                    test.addContact(input, name);
                    if (test.addContact(input, name)){
                        System.out.println(save);
                    }
                }
            } else if (input.equals("LIST")) {
                printSet(test.getAllContacts());
            } else if (input.equals("END")) {
                return;
            } else {
                if (test.checkName(input)) {
                    printSet(test.getContactByName(input));
                } else {
                    System.out.println("Такого имени в телефонной книге нет.\nВведите номер телефона для абонента " + input);
                    String numberInput = scanner.nextLine();
                        test.addContact(numberInput, input);
                        if (test.addContact(numberInput, input)) {
                            System.out.println(save);
                        } else {
                            System.out.println("Неверный формат ввода номера.");
                        }

                }
            }
        }
    }

    private static void printSet (Set<String> map){
        for (String key : map){
            System.out.println(key);
        }
    }
}