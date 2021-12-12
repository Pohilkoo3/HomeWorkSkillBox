import java.math.BigDecimal;

public class TopManager extends Operator{
    private final Company company;

    public TopManager(Company company) {
        this.company = company;
    }

    @Override
    public double getMonthSalary() {
        if (company.getIncomeCompany().compareTo(new BigDecimal(10_000_000)) > 0){
           return getFixSalary() + 1.5 * getFixSalary();
        }
        return getFixSalary();
    }
}