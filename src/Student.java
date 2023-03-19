import java.util.ArrayList;
import java.util.Scanner;

public class Student{
    private int id;
    private String name;
    private String email;
    private String passport;


    public Student(int id, String name, String email, String passport) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.passport = passport;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }
    public Student (){

    }

    @Override
    public String toString() {
        return "Student: " + "id= " + id + ", Аты = " + name + "\n"
                + ", Почтасы = " + email +  ", Паролу = " + passport +"\n";
    }
}