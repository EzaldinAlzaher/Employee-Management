package employeemaneger.Classes;

import java.util.ArrayList;

public class Comment {

    private int id;
    public String CommentText;
    public int CommentId;
    public int EmployeeId;
    public int PlanId;
    public Employee employee;
    public Plan plan;
    public Comment comment;

    public ArrayList<Comment> comments = new ArrayList<>();

    public Comment(String CommentText, Comment comment, Employee employee, Plan plan) {
        this.id = getNewId();
        this.CommentText = CommentText;
        if (comment != null) {
            this.CommentId = comment.getId();
        } else {
            this.CommentId = -1;
        }
        if (employee != null) {
            this.EmployeeId = employee.getId();
        } else {
            this.EmployeeId = -1;
        }

        if (plan != null) {
            this.PlanId = plan.getId();
        } else {
            this.PlanId = -1;
        }
        Serveces.comments.add(this);
    }

    // Gatter And Satter
    public int getId() {
        return id;
    }

    public String getCommentText() {
        return CommentText;
    }

    public void setCommentText(String CommentText) {
        this.CommentText = CommentText;
    }

    // دالة لتوليد معرف جديد لكل غرض
    public static int getNewId() {
        return Serveces.comments.size() + 1;
    }

    public void printdata() {
        System.out.println("Id: " + id);
        System.out.println("Comment Text: " + CommentText);
        System.out.println("Comment Id: " + CommentId);
        System.out.println("Employee Id: " + EmployeeId);
        System.out.println("Plan Id: " + PlanId);
    }

}
