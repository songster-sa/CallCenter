package main;

public enum EmployeeType {

    Respondent(0),
    Manager(1),
    Director(2);

    private final int level;


    EmployeeType(int level) {
        this.level = level;
    }

    public int getLevel() {
        return this.level;
    }
}
