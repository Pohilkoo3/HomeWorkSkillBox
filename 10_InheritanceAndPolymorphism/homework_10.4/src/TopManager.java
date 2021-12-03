public class TopManager extends Operator{
    private final Company company;

    @Override
    public void setFixSalary(double fixSalary) {
        super.setFixSalary(fixSalary);
    }

    public TopManager(Company company) {
        this.company = company;
    }

    @Override
    public double getMonthSalary() {
        return company.getIncomeCompany() > 10_000_000 ? getFixSalary() + 1.5 * getFixSalary() : getFixSalary();
    }

}
