import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TodoList {
    private final ArrayList<String> todoList = new ArrayList<>();

    public void add(String todo) {
        todoList.add(todo);
        // TODO: добавьте переданное дело в конец списка
    }

    public void add(int index, String todo) {
        index = index > todoList.size() || index < 0 ? todoList.size() : index;     // TODO: добавьте дело на указаный индекс,
        todoList.add( index, todo);
    }

    public void edit(String todo, int index) {
        if (index < 0 || index > todoList.size() - 1){          //  проверьте возможность изменения
            return;
        }
        todoList.set(index,todo);         // TODO: заменить дело на index переданным todo индекс,
    }

    public void delete(int index) {
        if (index < 0 || index > todoList.size() - 1) {
            return;
        } else {
            todoList.remove(index);                    // TODO: удалить дело находящееся по переданному индексу,                                               //  проверьте возможность удаления дела
        }
    }

    public ArrayList<String> getTodos() {
        return todoList;   // TODO: вернуть список дел
    }

    public String getCase(int index){
        return todoList.get(index);
    }
    public int getSize(){
        return todoList.size();
    }
}

