package CaseBankAccount;

import CaseBankAccount.BankAccount;

public class CardAccount extends BankAccount {
    private final static double PERCENT_TO_GET = 0.01;



    @Override
    public boolean take(double amountToTake) {
        double amountTaxToTake = amountToTake * PERCENT_TO_GET;
        return super.take(amountToTake + amountTaxToTake);
    }
}
