import java.util.ArrayList;

public class TodoList {

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
}
