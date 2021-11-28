import CaseBankAccount.BankAccount;
import CaseBankAccount.CardAccount;
import CaseBankAccount.DepositAccount;

import java.util.LinkedList;
import java.util.List;

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
        System.out.println(depositAccount.dateIncome);
        depositAccount.take(5000);





    }
}

