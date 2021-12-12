import java.math.BigDecimal;
import java.util.*;

public class ListEmployee {
    private final Company company;
    private final List<EmployeeMember> employeeMembers = new ArrayList<>();

    public ListEmployee(Company company) {
        this.company = company;
    }

    public List<EmployeeMember> getTopSalaryStaff(int count){
        getLowestSalaryStaff(employeeMembers.size());
        Collections.reverse(employeeMembers);
        return employeeMembers.subList(0,count);
    }

    public List<EmployeeMember> getLowestSalaryStaff(int count){
        if (count > employeeMembers.size()){
            return null;
        }
        Collections.sort(employeeMembers);
        return employeeMembers.subList(0,count);
    }

    public void hire(EmployeeMember employeeMember){
        employeeMembers.add(employeeMember);
        company.setIncomeCompany(employeeMember.getIncomeForCompany());

    }

    public void hireAll(ArrayList<EmployeeMember> addAllEmployees) {
        employeeMembers.addAll(addAllEmployees);
        BigDecimal totalAddIncome = new BigDecimal("0");
        for (EmployeeMember element : addAllEmployees) {
         totalAddIncome = totalAddIncome.add(element.getIncomeForCompany());
        }
        company.setIncomeCompany(totalAddIncome);
    }

    public void fire (String name) {
        Iterator<EmployeeMember> it = employeeMembers.listIterator();
        while (it.hasNext()){
            EmployeeMember e = it.next();
            if (e.getName().equals(name)){
                company.setIncomeCompany((e.getIncomeForCompany()).multiply(new BigDecimal(-1)));
                it.remove();
            }
        }
    }

    public ArrayList<EmployeeMember> getListEmployee(){
        return new ArrayList<>(employeeMembers);
    }

    @Override
    public String toString() {
        return "ListEmployee " +
                company + " : " +
                employeeMembers;
    }
}
