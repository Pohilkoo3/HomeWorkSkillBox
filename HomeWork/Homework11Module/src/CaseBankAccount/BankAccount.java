package CaseBankAccount;

public class BankAccount {

  private double total;
  private String numberAccount;



    public boolean send(BankAccount receiver, double amount){
        if (!take(amount)){
            return false;
        } receiver.put(amount);
        return true;
    }

    public double getAmount() {
        return total;
    }

    public boolean put(double amountToPut) {
      if (amountToPut <= 0) {
          return false;
      }
      total = total + amountToPut;
      return true;
    }

    public boolean take(double amountToTake) {
       if ((total - amountToTake) < 0 || amountToTake <= 0){
           return false;
       } total -= amountToTake;
           return true;

    }

    @Override
    public String toString() {
        return "На вашем счете: " +
                 + total +
                " рублей.";
    }
}

