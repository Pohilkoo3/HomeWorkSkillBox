import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MakeTransfer implements Runnable{
    private Logger loggerTransfer = LogManager.getLogger("LoggerTransfer");
    private Bank bank;
    private Account accountFrom;
    private Account accountTo;
    private String fromAccountNum;
    private String toAccountNum;

    private long amount;


    public MakeTransfer(Bank bank, String fromAccountNum, String toAccountNum, long amount) {
        this.bank = bank;
        this.accountFrom = bank.getAllCountsMap().get(fromAccountNum);
        this.accountTo = bank.getAllCountsMap().get(toAccountNum);
        this.amount = amount;
        this.fromAccountNum = fromAccountNum;
        this.toAccountNum = toAccountNum;
    }

    @Override
    public void run() {
       if (accountFrom.isLock()){
           return;
       }
        long amountMoneyFrom = accountFrom.getMoney();
        long amountMoneyTo = accountTo.getMoney();
        bank.transfer(fromAccountNum, toAccountNum, amount);
        long amountMoneyFromAfter = bank.getAllCountsMap().get(fromAccountNum).getMoney();
        long amountMoneyToAfter = bank.getAllCountsMap().get(toAccountNum).getMoney();
        loggerTransfer.info("Со счета " + fromAccountNum +  " => " + amountMoneyFrom + " руб. " + toAccountNum + " => " +
                    amountMoneyTo + " перевели → " + amount + " Now на счету списания → " + amountMoneyFromAfter + " и " +
                    bank.getAllCountsMap().get(fromAccountNum).isLock() + " , а на счету " +
                    "пополнения → "+ amountMoneyToAfter + " => " + bank.getAllCountsMap().get(toAccountNum).isLock());

    }
}
