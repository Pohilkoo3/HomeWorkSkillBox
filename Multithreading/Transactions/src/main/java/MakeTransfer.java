public class MakeTransfer implements Runnable{
    private final Bank bank;
    private final String fromAccountNum;
    private final String toAccountNum;
    private final long amount;

    public MakeTransfer(Bank bank, String fromAccountNum, String toAccountNum, long amount) {
        this.bank = bank;
        this.amount = amount;
        this.fromAccountNum = fromAccountNum;
        this.toAccountNum = toAccountNum;
    }

    @Override
    public void run() {

//        System.out.println("Transfer From begun it's work => " + fromAccountNum);
        bank.transfer(fromAccountNum, toAccountNum, amount);
//        System.out.println("Transfer From end it's work => " + fromAccountNum);

    }


}