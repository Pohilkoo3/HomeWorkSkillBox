import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



public class Main {
    private static Logger logger = LogManager.getRootLogger();
    public static void main(String[] args) {
       Bank bank = new Bank();
        for (int i = 1; i < 50; i++) {
            String accNumber = String.valueOf(i);
            Account account = new Account(accNumber);
            account.setMoney(150_000L);
            bank.putNewAccount(accNumber, account);
        }
        MakeTransfer makeTransfer = new MakeTransfer(bank, String.valueOf(1), String.valueOf(2), 10);
        MakeTransfer makeTransfer2 = new MakeTransfer(bank, String.valueOf(2), String.valueOf(1), 20);
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(makeTransfer);
            Thread thread2 = new Thread(makeTransfer2);
            thread.start();
            thread2.start();
        }




    }
}
