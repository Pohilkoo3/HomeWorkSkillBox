import java.util.*;

public class Main {
    public static void main(String[] args) {

        Company test = new Company("ООО ВИП");
        ListEmployee listEmployeeTest = new ListEmployee(test);
        TopManager topManager = new TopManager(test);
        topManager.setFixSalary(100_000);
        Operator operator = new Operator();
        operator.setFixSalary(40_000);
        Manager manager = new Manager(test);
        manager.setFixSalary(80_000);

        for (int i = 1; i < 181; i++) {
            listEmployeeTest.hire (new EmployeeMember("Operator " + i, operator.getMonthSalary()));
            if ( i < 81) {
                listEmployeeTest.hire (new EmployeeMember("Manager " + i, manager.getMonthSalary()));
            }
            if (i > 81 && i < 92) {
                listEmployeeTest.hire (new EmployeeMember("TopManager " + i, topManager.getMonthSalary()));
            }
        }

        printStaff(listEmployeeTest.getLowestSalaryStaff(15));
        System.out.println("--------------------------");
        printStaff(listEmployeeTest.getTopSalaryStaff(30));

        for (int i = 1; i < 91; i++) {
            listEmployeeTest.fire ("Operator " + i);
            if ( i < 41) {
                listEmployeeTest.fire ("Manager " + i);
            }
            if (i < 6) {
                listEmployeeTest.fire ("TopManager " + i);
            }
        }

        System.out.println("Total income manager: " + Manager.getTotalIncome());
        System.out.println("\nПосле увольнения.\n");
        printStaff(listEmployeeTest.getLowestSalaryStaff(15));
        System.out.println("--------------------------");
        printStaff(listEmployeeTest.getTopSalaryStaff(30));
    }

    static void printStaff(List<EmployeeMember> list) {
        if (list == null){
            System.out.println("Введенное количество элеметов больше количества сотрудников.");
            return;
        }int count = 0;

        for (EmployeeMember print : list) {
            System.out.println(print);
            count++;
        }
        System.out.println("Количество персонала: " + count);
    }
}
