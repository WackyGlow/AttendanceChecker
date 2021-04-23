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

    /**
     * constructor for the teacher class
     * @param id
     * @param name
     * @param teachercode
     */
    public Teacher(int id, String name, String teachercode){
        this.id = id;
        this.name = new SimpleStringProperty(name);
        this.teachercode = new SimpleStringProperty(teachercode);
    }

    /**
     * getter for the name string
     * @return
     */
    public String getName() {
        return name.get();
    }

    /**
     * setter for the name string
     * @param name
     */
    public void setName(String name) {
        this.name.set(name);
    }

    /**
     * getter for the teachercode string
     * @return
     */
    public String getTeachercode() {
        return teachercode.get();
    }

    /**
     * setter for the teachercode
     * @param teachercode
     */
    public void setTeachercode(String teachercode) {
        this.teachercode.set(teachercode);
    }

}
