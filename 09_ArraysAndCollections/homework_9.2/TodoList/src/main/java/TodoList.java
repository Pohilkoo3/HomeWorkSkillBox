import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TodoList {
    public static String commandMethod = "";
    public static String commandText = "";
    public ArrayList<String> todoList = new ArrayList<>();

    public void add(String todo) {
        todoList.add(todo);
        System.out.println("Добавлено дело \"" + todo + "\"");// TODO: добавьте переданное дело в конец списка
    }

    public void add(int index, String todo) {
        index = index > todoList.size() || index < 0 ? todoList.size() : index;     // TODO: добавьте дело на указаный индекс,
        todoList.add( index, todo);
        System.out.println("Добавлено дело \"" + todo + "\"");
    }

    public void edit(String todo, int index) {
        if (index < 0 || index > todoList.size() - 1){          //  проверьте возможность изменения
            return;
        }
        System.out.println("Дело \"" + todoList.get(index) + "\"" + " заменено на \"" + todo + "\"");
        todoList.set(index,todo);
        // TODO: заменить дело на index переданным todo индекс,
    }

    public void delete(int index) {
        if (index < 0 || index > todoList.size() - 1){
            System.out.println("Дело с таким номером не существует");//  проверьте возможность изменения
            return;
        }
        System.out.println("Дело \"" + todoList.get(index) + "\" удалено.");
        todoList.remove(index);                    // TODO: удалить дело находящееся по переданному индексу,                                               //  проверьте возможность удаления дела
    }

    public ArrayList<String> getTodos() {
        return todoList;   // TODO: вернуть список дел
    }
    public void list(){
        for (int i = 0; i < todoList.size(); i++){
            System.out.println(i + " - " + todoList.get(i));
        }
        System.out.println("\n");
    }
    public void getCommand(String command) {
        String regex = "[A-T]{3,6}\\s*[0-9]{0,4}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(command);
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            commandMethod = command.substring(start, end);
            commandText = (command.substring(end)).trim();
        }
        int indexCommand = getIndex(commandMethod);
        String commandMethodOnly = (commandMethod.replaceAll("[0-9]","")).trim();
        if (commandMethodOnly.equals("EDIT") && indexCommand >=0){
            edit(commandText, indexCommand);
        } else if (commandMethodOnly.equals("DELETE") && indexCommand >=0){
            delete(indexCommand);
        } else if (commandMethodOnly.equals("LIST")){
            list();
        } if (commandMethodOnly.equals("ADD") && indexCommand < 0){
            add(commandText);
        } else if (commandMethodOnly.equals("ADD") && indexCommand >= 0){
            add(indexCommand, commandText);
        }
    }

    public int getIndex(String commandMethod) {
        String commandIndex = "p";
        for (int i = 0; i < commandMethod.length(); i++) {
            if (Character.isDigit(commandMethod.charAt(i))) {
                commandIndex += commandMethod.charAt(i);
            }
        }if (commandIndex.equals("p")){
            return -1;
        }
        commandIndex = commandIndex.replaceAll("p","");
        return Integer.parseInt(commandIndex);
    }
}