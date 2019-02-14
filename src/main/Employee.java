package main;

public class Employee {

    private String name;
    private EmployeeType type;
    private boolean isFree = true; // default

    public Employee(String name, EmployeeType type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EmployeeType getType() {
        return type;
    }

    public void setType(EmployeeType type) {
        this.type = type;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        System.out.println(name + " is " + (free ? "free" : "busy"));
        isFree = free;
    }
}
