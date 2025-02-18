package employeemaneger.Classes;

import java.time.LocalDate;
import java.util.ArrayList;

public class Plan {

    private int id;
    private String planName;
    private LocalDate start;
    private LocalDate end;
    public int totalHours;
    public String descirption;
    private int projectId;
    public Project project;
    
    // (مصفوفة خاصة بالغرض )
    public ArrayList<Task> Tasks= new ArrayList<>();
    // (مصفوفة خاصة بالغرض )
    public ArrayList<Comment> Comments= new ArrayList<>();

    public Plan(String planName, LocalDate start, LocalDate end, int totalHours, Project project, String descirption) throws Exception {
            this.id=getNewId();
            setPlanName(planName);
            setStart(start);
            setEnd(end);
            this.projectId = project.getId();
            this.totalHours = totalHours;
            this.descirption = descirption;
            Serveces.plans.add(this);
    }

    // Setters and Getters
    public int getId() {
        return id;
    }

    public void setPlanName(String planName) throws Exception {
        // شرط ان يكون اسم الخطة اكبر من حرفين
        if (planName.length() > 2) {
            this.planName = planName;
        } else {
            throw new Exception("Error Entering Plan Name, Please try again");
        }
    }

    public String getPlanName() {
        return planName;
    }

    public void setStart(LocalDate start) throws Exception {
        this.start=start;
    }

    public LocalDate getStart() {
        return this.start;
    }

    public void setEnd(LocalDate end) throws Exception {
        this.end=end;
    }

    public LocalDate getEnd() {
        return this.end;
    }

    public void setTotalHours(int totalHours) throws Exception {
        if (totalHours > 0) {
            this.totalHours = totalHours;
        } else {
            throw new Exception("Error Entering TootalHours, Please try again");
        }

    }

    public int getTotalHours() {
        return totalHours;
    }
    
    // دالة لتوليد معرف جديد لكل غرض
    public static int getNewId() {
        return Serveces.plans.size() + 1;
    }

    // دالة الطباعة
    public void print() {
        System.out.println("Plan ID: " + id);
        System.out.println("Plan Name: " + planName);
        System.out.println("Start: " + start);
        System.out.println("End: " + end);
        System.out.println("ProjictID : " + projectId);
        System.out.println("Total Hours: " + totalHours);
        System.out.println("Descirption: " + descirption);
    }
}
