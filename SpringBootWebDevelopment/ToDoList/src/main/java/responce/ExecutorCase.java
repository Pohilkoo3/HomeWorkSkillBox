package responce;

public class ExecutorCase
{
    private int idExecutor;
    private String name;
    private String surName;
    private int age;

    public ExecutorCase(String name, int id) {
        this.name = name;
        this.idExecutor = id;

    }

    public int getIdExecutor() {
        return idExecutor;
    }

    public void setIdExecutor(int idExecutor) {
        this.idExecutor = idExecutor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
