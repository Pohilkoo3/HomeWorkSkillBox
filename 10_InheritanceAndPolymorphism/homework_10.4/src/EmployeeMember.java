import java.math.BigDecimal;

public class EmployeeMember implements Comparable<EmployeeMember>{
    private final String name;
    private double salary;
    private BigDecimal incomeForCompany = new BigDecimal(0);

    public EmployeeMember(String name, double salary) {

        this.name = name;
        this.salary = salary;
    }

    public EmployeeMember(String name, double salary, BigDecimal incomeForCompany) {
        this.name = name;
        this.salary = salary;
        this.incomeForCompany = incomeForCompany;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public int compareTo(EmployeeMember employeeMember) {
        return Double.compare(getSalary(), employeeMember.getSalary());
    }

    public BigDecimal getIncomeForCompany() {
        return incomeForCompany;
    }

    @Override
    public String toString() {
        return name + " → " + salary ;
    }
}
