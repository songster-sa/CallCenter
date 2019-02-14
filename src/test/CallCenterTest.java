package test;

import main.Call;
import main.CallCenter;
import main.Employee;
import main.EmployeeType;

public class CallCenterTest {

    static CallCenter callCenter = new CallCenter();

    public static void main(String arg[]) {

        // empty call center
        emptyCallCenter();
        System.out.println("---------------------------------");

        // only 1 respondent
        onlyRespondent();
        System.out.println("---------------------------------");

        // with everyone
        fullCenter();
    }

    private static void fullCenter() {
        callCenter.addEmployee(new Employee("Res2", EmployeeType.Respondent));
        callCenter.addEmployee(new Employee("Res3", EmployeeType.Respondent));
        callCenter.addEmployee(new Employee("Man1", EmployeeType.Manager));
        callCenter.addEmployee(new Employee("Man2", EmployeeType.Manager));
        callCenter.addEmployee(new Employee("Dir", EmployeeType.Director));

        Call call = new Call(EmployeeType.Respondent, "Caller1");
        callCenter.dispatchCall(call);
        callCenter.printCallCenterStat();
        callCenter.endCall(call);
        callCenter.printCallCenterStat();

        Call call2 = new Call(EmployeeType.Manager, "Caller2");
        callCenter.dispatchCall(call2);
        callCenter.printCallCenterStat();
        // call 2 not end but no one has been assigned anyway
        Call call3 = new Call(EmployeeType.Respondent, "Caller3");
        callCenter.dispatchCall(call3);
        callCenter.endCall(call2);
        callCenter.endCall(call3);

        Call call4 = new Call(EmployeeType.Manager, "Caller4");
        callCenter.dispatchCall(call4);
        callCenter.printCallCenterStat();
        Call call5 = new Call(EmployeeType.Respondent, "Caller5");
        callCenter.dispatchCall(call5);
        Call call6 = new Call(EmployeeType.Director, "Caller6");
        callCenter.dispatchCall(call6);
        callCenter.printCallCenterStat();
        Call call7 = new Call(EmployeeType.Manager, "Caller7");
        callCenter.dispatchCall(call7);

        System.out.println("ending everything now.........");
        callCenter.printCallCenterStat();
        callCenter.endCall(call4);
        callCenter.endCall(call5);
        callCenter.endCall(call6);
        callCenter.endCall(call7);
        callCenter.printCallCenterStat();
    }

    private static void onlyRespondent() {
        callCenter.addEmployee(new Employee("Res1", EmployeeType.Respondent));
        Call call = new Call(EmployeeType.Respondent, "Caller1");
        callCenter.dispatchCall(call);
        callCenter.printCallCenterStat();
        callCenter.endCall(call);
        callCenter.printCallCenterStat();

        Call call2 = new Call(EmployeeType.Manager, "Caller2");
        callCenter.dispatchCall(call2);
        callCenter.printCallCenterStat();
        // call 2 not end but no one has been assigned anyway
        Call call3 = new Call(EmployeeType.Respondent, "Caller3");
        callCenter.dispatchCall(call3);
        callCenter.endCall(call2);
        callCenter.endCall(call3);
    }

    private static void emptyCallCenter() {
        callCenter.printCallCenterStat();
        Call call = new Call(EmployeeType.Respondent, "Caller1");
        callCenter.dispatchCall(call);
        callCenter.printCallCenterStat();
        callCenter.endCall(call);
    }
}
