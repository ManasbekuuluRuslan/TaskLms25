import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Project implements Methods{

    List<Group> groups = new ArrayList<>();
    @Override
    public void addNewGroup() {
        try {
            Group group = new Group();
            List<Student> students = new ArrayList<>();
            List<Lesson> lessons = new ArrayList<>();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Группанын атын жазыныз: ");
            String name = scanner.nextLine();
            group.setGroupName(name);
            for (Group a : groups) {
                if (a.getGroupName().equalsIgnoreCase(name)) {
                    throw new MyException("Мындай группа бар!");
                }
            }
            System.out.println("Группанын суроттомосун жазыныз");
            Scanner scanner1 = new Scanner(System.in);
            String des = scanner1.nextLine();
            group.setDescription(des);
            group.setId(groups.size() + 1);
            group.setStudents(students);
            group.setLessons(lessons);
            groups.add(group);
            System.out.println(group + " Группасы ийгиликтүү сакталды!");
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
    }
    @Override
    public void getGroupByName() {
     ArrayList<Group> groups1 = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Группанын атын жазыныз: ");
        String a = scanner.nextLine();
        try{
            for (Group c: groups) {
                if(c.getGroupName().equals(a)){
                    groups1.add(c);
                    break;
                }
            }
            if(!groups1.isEmpty()){
                for(Group c : groups1){
                    System.out.println(c);
                }
            }else{
                throw new MyException("Мындай группа жок!");
            }
        }catch (MyException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void upDateGroupName() {
       ArrayList<Group> groups1 = new ArrayList<>();
       Scanner scanner = new Scanner(System.in);
        System.out.println("Группанын атын жазыныз: ");
        String name = scanner.nextLine();
        try{
            for (Group c : groups){
                if(c.getGroupName().equals(name)){
                    groups1.add(c);
                    break;
                }
                }if(!groups1.isEmpty()){
                    for(Group c : groups){
                        Scanner scanner1 = new Scanner(System.in);
                        System.out.println("Жаны ат жазыныз: ");
                        String name1 = scanner1.nextLine();
                        c.setGroupName(name1);
                        System.out.println(c.getGroupName() +" Жаны группанын аты ийгиликтуу сакталды!");
                        System.out.println(c);
                    }
            }else{
                throw new MyException("Мындай группа жок!");
            }
        }catch (MyException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void getAllGroups() {
      for(Group s : groups){
          System.out.println(s.toString());
      }
    }

    @Override
    public void addNewStudentsToGroup() {
      ArrayList<Group> groups1 = new ArrayList<>();
      Student student = new Student();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Группанын атын жазыныз: ");
        String name = scanner.nextLine();
        for(Group c : groups){
            if(c.getGroupName().equals(name)){
                groups1.add(c);
                break;
            }
        }try{
            if(!groups1.isEmpty()){
                for(Group c : groups1){
                    System.out.println("Студенттин толук атын жазыныз: ");
                    Scanner scanner1 = new Scanner(System.in);
                    String name1 = scanner1.nextLine();
                    student.setName(name1);
                    System.out.println("Почтасын жазыныз: ");
                    Scanner scanner2 = new Scanner(System.in);
                    String gmail = scanner2.nextLine();
                    if(gmail.contains("@")){
                        student.setEmail(gmail);
                    }else{
                        throw new MyException("@ символун жазыныз!!!");
                    }
                    for (Group a : groups){
                        if(a.getStudents().isEmpty()){
                            for(Student student1 : a.getStudents()){
                                if(student1.equals(gmail)){
                                    throw new MyException("Ошол эле gmail");
                                }else{
                                    break;
                                }
                            }
                        }
                    }
                    System.out.println("Паролун жазыныз: ");
                    Scanner scanner3 = new Scanner(System.in);
                    String password  = scanner3.nextLine();
                    if(password.length() < 7){
                        throw new MyException("Паролдун узундугу кеминде 7 сөз болушу керек!!!");
                    }else{
                        student.setPassport(password);
                        c.getStudents().add(student);
                        System.out.println(c);

                    }
                }
            }else {
                throw new MyException("Мындай группа жок!");
            }
        }catch (MyException e){
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void upDateStudent() {
         ArrayList<Student> studentArrayList = new ArrayList<>();
         try{
             Scanner scanner = new Scanner(System.in);
             System.out.println("Студенттин почтасын жазыныз: ");
             String name = scanner.nextLine();
             if(!name.contains("@")){
                 throw new MyException("@ символун жазыныз!!!");
             }for (Group g : groups){
                 for(Student a : g.getStudents()){
                     if(a.getEmail().equals(name)){
                         studentArrayList.add(a);
                         break;
                     }
                 } if(!studentArrayList.isEmpty()){
                     for(Student s : studentArrayList){
                         Scanner scanner1 = new Scanner(System.in);
                         System.out.println("Студенттин паролун жазыныз: ");
                         String parol = scanner1.nextLine();
                         if(s.getPassport().equals(parol)){
                         }else{
                             throw new MyException("туура эмес пароль");
                         }
                         System.out.println("Жаны студенттин толук атын жазыныз: ");
                         Scanner scanner2 = new Scanner(System.in);
                         String allName = scanner2.nextLine();
                         s.setName(allName);
                         System.out.println(s.getName()+ "Ийгиликтуу сактаалды!!!");
                         break;
                     }
                 }else{
                     throw new MyException("@ символун жазыныз!!!");
                 }
             }
         }catch (MyException e){
             System.out.println(e.getMessage());
         }
    }

    @Override
    public void findStudentByFirstName() {
        ArrayList<Student> studentArrayList = new ArrayList<>();
        System.out.println("Студенттин атын жазыныз: ");
        Scanner scanner1 = new Scanner(System.in);
        String name = scanner1.nextLine();
        for(Group g : groups){
            for(Student s : g.getStudents()){
                if(s.getName().equals(name)){
                    studentArrayList.add(s);
                    break;
                }
            }if(!studentArrayList.isEmpty()){
                for(Student s : studentArrayList){
                    System.out.println(s.toString());
                }
            }
        }
    }

    @Override
    public void getAllStudentsByGroupName() {
         ArrayList<Group> groups1 = new ArrayList<>();
        System.out.println("Группанын атын жазыныз: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        try{
            for(Group g : groups){
                if(g.getGroupName().equals(name)){
                    groups1.add(g);
                    break;
                }
            }if(!groups1.isEmpty()){
                for(Group g : groups1){
                    System.out.println(g.getStudents());
                }
            }else{
                throw new MyException("Мындай группа жок!!!");
            }
        }catch (MyException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void getAllStudentsLesson() {
        ArrayList<Group> studentLesson = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Студенттин почтасын жазыныз: ");
        String gmail = scanner.nextLine();
        for (Group g : groups){
            if(g.toString().contains(gmail)){
                studentLesson.add(g);
                break;
            }
        }try{
            if(!studentLesson.isEmpty()){
                for (Group g : studentLesson){
                    System.out.println(g);
                }
            }else{
                throw new MyException("Мындай почта жок!!!");
            }
        }catch (MyException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteStudent() {
       Student student = null;
       ArrayList<Student> studentArrayList = new ArrayList<>();
       Scanner scanner = new Scanner(System.in);
       String name = scanner.nextLine();
        System.out.println("Студенттин почтасын жазыныз: ");
        for(Group g : groups){
            for(Student s : g.getStudents()){
                if(s.getEmail().equals(name)){
                    student = s;
                    studentArrayList.add(s);
                    break;
                }
            }
            try{
                if(!studentArrayList.isEmpty()){
                    for(int i = 0; i < g.getStudents().size(); i++){
                        g.getStudents().remove(student);
                        System.out.println(name+" атту студент ийгиликту очурулду!");
                    }
                }else{
                    throw new MyException("Студенттин аты туура емес!!!");
                }
            }catch (MyException e){
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public void addNewLessonToGroup() {
        ArrayList<Group> newLesson = new ArrayList<>();
        Lesson lesson = new Lesson();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Группанын атын жазыныз: ");
        String name = scanner.nextLine();
        for(Group g : groups){
           if(g.getGroupName().equals(name)){
               newLesson.add(g);
               break;
           }
        }
        try{
            if(!newLesson.isEmpty()){
                for(Group g : newLesson){
                    System.out.println("Сабактын атын жазыныз: ");
                    Scanner scanner1 = new Scanner(System.in);
                    String name1 = scanner1.nextLine();
                    lesson.setLessonName(name1);
                    Scanner scanner2 = new Scanner(System.in);
                    System.out.println("Сабактын суроттомосун жазыныз: ");
                    String name2 = scanner2.nextLine();
                    lesson.setDescription(name2);
                    lesson.setId(g.getLessons().size()+1);
                    g.getLessons().add(lesson);
                    System.out.println(lesson.getLessonName() + " Сабагы ийгиликтуу сакталды!");
                }
            }else {
                throw new MyException("Мындай группа жок!!!");
            }
        }catch (MyException e){
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void getLessonByName() {
        ArrayList<Lesson> lessons = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Сабактын атын жазыныз: ");
        String name = scanner.nextLine();

        for (Group g : groups){
            for (Lesson l : g.getLessons()){
                if(l.getLessonName().equals(name)){
                    lessons.add(l);
                    break;
                }
            }
        }
        try{
            if(!lessons.isEmpty()){
                for(Lesson l : lessons){
                    System.out.println(l.toString());
                }
            }else{
                throw new MyException("Мындай сабактын аты жок!!!");
            }
        }catch (MyException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void getAllLessonByGroupName() {
      ArrayList<Group> lessons = new ArrayList<>();
      Scanner scanner = new Scanner(System.in);
        System.out.println("Группанын атын жазыныз: ");
        String name = scanner.nextLine();
        try{
            for(Group g : groups){
                if(g.getGroupName().equals(name)){
                    lessons.add(g);
                    break;

                }
            }
            if(!lessons.isEmpty()){
                for(Group g : lessons){
                    System.out.println(g.getLessons());
                    break;
                }
            }else{
                throw new MyException("Мындай группа табылган жок!!!");
            }
        }catch (MyException e){
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void deleteLesson() {
       ArrayList<Lesson> lessons = new ArrayList<>();
       Lesson lesson = null;
       Scanner scanner = new Scanner(System.in);
        System.out.println("Сабактын атын жазыныз: ");
        String name = scanner.nextLine();
        try{
        for (Group g: groups) {
            for(Lesson l : g.getLessons()){
                if(l.getLessonName().equals(name)){
                    lesson = l;
                    lessons.add(l);
                    break;
                }
            }
            if(!lessons.isEmpty()){
                for (int i = 0; i < g.getLessons().size(); i++) {
                    g.getLessons().remove(lesson);
                    System.out.println(lesson +" сабагы ийгиликтуу очурулду!!!");
                }
            }else{
                throw new MyException("Мындай сабак табылган жок!!!");
            }
        }
    }catch (MyException e){
            System.out.println(e.getMessage());
        }}
    @Override
    public void deleteGroup() {
       ArrayList<Group> groupArrayList = new ArrayList<>();
       Scanner scanner = new Scanner(System.in);
        System.out.println("Группанын атын жазыныз: ");
        String name = scanner.nextLine();
        try{
            for(Group g : groups){
                if (g.getGroupName().equals(name)) {
                    groupArrayList.add(g);
                    break;
                }
            }if(!groupArrayList.isEmpty()){
                for(Group g : groupArrayList){
                    groups.remove(g);
                    System.out.println(g.getGroupName() + " группасы ийгиликтуу очурулду!");
                }
            }else {
                throw new MyException("Мындай группа табылган жок!!!");
            }
        }catch (MyException e){
            System.out.println(e.getMessage());
        }
    }
}