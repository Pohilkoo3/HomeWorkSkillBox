package main;

import responce.ExecutorCase;
import responce.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;


public class ListTasksStorage
{
    private static ConcurrentHashMap<Integer, Task> listTasks = new ConcurrentHashMap<>();

    public static List<Task> getListTasks() {
        ArrayList<Task> taskArrayList = new ArrayList<>();
        synchronized (listTasks){
            taskArrayList.addAll(listTasks.values());
        }
        return taskArrayList;
    }


    public synchronized static int addTask(Task task, ExecutorCase executorCase){
        int idTask = listTasks.size() + 1;
        task.setId(idTask);
        task.setExecutor(executorCase);
        listTasks.put(idTask, task);
        return idTask;
    }

    public static int deleteTask(int id){
        if (listTasks.containsKey(id)){
            synchronized (listTasks){
                listTasks.remove(id);
            }
            return id;
        }
        return -1;
    }

    public static Task getTaskId(int id){
        if (listTasks.containsKey(id)){
            return listTasks.get(id);
        }
        return null;
    }

    public static Task changeTextTask(int id, String text){
        Task task = getTaskId(id);
        synchronized (listTasks){
            task.setTextTask(text);
        }
        return listTasks.get(id);
    }
    public static Task changeElementAllFields (int id, String text, ExecutorCase executorCase){
        Task task = getTaskId(id);
        task.setTextTask(text);
        task.setExecutor(executorCase);
        synchronized (listTasks){
            listTasks.put(id, task);
        }
        return listTasks.get(id);
    }

    public static List<Task> deleteAllTasks(){
        listTasks.clear();
        ArrayList<Task> taskArrayList = new ArrayList<>();
        taskArrayList.addAll(listTasks.values());
        return taskArrayList;
    }
}
