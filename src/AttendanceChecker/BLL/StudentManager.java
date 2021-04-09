package AttendanceChecker.BLL;

import AttendanceChecker.Be.Student;
import AttendanceChecker.DAL.DAO.LoginDAO;
import AttendanceChecker.DAL.DAO.StudentDAO;

import java.io.IOException;
import java.util.List;

public class StudentManager {
    private StudentDAO studentDAO;
    private LoginDAO loginDAO;

    public StudentManager() throws IOException {
        studentDAO = new StudentDAO();
        loginDAO = new LoginDAO();
    }

    public List<Student> getAllStudents() throws IOException{
        return studentDAO.getAllStudents();
    }



}
