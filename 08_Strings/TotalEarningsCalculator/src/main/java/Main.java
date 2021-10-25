public class Main {

  public static void main(String[] args) {

    String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";
    String search = " руб";
    int stop = text.lastIndexOf(search);
    int start = text.lastIndexOf(' ', stop-1);
    String salaryMasha = text.substring(start+1,stop);
    int stopVasyl = text.indexOf(search);
    int startVasyl = text.lastIndexOf(' ',stopVasyl-1);
    String salaryVasyl =  text.substring(startVasyl,stopVasyl);
    int stopPetr = text.indexOf(search,stopVasyl+1);
    int startPetr = text.lastIndexOf(' ', stopPetr-1);
    String salaryPetr = text.substring(startPetr, stopPetr);
    System.out.println(Integer.parseInt(salaryMasha.trim()) + Integer.parseInt(salaryPetr.trim())
            + Integer.parseInt(salaryVasyl.trim()));
  }

}