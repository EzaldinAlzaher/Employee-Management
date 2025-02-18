package employeemaneger.Classes;

import java.time.LocalDate;
import java.util.ArrayList;

public class Task {

    private int id;
    private String taskname;
    private LocalDate start;
    private LocalDate end;
    public String status;
    public String description;
    private int numberOfHours;
    private int employeeId;
    private int planId;
    public LocalDate completedDate;
    public Employee employee;
    public Plan plan;

    public Task(String taskname, LocalDate of, LocalDate of1, String description, int numberOfHours, Employee employee, Plan plan) throws Exception {
        setTaskname(taskname);
        this.id = getNewId();
        setStart(of);
        setEnd(of1);
        this.status = "Not Combleted";
        this.description = description;
        this.numberOfHours = numberOfHours;

        if (employee != null) {
            this.employeeId = employee.getId();
        } else {
            this.employeeId = -1;
        }
        if (plan != null) {
            this.planId = plan.getId();
        } else {
            this.planId = -1;
        }

        Serveces.tasks.add(this);
    }

    // Setters and Getters
    public int getId() {
        return this.id;
    }

    public void setStart(LocalDate start) throws Exception {
        this.start = start;
    }

    public LocalDate getStart() {
        return this.start;
    }

    public void setEnd(LocalDate end) throws Exception {
        this.end = end;
    }

    public LocalDate getEnd() {
        return this.end;
    }

    public int getNumberOfHours() {
        return this.numberOfHours;
    }

    public String getStatus() {
        return status;
    }

    public int getEmployeeId() {
        return this.employeeId;
    }

    public int getPlanId() {
        return this.planId;
    }

    public LocalDate getCompletedDate() {
        return this.completedDate;
    }

    public void setTaskname(String taskname) throws Exception {
        if (taskname.length() > 2) {
            this.taskname = taskname;
        } else {
            throw new Exception("Error Entering Task Name, Please try again");
        }
    }

    public String getTaskname() {
        return taskname;
    }

    // دالة لتوليد معرف جديد لكل غرض
    public static int getNewId() {
        return Serveces.tasks.size() + 1;
    }

    // دالة الطباعة
    public void print() {
        System.out.println("Id: " + id);
        System.out.println("Start: " + start);
        System.out.println("End: " + end);
        System.out.println("Status: " + status);
        System.out.println("Description: " + description);
        System.out.println("Number of Hours: " + numberOfHours);
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Plan ID: " + planId);
        System.out.println("Completed Date: " + completedDate);
    }
}
