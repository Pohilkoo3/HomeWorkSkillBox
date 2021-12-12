import java.util.Collections;
import java.util.List;

public class Main {
    public static final String STAFF_TXT = "data/staff.txt";

    public static void main(String[] args) {
        List<Employee> staff = Employee.loadStaffFromFile(STAFF_TXT);
        System.out.println(staff);
        sortBySalaryAndAlphabet(staff);
        System.out.println("\nAfter sort\n");
        System.out.println(staff);
    }

    public static void sortBySalaryAndAlphabet(List<Employee> staff) {
        Collections.sort(staff, (o1, o2) -> {
            int x = Double.compare(o1.getSalary(), o2.getSalary());
            if (x !=0 ){
                return x;
            }
            return o1.getName().compareTo(o2.getName());
        });
    }
}