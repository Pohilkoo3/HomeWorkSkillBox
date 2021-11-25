public class CardAccount extends BankAccount {
    private final static double PERCENT_TO_GET = 0.01;


    @Override
    public boolean take(double amountToTake) {
        double amountTaxToTake = amountToTake * PERCENT_TO_GET;
        return super.take(amountToTake + amountTaxToTake);
    }
}
// не забывайте, обращаться к методам и конструкторам родителя
// необходимо используя super, например, super.put(10D);