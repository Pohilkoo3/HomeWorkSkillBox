import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Main {
    public static final String LS = System.lineSeparator();
    public static void main(String[] args) {
        int day = 31;
        int month = 12;
        int year = 1990;
        System.out.println(collectBirthdays(year, month, day));
    }

    public static String collectBirthdays(int year, int month, int day) {
        LocalDate birthday = LocalDate.of(year,month,day);
        LocalDate now = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy - EEE").localizedBy(Locale.US);
        String stringBirthday = "";
        int i = 0;
        while (birthday.isBefore(now.plusDays(1))){
            stringBirthday = stringBirthday.concat(i + " - " + formatter.format(birthday) + LS);
            i +=1;
            birthday = birthday.plusYears(1);
        } return stringBirthday;
    }
}
