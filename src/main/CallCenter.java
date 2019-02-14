package main;

import java.util.Stack;

public class CallCenter {


    private Stack<Employee> respondents = new Stack<>();
    private Stack<Employee> directors = new Stack<>();
    private Stack<Employee> managers = new Stack<>();

    public void addEmployee(Employee emp) {
        switch (emp.getType()) {
            case Respondent:
                respondents.push(emp);
                return;
            case Manager:
                managers.push(emp);
                return;
            case Director:
                directors.push(emp);
                return;
            default:
                System.out.println("Error : employee type not found");
        }
    }

    public void dispatchCall(Call call) {

        Employee emp;
        boolean assigned = false;

        if (!respondents.isEmpty()) {
            // respondent is available
            emp = respondents.pop();
            emp.setFree(false);
            call.setHandler(emp);
            assigned = true;
        } else {
            System.out.println(call.getCaller() + ": Respondent not available.. please call again");
            return;
        }

        // in due course of time

        while (assigned && call.getNeedRank() != call.getHandler().getType()) {
            emp = call.getHandler();
            emp.setFree(true);
            addEmployee(emp);
            call.setHandler(null);
            // escalate to nextLevel
            assigned = escalate(call, emp.getType().getLevel() + 1);
        }
    }

    private boolean escalate(Call call, int level) {

        switch (level) {
            case 1: // manager
                if (!managers.isEmpty()) {
                    // respondent is available
                    Employee emp = managers.pop();
                    emp.setFree(false);
                    call.setHandler(emp);
                    return true;
                } else {
                    System.out.println(call.getCaller() + ": No manager available, escalating to director");
                    return escalate(call, level + 1);
                }

            case 2: // director
                if (!directors.isEmpty()) {
                    // send to director
                    Employee emp = directors.pop();
                    emp.setFree(false);
                    call.setHandler(emp);
                    return true;
                } else {
                    System.out.println(call.getCaller() + ": No director available.. please call again");
                    return false;
                }

            default:
                System.out.println(call.getCaller() + ": Error : employee level not found [" + level + "]");
                return false;
        }
    }

    public void printCallCenterStat() {
        // how busy is it
        System.out.println("Free respondents " + respondents.size());
        System.out.println("Free managers " + managers.size());
        System.out.println("Free directors " + directors.size());
    }

    public void endCall(Call call) {
        // in due course of time
        System.out.println(call.getCaller() + ": ending call now ......");
        Employee emp = call.getHandler();
        if (emp != null) { // if null means call was never accepted
            emp.setFree(true);
            addEmployee(emp);
            call.setHandler(null);
        }
    }
}
