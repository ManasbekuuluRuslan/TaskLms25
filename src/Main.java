import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int a = LocalDateTime.now().getHour();
        int b = LocalDateTime.now().getMinute();
        System.out.println("Азыркы убак -> " + a + ":" + b);
        if (a >= 5 && a <= 11) {
            System.out.println("Кутман тан!");
        } else if (a >= 11 && a <= 17) {
            System.out.println("Кутман кун!");
        } else if (a >= 17 && a <= 22) {
            System.out.println("Кутман кеч!");
        } else {
            System.out.println("Кутман тун!");
        }

        Admin admin = new Admin();
        admin.setAdminGmail("rusi.studio.kgz@gmail.com");
        admin.setPassword("rusi");

        System.out.println("Катталган болсонуз 1 басыныз, пароль унутуп калып озгортуу учун 2 басыныз!");
        Scanner scanner = new Scanner(System.in);
        int ay = scanner.nextInt();
        while (true) {
            if (ay == 1) {
                try {
                    System.out.println("Почтанызды жазыныз: ");
                    Scanner scanner1 = new Scanner(System.in);
                    String name = scanner1.nextLine();
                    if (admin.getAdminGmail().equals(name)) {
                    } else if (!name.contains("@")) {
                        throw new MyException("@ белгисин жазыныз!!!");
                    } else {
                        throw new MyException("Туура емес почта!!!");
                    }
                    System.out.println("Паролунузду жазыныз: ");
                    Scanner scanner2 = new Scanner(System.in);
                    String password = scanner2.nextLine();
                    if (admin.getPassword().equals(password)) {
                        method();
                    } else {
                        throw new MyException("Туура емес пароль!!!");
                    }

                } catch (MyException e) {
                    System.out.println(e.getMessage());

                }
            }
            try {
                if (ay == 2) {
                    Scanner scanner1 = new Scanner(System.in);
                    System.out.println("Почтанызды жазыныз: ");
                    String name = scanner1.nextLine();
                    if (admin.getAdminGmail().equals(name)) {
                    } else if (!name.contains("@")) {
                        throw new MyException("@ белгисин жазыныз!!!");
                    } else {
                        throw new MyException("Туура емес почта!!!");
                    }
                    Scanner scanner2 = new Scanner(System.in);
                    System.out.println("Жаны пароль жазыныз: ");
                    String password = scanner2.nextLine();
                    if (admin.getPassword().equals(password)) {
                        throw new MyException("Мындай пароль бар!");
                    } else {
                        System.out.println("Пароль ийгиликтуу озгорду!");
                        method();
                    }
                }
            } catch (MyException e) {
                System.out.println(e.getMessage());

            }
        }
    }

    public static void method() throws MyException {
        Project project = new Project();
        System.out.println("Кош келиниз!");
        while (true) {
            System.out.println("*** Бир команда танданыз! ***\n" +
                    " 1  -> Add new group\n" +
                    " 2  -> Get group by name\n" +
                    " 3  -> Update group name\n" +
                    " 4  -> Get all groups\n" +
                    " 5  -> Add new student to group\n" +
                    " 6  -> Update student\n" +
                    " 7  -> Find student by first name\n" +
                    " 8  -> Get all students by group name\n" +
                    " 9  -> Get all student's lesson\n" +
                    " 10 -> Delete student\n" +
                    " 11 -> Add new lesson to group\n" +
                    " 12 -> Get lesson by name\n" +
                    " 13 -> Get all lesson by group name\n" +
                    " 14 -> Delete lesson\n" +
                    " 15 -> Delete group\n");

            Scanner scanner = new Scanner(System.in);
            try {
                int r = scanner.nextInt();
                switch (r) {
                    case 1:
                        project.addNewGroup();
                        break;
                    case 2:
                        project.getGroupByName();
                        break;
                    case 3:
                        project.upDateGroupName();
                        break;
                    case 4:
                        project.getAllGroups();
                        break;
                    case 5:
                        project.addNewStudentsToGroup();
                        break;
                    case 6:
                        project.upDateStudent();
                        break;
                    case 7:
                        project.findStudentByFirstName();
                        break;
                    case 8:
                        project.getAllStudentsByGroupName();
                        break;
                    case 9:
                        project.getAllStudentsLesson();
                        break;
                    case 10:
                        project.deleteStudent();
                        break;
                    case 11:
                        project.addNewLessonToGroup();
                        break;
                    case 12:
                        project.getLessonByName();
                        break;
                    case 13:
                        project.getAllLessonByGroupName();
                        break;
                    case 14:
                        project.deleteLesson();
                        break;
                    case 15:
                        project.deleteGroup();
                        break;
                    default:
                        System.out.println("Туура танданыз!!!");
                }
            }catch (Exception e){
                throw new MyException("Альфавит жана символдор менен тандого болбойт!");
            }
        }
    }
}