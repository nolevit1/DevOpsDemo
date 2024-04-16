package ch.zhaw.iwi.devops.demo;

public class Employee {
    private int id;
    private String name;
    private String job;

    public Employee() {
    }
    
    public Employee(int id, String name, String job) {
        this.id = id;
        this.name = name;
        this.job = job;
    }

    public int getId() {
        return id;
    }    

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }
}
