import java.time.LocalDate;
import java.time.Period;

public class Main {
  private static final LocalDate BIRTHDAY_JAVA = LocalDate.of(1995, 5,23);
  public static void main(String[] args) {
    System.out.println(getPeriodFromBirthday(BIRTHDAY_JAVA));
  }

  private static String getPeriodFromBirthday(LocalDate birthday) {
    Period period = Period.between(birthday, LocalDate.now());
    int daysFromBirthday = period.getDays();
    int monthsFromBirthday = period.getMonths();
    int yearsFromBirthday = period.getYears();
    return  yearsFromBirthday + " years, " + monthsFromBirthday + " months, " +  daysFromBirthday + " days";
    }
}
