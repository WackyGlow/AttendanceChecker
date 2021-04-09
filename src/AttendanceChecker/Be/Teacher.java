package AttendanceChecker.Be;

import java.util.List;

public class Teacher {
    private int id;
    private String name;
    private String teachercode;
    private List<Course> courses;
    private List<Integer> courseId;


    public Teacher(int id, String name, String teachercode){
        this.id = id;
        this.name = name;
        this.teachercode = teachercode;
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

    public String getTeachercode() {
        return teachercode;
    }

    public void setTeachercode(String teachercode) {
        this.teachercode = teachercode;
    }
    
}
