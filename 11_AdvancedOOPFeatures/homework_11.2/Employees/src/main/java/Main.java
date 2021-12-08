import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class Main {

    private static final String STAFF_TXT = "data/staff.txt";
    public static void main(String[] args) {
        List<Employee> staff = Employee.loadStaffFromFile(STAFF_TXT);
        System.out.println(findEmployeeWithHighestSalary(staff,2017));
    }

    public static Employee findEmployeeWithHighestSalary(List<Employee> staff, int year) {

        int year1 = year - 2000 + 100;
        return staff.stream().filter(employee -> employee.getWorkStart()
                        .getYear() == year1)
                .sorted(Comparator.comparing(Employee::getSalary))
                .max(Comparator.comparingDouble(Employee::getSalary)).orElse(null);
    }
}



//        Calendar calendar = Calendar.getInstance();
//    var ref = new Object() {
//        int max = 0;
//    };
//        staff.forEach(e -> {
//                calendar.setTime(e.getWorkStart());
//                if (calendar.get(Calendar.YEAR) == year) {
//                if (e.getSalary() > ref.max) {
//                    ref.max = e.getSalary();
//                }
//                }
//        });
//        return staff.stream().filter(employee -> employee.getSalary() == ref.max).findFirst().orElse(null);
//    }
//}

//


//    Calendar calendar = Calendar.getInstance();
//    AtomicReference<Employee> findMax = new AtomicReference<>(new Employee("", 0, new Date(1900, 1, 1)));
//    var ref = new Object() {
//        int max = 0;
//    };
//        staff.forEach(e -> {
//                calendar.setTime(e.getWorkStart());
//                if (calendar.get(Calendar.YEAR) == year) {
//                if (e.getSalary() > ref.max) {
//                ref.max = e.getSalary();
//                findMax.set(e);
//                }
//                }
//                });
//                Employee employee = findMax.get();
//                return employee;