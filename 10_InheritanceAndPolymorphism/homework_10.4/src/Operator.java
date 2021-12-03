public class Operator implements Employee{
    private double fixSalary;

    public void setFixSalary(double fixSalary) {
        this.fixSalary = fixSalary;
    }

    public double getFixSalary() {
        return fixSalary;
    }

    @Override
    public double getMonthSalary() {
        return  fixSalary;
    }
}
