public class Manager extends Operator {

    @Override
    public double getMonthSalary() {
        return getFixSalary() + 0.05 * generateIncome();
    }

    static double generateIncome(){
        return Math.round (Math.random() * ((115_000 - 140_000.0) + 1) + 140_000.0);
    }

}
