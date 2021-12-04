public class EmployeeMember implements Comparable<EmployeeMember>{
    private final String name;
    private double salary;

    public EmployeeMember(String name, double salary) {
        this.name = name;
        this.salary = salary;
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

    @Override
    public int compareTo(EmployeeMember employeeMember) {
        return Double.compare(getSalary(), employeeMember.getSalary());
    }

    @Override
    public String toString() {
        return name + " → " + salary;
    }
}
