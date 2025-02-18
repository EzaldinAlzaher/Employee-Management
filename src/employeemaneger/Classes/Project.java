package employeemaneger.Classes;

import java.util.ArrayList;

public class Project {

    private int id;
    private String projectName;
    public String descirption;

    // (قائمة خاصة بالغرض)
    public ArrayList<Plan> Plans = new ArrayList<>();

    public Project(String projectName, String descirption) throws Exception {
        this.id = getNewId();
        setProjectName(projectName);
        this.descirption = descirption;
        Serveces.projects.add(this);
    }

    // Gatter And Satter
    public int getId() {
        return id;
    }

    public void setProjectName(String projectName) throws Exception {
        // شرط ان يكون اسم المشروع اكبر من حرفين
        if (projectName.length() > 2) {
            this.projectName = projectName;
        } else {
            throw new Exception("Error Entering Project Name, Please try again");
        }
    }

    public String getProjectName() {
        return projectName;
    }

    // دالة لتوليد معرف جديد لكل غرض
    public static int getNewId() {
        return Serveces.projects.size() + 1;
    }

    // دالة الطباعة
    public void print() {
        System.out.println("Project ID: " + id);
        System.out.println("Project Name: " + projectName);
        System.out.println("Project Descirption: " + descirption);
    }
}
