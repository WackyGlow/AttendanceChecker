package AttendanceChecker.Be;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.List;

public class Teacher {
    private final int id;
    private StringProperty name;
    private StringProperty teachercode;
    private List<Course> courses;
    private List<Integer> courseId;


    public Teacher(int id, String name, String teachercode){
        this.id = id;
        this.name = new SimpleStringProperty(name);
        this.teachercode = new SimpleStringProperty(teachercode);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getTeachercode() {
        return teachercode.get();
    }

    public void setTeachercode(String teachercode) {
        this.teachercode.set(teachercode);
    }

}
