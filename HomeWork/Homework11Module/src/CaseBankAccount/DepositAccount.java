package CaseBankAccount;

import CaseBankAccount.BankAccount;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.LinkedList;
import java.util.List;

public class DepositAccount extends BankAccount {
    public LinkedList<LocalDate> dateIncome = new LinkedList<>();
    public LocalDate lastIncome;

    @Override
    public boolean put(double amountToPut) {
        LocalDate Income = LocalDate.of(2020,1,1);
        dateIncome.add(Income);
        return super.put(amountToPut);
    }

    @Override
    public boolean take(double amountToTake) {
        System.out.println(lastIncome);
        lastIncome = dateIncome.getLast();
        int month = (int) (lastIncome.until(LocalDate.now(), ChronoUnit.MONTHS));
        int year = (int) (lastIncome.until(LocalDate.now(), ChronoUnit.YEARS));
        if (lastIncome.getMonthValue() > 1) {
            System.out.println("Вы смогли снять деньги");
            return super.take(amountToTake);
        }
        System.out.println("Ни хрена не снимешь");
        return false;
    }

    @Override
    public String toString() {
        return "DepositAccount - " + super.toString();
    }
}