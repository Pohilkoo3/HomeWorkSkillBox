import java.time.LocalDate;
import java.time.Period;
import java.util.LinkedList;

public class DepositAccount extends BankAccount {

LinkedList<LocalDate> putIncomeDate = new LinkedList<>();
    private  LocalDate lastIncome;

        @Override
        protected boolean put(double amountToPut) {
            putIncomeDate.add(LocalDate.now());
            return super.put(amountToPut);
        }

    @Override
    protected boolean take(double amountToTake) {
            if (lastIncome == null) {
                lastIncome = putIncomeDate.getLast();
            }
                Period period = Period.between(lastIncome, LocalDate.now());
                if (period.getMonths() >= 1 || period.getYears() >= 1) {
                    return super.take(amountToTake);
            }
        return false;
    }

    @Override
        public String toString() {
            return "DepositAccount - " + super.toString();
        }
    }
