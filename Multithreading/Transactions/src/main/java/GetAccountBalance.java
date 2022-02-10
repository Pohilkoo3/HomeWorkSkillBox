import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GetAccountBalance implements Runnable{
public static int countGetAccountBalance;
    private Account account;
    Logger loggerQuery = LogManager.getLogger("QueryGetBalance");
    Logger loggerMakeQuery = LogManager.getLogger("MakeQueries");



    public GetAccountBalance(Account account) {
        this.account = account;
        countGetAccountBalance++;
        loggerMakeQuery.info("Создан запрос" + account.getAccNumber());
    }

    @Override
    public void run() {
        account.getMoney();
        System.out.println("Balans: " + account.getMoney());
        loggerQuery.info("Сделан запрос по счету " + account.getAccNumber());
    }
}
