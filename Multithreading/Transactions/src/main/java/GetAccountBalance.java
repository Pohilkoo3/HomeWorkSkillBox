public class GetAccountBalance implements Runnable{
    private final Account account;

    public GetAccountBalance(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        account.getMoney();
    }
}
