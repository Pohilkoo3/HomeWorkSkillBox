import java.util.*;

public class Bank
{
    private volatile Hashtable<String, Account> accounts;
    private final Random random = new Random();

    public Bank() {
        this.accounts = new Hashtable<>();
    }

    public synchronized boolean isFraud(String fromAccountNum, String toAccountNum, long amount)
        throws InterruptedException {
        Thread.sleep(1000);
        return random.nextBoolean();
    }

    public synchronized boolean transfer(String fromAccountNum, String toAccountNum, long amount) {
        Account accountFrom = accounts.get(fromAccountNum);
        Account accountTo = accounts.get(toAccountNum);
        if (accountFrom.isLock() ||accountTo.isLock() || accountFrom.getMoney() < amount || amount < 0){
            return false;
        }
        accountFrom.setMoney(accountFrom.getMoney() - amount);
        accountTo.setMoney(accountTo.getMoney() + amount);
        if (amount > 50_000){
            try {
              boolean availableToTransfer = isFraud(fromAccountNum, toAccountNum, amount);
              accountFrom.setLock(availableToTransfer);
              accountTo.setLock(availableToTransfer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }return true;
    }

    public void putNewAccount(String accNumber, Account account) {
        accounts.put(accNumber, account);
    }

    public long getBalance(String accountNum) {
        return accounts.get(accountNum).getMoney();
    }

    public long getSumAllAccounts() {
        long totalSum = 0;
        for (Map.Entry element : accounts.entrySet()) {
            totalSum+= accounts.get(element.getKey()).getMoney();
        }
        return totalSum;
    }
    public Map<String, Account> getAllCountsMap(){
        return accounts;
    }

}
