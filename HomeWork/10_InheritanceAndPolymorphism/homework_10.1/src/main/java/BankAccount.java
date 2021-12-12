public class BankAccount {
  private double total;

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
    if (amountToTake > 0 && (total - amountToTake) >= 0) {
     total -= amountToTake;
      return true;
    }return false;
  }

  @Override
  public String toString() {
    return "На вашем счете: " +
            total +
            " рублей.";
  }
}

