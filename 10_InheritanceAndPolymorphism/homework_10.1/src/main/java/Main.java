public class Main {

    public static void main(String[] args) {
        DepositAccount depositAccount = new DepositAccount();
        BankAccount bankAccount = new BankAccount();
        CardAccount cardAccount = new CardAccount();
        cardAccount.put(100);
        cardAccount.take(20);
        System.out.println(cardAccount.getAmount());
bankAccount.put(50);
        System.out.println(bankAccount.getAmount());
        depositAccount.put(60000);
        System.out.println(depositAccount);

    }




}
