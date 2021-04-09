package AttendanceChecker.GUI.Model;

import AttendanceChecker.BLL.StudentManager;
import AttendanceChecker.Be.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;

public class StudentModel {
    private StudentManager studentManager;
    private ObservableList<Student> allStudents = FXCollections.observableArrayList();

    public StudentModel() throws IOException {
        studentManager = new StudentManager();
    }

    public ObservableList<Student> getAllStudents() throws IOException {
        allStudents = FXCollections.observableArrayList();
        allStudents.addAll(studentManager.getAllStudents());
        return allStudents;
    }
}

