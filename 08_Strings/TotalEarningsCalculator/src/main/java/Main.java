public class Main {

  public static void main(String[] args) {

    String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";

    String search = " руб";
    int totalSalary = 0;
    int startSearch = 0;
    while (text.indexOf(search,startSearch) != -1){
      int stop = text.indexOf(search, startSearch);
      if (Character.isDigit(text.charAt(stop-1))){
        int start = text.lastIndexOf(' ', stop-1);
        int salary = getCountSalary((text.substring(start,stop)).trim());
        totalSalary += salary;
        startSearch = stop + 1;
      }
    } System.out.println(totalSalary);
  }

  public static int getCountSalary(String checkSalary){
    StringBuilder rightSalary = new StringBuilder();
    for (int i = checkSalary.length(); i > 0; i--) {
      if (Character.isDigit(checkSalary.charAt(i-1))) {
        rightSalary.append(checkSalary.charAt(i-1));
      } else {
        return 0; //  return 0;
      }
    }
    return Integer.parseInt(String.valueOf(rightSalary.reverse()));
  }
}