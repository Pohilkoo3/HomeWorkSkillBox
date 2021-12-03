
import java.util.*;

public class Company {
    private final String name;
   public HashMap<String,Double> employees = new HashMap<>();
   private final int incomeCompany;


    public Company(String name) {
        this.name = name;
        this.incomeCompany = setIncomeCompany();
    }

    public List<Double> getTopSalaryStaff(int count){
        List <Double> copy =  new ArrayList<>(getListEmployee().values());
        Collections.sort(copy);
        Collections.reverse(copy);
        if (count > copy.size()){
            return null;
        }
        return copy.subList(0,count);
    }

    public List<Double> getLowestSalaryStaff(int count){
        List <Double> copy =  new ArrayList<>(getListEmployee().values());
        Collections.sort(copy);
        if (count > copy.size()){
        return null;
        }
        return copy.subList(0,count);
        }

    public void hire(String name, double salary){
    employees.put(name, salary);
     }

    public int getIncomeCompany() {
        return incomeCompany;
    }

    private int setIncomeCompany() {
        return (int) (Math.random() * ((15_500_000.0 - 500_000.0) + 1) + 500_000.0);
    }

    public void hireAll(HashMap<String, Double> addAllStaffMember) {
     employees.putAll(addAllStaffMember);
     }

    public void fire (String name) {
        employees.remove(name);
    }

    public HashMap<String, Double> getListEmployee(){
        return new HashMap<>(employees);
    }


}
