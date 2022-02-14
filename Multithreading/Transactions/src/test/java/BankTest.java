import junit.framework.TestCase;
import java.util.ArrayList;
import java.util.List;

public class BankTest extends TestCase {
    Bank bank;
    List<Account> accountList;

    @Override
    protected void setUp()  {
        bank = new Bank();
        for (int i = 1; i < 10000; i++) {
            String accNumber = String.valueOf(i);
            Account account = new Account(accNumber);
            account.setMoney((int) (Math.random()*((100_000 - 10_000) + 1)) + 10_000);
            bank.putNewAccount(accNumber, account);
        }
        accountList = bank.getAllCountsMap().values().stream().toList();
    }

    public void testBank(){
      long actual = bank.getSumAllAccounts();
      List<Thread> listTestTransfer = new ArrayList<>();
        for (int i = 1; i < accountList.size(); i++) {
          new Thread(new GetAccountBalance(accountList.get(i))).start();
          long sumTransfer = (long) (Math.random()*((62_000 - 10_000) + 1)) + 10_000;
          MakeTransfer makeTransfer = new MakeTransfer(bank, String.valueOf(i), String.valueOf(i+1), sumTransfer);
          Thread thread = new Thread(makeTransfer);
          listTestTransfer.add(thread);
        }
        listTestTransfer.forEach(e -> e.start());
        long expected = bank.getSumAllAccounts();
      assertEquals(expected, actual);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
