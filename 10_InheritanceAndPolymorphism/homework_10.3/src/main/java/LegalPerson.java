public class LegalPerson extends PhysicalPerson {
    private final static double PERCENT_TO_TAKE = 0.01;

    @Override
    public void take(double amountToTake) {
        double percentToTake = amountToTake * PERCENT_TO_TAKE;
        super.take(amountToTake + percentToTake);
    }

    @Override
    public String toString() {
        return "При снятии взимается коммисия в размере 1% от суммы снятия. LegalPerson Account. На вашем счете "
                + getAmount() + " рублей.";
    }
}
