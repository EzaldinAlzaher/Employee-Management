package employeemaneger.Classes;

import java.time.LocalDate;
import java.util.ArrayList;

public class Employee {

    private int id;
    private String firstName;
    private String lastName;
    private String father;
    private String mother;
    private String username;
    private String password;
    public LocalDate lastLogin;

    // (مصفوفة خاصة بالغرض )
    public ArrayList<Comment> comments = new ArrayList<>();

    // (مصفوفة خاصة بالغرض )
    public ArrayList<Task> tasks = new ArrayList<>();

    public Employee(String firstName, String lastName, String father, String mother, String username, String password) throws Exception {
        this.id = getNewId();
        setFirstName(firstName);
        setLastName(lastName);
        setfatherName(father);
        setMotherName(mother);
        setUsername(username);
        setPassword(password);
        Serveces.employees.add(this);
        setLastLogin(LocalDate.now());
    }

    // Gatter And Satter
    public int getId() {
        return this.id;
    }

    public void setFirstName(String fn) throws Exception {
        if (fn.length() > 2) {
            firstName = fn;
        } else {
            throw new Exception("Error Entering First Name, Please try again");
        }
    }

    public LocalDate getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(LocalDate lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String ln) throws Exception {
        if (ln.length() > 2) {
            lastName = ln;
        } else {
            throw new Exception("Error Entering Last Name, Please try again");
        }
    }

    public String getLasttName() {
        return lastName;
    }

    public void setfatherName(String fn) throws Exception {
        if (fn.length() > 2) {
            father = fn;
        } else {
            throw new Exception("Error Entering Father Name, Please try again");
        }
    }

    public String getFatherName() {
        return father;
    }

    public void setMotherName(String mn) throws Exception {
        if (mn.length() > 2) {
            mother = mn;
        } else {
            throw new Exception("Error Entering Mother Name, Please try again");
        }
    }

    public String getMotherName() {
        return mother;
    }

    public void setUsername(String un) throws Exception {
        if (un.length() > 1) {
            username = un;
        } else {
            throw new Exception("Error Entering Username, Please try again");
        }
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String pass) throws Exception {
        if (pass.length() >= 8) {
            password = pass;
        } else {
            throw new Exception("Error Entering Password, Please try again");
        }
    }

    public String getPassword() {
        return password;
    }

    // دالة لتوليد معرف جديد لكل غرض
    public int getNewId() {
        return Serveces.employees.size() + 1;
    }

    // دالة الطباعة
    public void printdata() {
        System.out.println("Id: " + id);
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Father: " + father);
        System.out.println("Mother: " + mother);
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
        System.out.println("lastLogin: " + lastLogin);
    }

}
