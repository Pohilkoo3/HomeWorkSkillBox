import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

  public static void main(String[] args) {
    System.out.println(calculateSalarySum("Никто ничего не заработал"));
  }

  public static int calculateSalarySum(String text) {
    String regex = "[\\s]{1,2}[0-9]{2,7}[\\s]{1,2}";
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(text);

    int totalSalary = 0;
    while (matcher.find()) {
      int start = matcher.start();
      int end = matcher.end();
      int salaryInt = Integer.parseInt((text.substring(start, end)).trim());
      totalSalary += salaryInt;
    }
    return totalSalary;
  }
}