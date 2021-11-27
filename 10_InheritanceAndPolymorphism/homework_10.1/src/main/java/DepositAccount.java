import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.LinkedList;

public class DepositAccount extends BankAccount {

        public LocalDate lastIncome;

        @Override
        public boolean put(double amountToPut) {
            return super.put(amountToPut);
        }

    @Override
    public boolean take(double amountToTake) {
            if (lastIncome != null && lastIncome.lengthOfMonth() >= 1){
                return super.take(amountToTake);
        }
        return false;
    }

    @Override
        public String toString() {
            return "DepositAccount - " + super.toString();
        }
    }
