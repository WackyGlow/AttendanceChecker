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

    /**
     * constructor of the student model
     * @throws IOException
     */
    public StudentModel() throws IOException {
        studentManager = new StudentManager();
        attendanceManager = new AttendanceManager();
    }

    /**
     * Gets a list of all students from the database
     * @return
     * @throws IOException
     */
    public ObservableList<Student> getAllStudents() throws IOException {
        allStudents = FXCollections.observableArrayList();
        allStudents.addAll(studentManager.getAllStudents());
        return allStudents;
    }

    /**
     * gets a student from the database based on the username and password
     * @param login
     * @param password
     * @return
     * @throws SQLException
     */
    public Student getStudentFromLogin(String login,String password) throws SQLException {
        return studentManager.getStudentFromLogin(login, password);
    }

    /**
     * gets the total days from the database
     * @return
     * @throws SQLException
     */
    public int getTotalDays() throws SQLException {
        return studentManager.getTotalDays();
    }

    /**
     * marks the student as present in the database
     * @param student
     * @throws IOException
     * @throws SQLException
     */
    public void markAsPresent(Student student) throws IOException, SQLException {
        attendanceManager.markAsPresent(student);
    }

    /**
     * Gets the day where the given student has the most absence
     * @param student
     * @return
     */
    public String getValueFromDay(Student student){
        return attendanceManager.getValueFromDay(student);
    }
}

