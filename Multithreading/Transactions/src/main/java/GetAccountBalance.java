
public class GetAccountBalance implements Runnable{
    private Account account;

    public GetAccountBalance(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        account.getMoney();
        System.out.println("Balance: " + account.getMoney());
    }
}
