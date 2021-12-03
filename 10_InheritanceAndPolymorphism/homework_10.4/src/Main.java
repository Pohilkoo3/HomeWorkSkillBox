import java.util.*;

public class Main {
    public static void main(String[] args) {

       Company test = new Company("ООО ВИП");// сделал StringBuilder как вариант.
        for (int i = 1; i < 181; i++) {
            StringBuilder nameNextOperator = new StringBuilder();
            nameNextOperator.append("Operator ").append(i);
            Operator operator = new Operator();
            operator.setFixSalary(40000);
            test.hire(nameNextOperator.toString(), operator.getMonthSalary());
        if ( i < 81) {
            Manager manager = new Manager();
            manager.setFixSalary(50000);
            test.hire("Manager " + i, manager.getMonthSalary());
        }
        if (i < 11) {
            TopManager topManager = new TopManager(test);
            topManager.setFixSalary(100_000);
            test.hire("TopManager " + i, topManager.getMonthSalary());
        }
        }
        printSalaryStaff(test.getLowestSalaryStaff(15));
        System.out.println("--------------------------");
        printSalaryStaff(test.getTopSalaryStaff(30));

        for (int i = 1; i < 91; i++) {
            StringBuilder nameNextOperator = new StringBuilder();
            nameNextOperator.append("Operator ").append(i);
            Operator operator = new Operator();
            operator.setFixSalary(40000);
            test.fire(nameNextOperator.toString());
            if ( i < 41) {
                Manager manager = new Manager();
                manager.setFixSalary(50000);
                test.fire("Manager " + i);
            }
            if (i < 6) {
                TopManager topManager = new TopManager(test);
                topManager.setFixSalary(100_000);
                test.fire("TopManager " + i);
            }
        }
        System.out.println("\nПосле увольнения.\n");
        printSalaryStaff(test.getLowestSalaryStaff(15));
        System.out.println("--------------------------");
        printSalaryStaff(test.getTopSalaryStaff(30));

    }

    static void printSet(Map<String, Double> map){
        int count = 0;
        for (Map.Entry print : map.entrySet()) {
            System.out.println(print.getKey() + " → " + print.getValue() + " рублей.");
            count++;
        }
        System.out.println("Количество сотрудников: " + count);
    }

    static void printSalaryStaff(List<Double> list){
        if (list == null){
            System.out.println("Введенное количество элеметов больше количества сотрудников.");
            return;
        }
        for (Double print : list) {
            System.out.println(print);
        }

    }

}
