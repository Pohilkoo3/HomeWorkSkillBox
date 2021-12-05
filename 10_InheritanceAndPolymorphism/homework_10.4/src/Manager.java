import java.math.BigDecimal;

public class Manager extends Operator {
    private static BigDecimal totalIncome = new BigDecimal("0");
    private Company company;

    public Manager(Company company) {
        this.company = company;
    }

    @Override
    public double getMonthSalary() {
        return getFixSalary() + 0.05 * generateIncome();
    }

    private double generateIncome(){
      double salaryManager = Math.round (Math.random() * ((115_000 - 140_000.0) + 1) + 140_000.0);
      totalIncome = totalIncome.add(new BigDecimal(salaryManager));
      company.setIncomeCompany(totalIncome);
        return salaryManager;
    }

    public static BigDecimal getTotalIncome() {
        return totalIncome;
    }
}
