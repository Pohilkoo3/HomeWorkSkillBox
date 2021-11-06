/*    Принцип работы команд:

        LIST — выводит дела с их порядковыми номерами;
        ADD — добавляет дело в конец списка или дело на определённое место, сдвигая остальные дела вперёд, если указать номер;
        если указан несуществующий индекс - добавит в конец списка.
        EDIT — заменяет дело с указанным номером; если указан несуществующий индекс - ничего не делает.
        DELETE — удаляет; если указан несуществующий индекс - ничего не делает.
        // TODO: написать консольное приложение для работы со списком дел todoList
     */

/*LIST — выводит дела с их порядковыми номерами;
ADD — добавляет дело в конец списка или дело на определённое место, сдвигая остальные дела вперёд, если указать номер; если указан несуществующий индекс - добавить в конец списка.
EDIT — заменяет дело с указанным номером; если указан несуществующий индекс - ничего не делать.
DELETE — удаляет; если указан несуществующий индекс - ничего не делать.*/
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    static int indexCommand = 0;
    static String textCommand;
    static String method;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TodoList test = new TodoList();

        while (true){
            System.out.println("Введите команду. Для завершения работы введите END");
            String commandCycle = scanner.nextLine();
            if (commandCycle.equals("END")){
                return;
            }
            getMethod(commandCycle);
            if (method.equals("EDIT") && indexCommand >=0){
                System.out.println("----" + "Дело \"" + test.getCase(indexCommand) + "\"" + " заменено на \"" + textCommand + "\"");
                test.edit(textCommand, indexCommand);

            } else if (method.equals("DELETE") && indexCommand >=0){
                if (indexCommand > test.getSize() - 1){
                    System.out.println("Дело с таким номером не существует");//  проверьте возможность изменения
                    return;
                } else {
                    System.out.println("Дело \"" + test.getCase(indexCommand) + "\" удалено.");
                    test.delete(indexCommand);
                }
            } else if (method.equals("LIST")){

                for (int i = 0; i < test.getTodos().size(); i++){
                    System.out.println(i + " - " + test.getTodos().get(i));
                }
                System.out.println("\n");

            } if (method.equals("ADD") && indexCommand < 0){
                System.out.println("Добавлено дело \"" + textCommand + "\"");
                test.add(textCommand);
            } else if (method.equals("ADD")){
                System.out.println("Добавлено дело \"" + textCommand + "\"");
                test.add(indexCommand, textCommand);
            }
        }
    }

    static void getMethod(String commandCycle){
        String regex = "([A-Z]{3,6})\\s*(\\d*)\\s*(.*)";
        Pattern pat = Pattern.compile(regex);
        Matcher mat = pat.matcher(commandCycle);
        mat.find();
        method = mat.group(1);
        textCommand = mat.group(3);
        if (mat.group(2).isEmpty()){
            indexCommand = -1;
        } else {
            indexCommand = Integer.parseInt(mat.group(2));
        }
    }
}
