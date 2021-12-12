import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static final String WRONG_EMAIL_ANSWER = "Неверный формат email";
    private static String command = "";
    private static String nameEmail = "";
    private static final String regex = "(ADD|LIST)\\s*(.+)*";
    private static final Pattern pat = Pattern.compile(regex);

    public static void main(String[] args) {
        EmailList test = new EmailList();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("0")) {
                break;
            }
            getCommand(input);
            if (command.equals("ADD")) {
                if (test.add(nameEmail)) {
                    System.out.println("Email добавлен.");
                }else {
                    System.out.println(WRONG_EMAIL_ANSWER);
                }
            } else if (command.equals("LIST")) {
                for (String print : test.getSortedEmails()) {
                    System.out.println(print.toLowerCase());
                }
            }
        }
    }
    public static void getCommand(String input){
        Matcher mat = pat.matcher(input);
        if (mat.matches()){
            command = mat.group(1);
            nameEmail = mat.group(2);
        } else {
            return;
        }
    }
}


