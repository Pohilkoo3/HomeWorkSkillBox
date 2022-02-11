public class MakeTransfer implements Runnable {
    private Bank bank;
    private String fromAccountNum;
    private String toAccountNum;
    private long amount;

    public MakeTransfer(Bank bank, String fromAccountNum, String toAccountNum, long amount) {
        this.bank = bank;
        this.amount = amount;
        this.fromAccountNum = fromAccountNum;
        this.toAccountNum = toAccountNum;
    }

    @Override
    public void run() {
        bank.transfer(fromAccountNum, toAccountNum, amount);
    }
}