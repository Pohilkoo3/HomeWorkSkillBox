package main;
import main.ListTasksStorage;
import main.model.Task;
import main.model.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class ListTasksController
{
    @Autowired
    private TaskRepository taskRepository;


    @RequestMapping(value = "/tasks/", method = RequestMethod.GET)
    public List<Task> getAllTasks()
    {
      Iterable<Task> taskIterable = taskRepository.findAll();
      List<Task> listTask = new ArrayList<>();
        for (Task task : taskIterable) {
            listTask.add(task);
        }
        return listTask;
    }

    @PostMapping("/tasks/")
    public int addTask(Task task)
    {
        Task task1 = taskRepository.save(task);
        return task1.getId();
    }

    @RequestMapping(value = "/tasks/{id}", method = RequestMethod.DELETE)
    public boolean deleteTask(@PathVariable int id)
    {
        boolean isExist = taskRepository.existsById(id);
        if (isExist){
        taskRepository.deleteById(id);
    }return isExist;
    }

    @GetMapping("/tasks/{id}")
    public ResponseEntity getTaskId(@PathVariable int id)
    {
      Task task = taskRepository.findById(id).orElse(null);
      if (task == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return new ResponseEntity(task, HttpStatus.OK);
    }

    @PatchMapping("/tasks/{id}")
    public Task changeElementAllFields(@PathVariable int id, String textTask){
        Task task = taskRepository.findById(id).orElse(null);
        task.setTextTask(textTask);
        taskRepository.save(task);
        return taskRepository.findById(id).orElse(null);
    }
    @RequestMapping(value = "/tasks/", method = RequestMethod.DELETE)
    public void deleteAllTasks(){
        taskRepository.deleteAll();
    }
}