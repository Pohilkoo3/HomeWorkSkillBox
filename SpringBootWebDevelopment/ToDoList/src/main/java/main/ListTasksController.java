package main;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import responce.ExecutorCase;
import responce.Task;
import java.util.List;


@RestController
public class ListTasksController
{
    @RequestMapping(value = "/tasks/", method = RequestMethod.GET)
    public static List<Task> getAllTasks()
    {
    return ListTasksStorage.getListTasks();
    }

    @PostMapping("/tasks/")
    public static int addTask(Task task, ExecutorCase executorCase)
    {
        return ListTasksStorage.addTask(task, executorCase);
    }

    @RequestMapping(value = "/tasks/{id}", method = RequestMethod.DELETE)
    public static int deleteTask(@PathVariable int id)
    {
        return ListTasksStorage.deleteTask(id);//может вернуться -1 или id
    }

    @GetMapping("/tasks/{id}")
    public static ResponseEntity getTaskId(@PathVariable int id)
    {
        Task task = ListTasksStorage.getTaskId(id);
        if (task == null){
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return new ResponseEntity(task, HttpStatus.OK);
    }

    @PatchMapping("/tasks/{id}")
    public static Task changeElementAllFields(@PathVariable int id, String textTask, ExecutorCase executorCase){
        return ListTasksStorage.changeElementAllFields(id, textTask, executorCase);
    }
    @RequestMapping(value = "/tasks/", method = RequestMethod.DELETE)
    public static List<Task> deleteAllTasks(){
        return ListTasksStorage.deleteAllTasks();
    }


}
