import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DepositAccount extends BankAccount {
    private LocalDate lastIncome = LocalDate.now(); //дата последнего внесения

    @Override
    public boolean take(double amountToTake) {
        LocalDate now = LocalDate.now();
        int month = (int) (lastIncome.until(now, ChronoUnit.MONTHS));
        if (month >= 1) {
            return super.take(amountToTake);
        } return false;
    }
}