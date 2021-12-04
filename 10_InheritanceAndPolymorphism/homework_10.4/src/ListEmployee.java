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
    }

    public void hireAll(ArrayList<EmployeeMember> addAllEmployees) {
        employeeMembers.addAll(addAllEmployees);
    }

    public void fire (String name) {
        employeeMembers.removeIf(element -> element.getName().equals(name));
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
