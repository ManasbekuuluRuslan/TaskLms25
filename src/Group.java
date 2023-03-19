
import java.util.List;

public class Group {
    private int id;
    private String groupName;
    private String description;
    private List<Student> students;
    private List<Lesson> lessons;

    public Group(int id, String groupName, String description, List<Student> students, List<Lesson> lessons) {
        this.id = id;
        this.groupName = groupName;
        this.description = description;
        this.students = students;
        this.lessons = lessons;
    }

    public Group() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }

    @Override
    public String toString() {
        return "Group " +"\n"+
                "id = " + id +"\n"+
                "Группанын аты = " + groupName + "\n" +
                "Суроттомосу = " + description + "\n" +
                "Студенттер = " + students + "\n"+
                "Сабактар ="  + lessons +"\n";
    }
}
