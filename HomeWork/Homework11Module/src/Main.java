import HomeWork11_1.BankAccount;
import HomeWork11_1.DepositAccount;

public class Main {
    private final static String MESSAGE = "Сумма на счете не соответствует ожидаемой";


    public static void main(String[] args) {

BankAccount bankAccount= new BankAccount();
bankAccount.put(50000);
        System.out.println(bankAccount);
        DepositAccount depositAccount = new DepositAccount();
       bankAccount.send(depositAccount, 20000);
        System.out.println(depositAccount);
        depositAccount.take(10000);
        System.out.println( depositAccount);

        depositAccount.take(5000);





    }
}

