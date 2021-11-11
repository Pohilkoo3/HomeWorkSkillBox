import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailList {
    private final TreeSet<String> emailList = new TreeSet<>();
    private static final String regex = "(.+@.+\\..+)";
    private static final Pattern pat = Pattern.compile(regex);

    public boolean add(String email) {
        Matcher matcherEmail = pat.matcher(email);
        if (matcherEmail.matches()) {
            emailList.add(email.toLowerCase());
            return true;// TODO: валидный формат email добавляется
        }return false;
    }

    public List<String> getSortedEmails() {
        return new ArrayList<>(emailList);    // TODO: возвращается список электронных адресов в алфавитном порядке
    }
}