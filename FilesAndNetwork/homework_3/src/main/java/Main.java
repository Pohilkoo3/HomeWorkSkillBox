import java.util.List;

public class Main {

    public static void main(String[] args) {
        Movements movements = new Movements("D:\\skillBox\\java_basics\\FilesAndNetwork\\files\\movementList.csv");
        List<Movements> listTest = movements.getList();

        System.out.println("Сумма доходов: " + movements.getIncomeSum() + " руб.");
        System.out.println("Сумма расходов: " + movements.getExpenseSum() + " руб.");
        System.out.println("\n\n" + "Сумма расходов по организациям: ");

        listTest.forEach(m -> System.out.println(m.getName() + " \t " + m.getExpense() + " руб."));
    }
}




