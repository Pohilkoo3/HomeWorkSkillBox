import java.time.LocalDate;


public class DepositAccount extends BankAccount {

    private  LocalDate lastIncome;

        @Override
        protected boolean put(double amountToPut) {
            lastIncome = LocalDate.now();
            return super.put(amountToPut);
        }



    @Override
    protected boolean take(double amountToTake) {
            return (lastIncome.isBefore(LocalDate.now().minusMonths(1)) ? super.take(amountToTake) : false);
      //  return LocalDate.now().isAfter(lastIncome.plusMonths(1)) && super.take(amountToTake);
    }

    @Override
        public String toString() {
            return "DepositAccount - " + super.toString();
        }
    }
