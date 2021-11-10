import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    private static String command = "";
    private static String nameEmail = "";
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
                test.add(nameEmail);
            } else if (command.equals("LIST")) {
                for (String print : test.getSortedEmails()) {
                    System.out.println(print.toLowerCase());
                }
            }
        }
    }
 public static void getCommand(String input){
        String regex = "(ADD|LIST)\\s*(.+@.+\\..+)*";
        Pattern pat = Pattern.compile(regex);
        Matcher mat = pat.matcher(input);
        if (!Pattern.matches(regex, input)){
            return;
        } else {
            mat.find();
            command = mat.group(1);
            nameEmail = mat.group(2);
        }
    }
}

