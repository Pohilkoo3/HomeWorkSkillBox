import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailList {
    private final TreeSet<String> emailList = new TreeSet<>();
    public static final String WRONG_EMAIL_ANSWER = "Неверный формат email";

    public void add(String email) {
        String regex = "(.+@.+\\..+)";
        Pattern pat = Pattern.compile(regex);
        Matcher mat = pat.matcher(email);
        if (!Pattern.matches(regex, email)) {
            System.out.println(WRONG_EMAIL_ANSWER);
            return;
        }
        mat.find();
            emailList.add((mat.group(0)).toLowerCase());      // TODO: валидный формат email добавляется
        }

    public List<String> getSortedEmails() {
       return new ArrayList<>(emailList);    // TODO: возвращается список электронных адресов в алфавитном порядке
       }
}
