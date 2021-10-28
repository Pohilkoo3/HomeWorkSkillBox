import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

  public static void main(String[] args) {
    System.out.println(calculateSalarySum("Коля заработал 50000 рублей, Федя - 45800 рубля, а Саша - 23000 рублей"));
  }

  public static int calculateSalarySum(String text) {
    String regex = "([0-9]+)\\sруб";
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(text);

    int totalSalary = 0;
    while (matcher.find()) {
      int start = matcher.start();
      int end = matcher.end();
      int salaryInt = Integer.parseInt((text.substring(start, end-3)).trim());
      totalSalary += salaryInt;
    }
    return totalSalary;
  }
}