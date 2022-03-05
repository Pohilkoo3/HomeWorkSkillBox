import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public class Main {

    private static final String STAFF_TXT = "data/staff.txt";
    public static void main(String[] args) {
//        List<Employee> staff = Employee.loadStaffFromFile(STAFF_TXT);
        Integer[] integers = {1,2,3,4,5,6,7,8,9};
        Arrays.stream(integers)
                .map(String::valueOf)
                .reduce((s1, s2) -> s1 + s2)
                .ifPresent(System.out::println);

    }

    public static Employee findEmployeeWithHighestSalary(List<Employee> staff, int year) {

        return staff.stream().filter(employee -> {
             Calendar calendar = Calendar.getInstance();
              calendar.setTime(employee.getWorkStart());
                 return calendar.get(Calendar.YEAR) == year;
                })
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