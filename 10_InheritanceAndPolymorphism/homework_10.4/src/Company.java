import java.math.BigDecimal;

public class Company {
    private final String name;
    private BigDecimal incomeCompany = new BigDecimal("0.0");

    public Company(String name) {
        this.name = name;
    }

    public BigDecimal getIncomeCompany() {
        return incomeCompany;
    }

    public void setIncomeCompany(BigDecimal incomeCreateManagers) {
        incomeCompany = incomeCompany.add(incomeCreateManagers);
    }

    @Override
    public String toString() {
        return "Company: " + name + '\'' ;
    }
}
