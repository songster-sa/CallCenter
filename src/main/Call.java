package main;

public class Call {

    private Employee handler;
    private EmployeeType needRank;
    private String caller;

    // can add more details like caller details or timestamp etc

    public Employee getHandler() {
        return handler;
    }

    public void setHandler(Employee handler) {
        if (handler != null) {
            System.out.println(caller + " is handled by " + handler.getName());
        }
        this.handler = handler;
    }

    public String getCaller() {
        return caller;
    }

    public void setCaller(String caller) {
        this.caller = caller;
    }

    public EmployeeType getNeedRank() {
        return needRank;
    }

    public void setNeedRank(EmployeeType needRank) {
        this.needRank = needRank;
    }

    public Call(EmployeeType needRank, String caller) {
        this.needRank = needRank;
        this.caller = caller;
    }
}
