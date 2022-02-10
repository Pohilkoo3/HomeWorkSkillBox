import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.*;


public class Main {
    private static Logger logger = LogManager.getRootLogger();
    public static void main(String[] args) {
       Bank bank = new Bank();
        for (int i = 1; i < 10; i++) {
            Account account = new Account();
            String accNumber = String.valueOf(i);
            account.setAccNumber(accNumber);
            account.setMoney((int) (Math.random()*((100_000 - 10_000) + 1)) + 10_000);
            bank.putNewAccount(accNumber, account);
        }

        List<Account> accountList = bank.getAllCountsMap().values().stream().toList();

        long before = bank.getSumAllAccounts();
        System.out.println("До операций перевода сумма всех счетов => " + before);

        for (int i = 1; i < accountList.size(); i++) { //делаем запросы по переводам между счетами
            long sumTransfer = (long) (Math.random()*((52_000 - 10_000) + 1)) + 10_000;
            MakeTransfer makeTransfer = new MakeTransfer(bank, String.valueOf(i), String.valueOf(i+1), sumTransfer);
            Thread thread = new Thread(makeTransfer);
            thread.start();
          }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long after = bank.getSumAllAccounts();
        System.out.println("After операций перевода сумма всех счетов => " + after);
        System.out.println(after == before);

    }
}
