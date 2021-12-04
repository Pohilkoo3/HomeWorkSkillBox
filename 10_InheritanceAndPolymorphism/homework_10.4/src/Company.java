
public class Company {
    private final String name;
    private final int incomeCompany;

    public Company(String name) {
        this.name = name;
        this.incomeCompany = setIncomeCompany();
    }

    public int getIncomeCompany() {
        return incomeCompany;
    }

    private int setIncomeCompany() {
        return (int) (Math.random() * ((15_500_000.0 - 500_000.0) + 1) + 500_000.0);
    }

    @Override
    public String toString() {
        return "Company: " + name + '\'' ;
    }
}
