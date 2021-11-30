public class Main {

    public static void main(String[] args) {
        DepositAccount depositAccount = new DepositAccount();
        BankAccount bankAccount = new BankAccount();
        depositAccount.put(60000);
        System.out.println(depositAccount);
        depositAccount.take(1000);
        System.out.println(depositAccount);
    }




}
