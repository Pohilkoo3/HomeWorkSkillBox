public class BankAccount {
  private double total;

  boolean send(BankAccount receiver, double amount){
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
    if ((total - amountToTake) >= 0){
      total -= amountToTake;
      return true;
    }
    return false;

  }

  @Override
  public String toString() {
    return "На вашем счете: " +
            + total +
            " рублей.";
  }
}

//
//  public double getAmount() {
//    //TODO: реализуйте метод и удалите todo
//    // верните значение количества денег не счету
//    return 0;
//  }
//
//  public void put(double amountToPut) {
//    //TODO: реализуйте метод и удалите todo
//    // метод зачисляет деньги на счет
//  }
//
//  public void take(double amountToTake) {
//    //TODO: реализуйте метод и удалите todo
//    // метод списывает деньги со счета
//  }
//}
