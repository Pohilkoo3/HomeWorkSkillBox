import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Movements {
    private static final String REGEX ="((/|\\\\)+[A-z0-9_>\\\\/\\s]+[\\s]{3,})";
    private static final Pattern PAT = Pattern.compile(REGEX);
    private final String PATH_TO_SOURCE;
    private List<Operation> operationList;

    public Movements(String pathMovementsCsv) {
        PATH_TO_SOURCE = pathMovementsCsv;
        getList();
    }

    public List<Operation> getList(){
        operationList = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(PATH_TO_SOURCE));
            for (int i = 1; i < lines.size(); i++ ) {
                String line = lines.get(i);
                if (line == null){
                    break;
                }
                String[] splitText = line.split(",");
                if (splitText.length != 8){
                    switch (splitText.length) {
                        case (9) -> {
                           if (splitText[6].equals("0")) {
                               splitText[7] = (splitText[7].concat(".") + splitText[8]).replaceAll("\"", "");
                           } else if (splitText[8].equals("0")){
                                    splitText[6] = (splitText[6].concat(".") + splitText[7]).replaceAll("\"", "");
                                    splitText[7] = splitText[8];
                                }
                        }
                        default -> throw new IllegalArgumentException("Строка содержит некорректные данные.");
                    }
                }
                Matcher mat = PAT.matcher(splitText[5]);
                String partner ="";
                double income = 0;
                double expenseWright =0;
                try {
                    mat.find();
                    partner = ((mat.group(0).replaceAll("\\\\", "")).replaceAll("/", "").replaceAll(">"," ")).trim();
                    income = Double.parseDouble(splitText[6]);
                    expenseWright = (Double.parseDouble(splitText[7].replaceAll("\"", "")));
                } catch (Exception ex){
                    ex.printStackTrace();
                }
                int count = 0;
                for (Operation element : operationList) {
                    if (element.getName().equals(partner)) {
                            element.setExpense(element.getExpense() + expenseWright);
                            element.setIncome(element.getIncome() + income);
                            count ++;
                        }
                    }
                if (count == 0) {
                    operationList.add(new Operation(partner,income, expenseWright));
                }
                }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }return new ArrayList<>(operationList);
    }

    public double getExpenseSum() {
         return operationList.stream().mapToDouble(Operation::getExpense).reduce(Double::sum).orElse(0);
    }
    public double getIncomeSum() {
        return operationList.stream().mapToDouble(Operation::getIncome).reduce(Double::sum).orElse(0);
    }
}

class Operation{
    private String name;
    private double income;
    private double expense;

    public Operation(String name, double income, double expense) {
        this.name = name;
        this.income = income;
        this.expense = expense;
    }

    public String getName() {
        return name;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public double getExpense() {
        return expense;
    }

    public void setExpense(double expense) {
        this.expense = expense;
    }

    public String toString(){
        return name + " => " + " expense → " + expense + ", income => " + income;
    }
}

