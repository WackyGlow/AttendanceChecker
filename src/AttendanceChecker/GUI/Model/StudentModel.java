package AttendanceChecker.GUI.Model;

import AttendanceChecker.BLL.AttendanceManager;
import AttendanceChecker.BLL.StudentManager;
import AttendanceChecker.Be.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.sql.SQLException;

public class StudentModel {
    private AttendanceManager attendanceManager;
    private StudentManager studentManager;
    private ObservableList<Student> allStudents = FXCollections.observableArrayList();

    public StudentModel() throws IOException {
        studentManager = new StudentManager();
        attendanceManager = new AttendanceManager();
    }

    public ObservableList<Student> getAllStudents() throws IOException {
        allStudents = FXCollections.observableArrayList();
        allStudents.addAll(studentManager.getAllStudents());
        return allStudents;
    }
    public Student getStudentFromLogin(String login,String password) throws SQLException {
        return studentManager.getStudentFromLogin(login, password);
    }
    public int getTotalDays() throws SQLException {
        return studentManager.getTotalDays();
    }
    public void markAsPresent(Student student) throws IOException, SQLException {
        attendanceManager.markAsPresent(student);
    }
    public String getValueFromDay(Student student){
        return attendanceManager.getValueFromDay(student);
    }
}

