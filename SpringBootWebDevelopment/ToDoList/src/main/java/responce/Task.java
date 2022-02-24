package responce;

import java.time.LocalDate;

public class Task
{
    private int id;
    private String textTask;
    private ExecutorCase executor;

    public Task(int id, String textTask) {
        this.id = id;
       this.textTask = textTask;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }



    public String getTextTask() {
        return textTask;
    }

    public void setTextTask(String textTask) {
        this.textTask = textTask;
    }

    public ExecutorCase getExecutor() {
        return executor;
    }

    public void setExecutor(ExecutorCase executor) {
        this.executor = executor;
    }
}
