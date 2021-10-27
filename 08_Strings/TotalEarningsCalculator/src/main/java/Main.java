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
        int  salary = Integer.parseInt((text.substring(start,stop)).trim());
        totalSalary += salary;
        startSearch = stop + 1;
      }
    } System.out.println(totalSalary);
  }

}