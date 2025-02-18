package employeemaneger.Classes;

import java.time.LocalDate;
import java.util.ArrayList;

public class Serveces {

    // قائمة خاصة بالصف لتخزين الموظفين
    public static ArrayList<Employee> employees = new ArrayList<>();
    
    // قائمة خاصة بالصف لتخزين المهام
    public static ArrayList<Task> tasks = new ArrayList<>();
    
    // قائمة خاصة بالصف لتخزين المشاريع
    public static ArrayList<Project> projects = new ArrayList<>();
    
    // قائمة خاصة بالصف لتخزين الخطط
    public static ArrayList<Plan> plans = new ArrayList<>();
    
    // قائمة خاصة بالصف لتخزين التعليقات
    public static ArrayList<Comment> comments = new ArrayList<>();
    

    
    // Gitter And Setter
    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        Serveces.employees = employees;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void setTasks(ArrayList<Task> tasks) {
        Serveces.tasks = tasks;
    }

    public ArrayList<Project> getProjects() {
        return projects;
    }

    public void setProjects(ArrayList<Project> projects) {
        Serveces.projects = projects;
    }

    public ArrayList<Plan> getPlans() {
        return plans;
    }

    public void setPlans(ArrayList<Plan> plans) {
        Serveces.plans = plans;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void setComments(ArrayList<Comment> comments) {
        Serveces.comments = comments;
    }

    public ArrayList<Employee> getAllEmployee() {
        return employees;
    }

    
    
    // دالة إضافة الموظف
    public void addEmp(Employee e){
        employees.add(e);
    }
    
    
    // دالة إضافة الموظف
    public void addEmployee(Employee emp) {
        for (Employee employee : employees) {
            if (employee.equals(emp)) {
                System.out.println("This Opject already exists");
            }else{
                employees.add(emp);
                break;
            }
        }
    }

    // دالة إضافة مهمة
    public void addTask(Task task){
        for (Task item : tasks) {
            if (item.equals(task)) {
                System.out.println("This Opject already exists");
            } else {
                tasks.add(task);
                break;
            }
        }
    }

    // دالة إضافة خطة
    public void addPlan(Plan plan) {
        for (Plan plan1 : plans) {
            if (plan1.equals(plan)) {
                System.out.println("This Opject already exists");
            }else{
                plans.add(plan);
                break;
            }
 
        }
        
    }

    // دالة لإضافة المشروع
    public void addProject(Project project) {
        for (Project project1 : projects) {
            if (project1.equals(project)) {
                System.out.println("This Opject already exists");
            }else{
                projects.add(project);
                break;
            }
        }
        
    }

    // دالة إضافة تعليق
    public void addComment(Comment comment) {
        for (Comment comment1 : comments) {
            if (comment.equals(comment1)) {
                System.out.println("This Opject already exists");
            }else{
                comments.add(comment);
                break;
            }
        }
    }

    // تعديل الزمن الكلي في الخطة 
    public void modifyTotalHours(Plan plan, int newTotalHouer) throws Exception {
        for (Plan item : plans) {
            if (plan.equals(item)) {
                item.totalHours = newTotalHouer;
            } else {
                System.out.println("The Plan Not Found!");
            }
        }
    }

    //   تعديل وضع المهمة الى حالة الاكتمال وتحديد تاريخ االكتمال
    public void modifyStatus(Task task, boolean mS ,LocalDate completedDate) {
        if (mS) {
            task.status = "Complete";
        } else {
            task.status = "Not Complete";
        }
        if (completedDate.isAfter(task.getStart())) {
            task.completedDate = completedDate;
        }else{
            System.out.println("You cannot put a date before the start date of the task."); 
        }
        
    }

    // دالة للتحقق فيما اذا كان الحساب موجود أو لا
    public boolean Login(String username, String password) {
        for (Employee employee : employees) {
            if (employee.getUsername().equals(username) && employee.getPassword().equals(password)) {
                employee.lastLogin = LocalDate.now();
                return true;
            }
        }
        return false;
    }

    // دالة تقومة بإرجاع المهام التي اكتملت بيه هذين التاريخين
    public ArrayList getTaskCompleteDone(LocalDate of1, LocalDate of2) {
        ArrayList<Task> lst = new ArrayList<>();
        for (Task item : tasks) {
            if (item.getCompletedDate().isBefore(of2) && of1.getYear() == of2.getYear() && of1.getMonthValue() == of2.getMonthValue() && of2.getDayOfMonth() - of1.getDayOfMonth() <= 7) {
                lst.add(item);
            }
        }
        return lst;
    }

    // تالة تقوم بإرجاع المهام التي اخذت وقت أكثر من ما هو متوقع
    public ArrayList getTaskCompletedOverTime(LocalDate of1, LocalDate of2) {
        ArrayList<Task> lst = new ArrayList<>();
        for (Task item : tasks) {
            if (item.getCompletedDate().isAfter(of2)) {
                lst.add(item);
            }
        }
        return lst;
    }
}
