package AttendanceChecker.BLL;

import AttendanceChecker.Be.Student;
import AttendanceChecker.DAL.DAO.LoginDAO;
import AttendanceChecker.DAL.DAO.StudentDAO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class StudentManager {
    private StudentDAO studentDAO;
    private LoginDAO loginDAO;

    /**
     * this is the constructor for the StudentManager class
     * @throws IOException
     */
    public StudentManager() throws IOException {
        studentDAO = new StudentDAO();
        loginDAO = new LoginDAO();
    }

    /**
     * retrieves a list of students from the database
     * @return
     * @throws IOException
     */
    public List<Student> getAllStudents() throws IOException{
        return studentDAO.getAllStudents();
    }

    /**
     * Retrieves a student from the database using the entered username and password
     * @param login
     * @param password
     * @return
     * @throws SQLException
     */
    public Student getStudentFromLogin(String login,String password) throws SQLException {
        return loginDAO.getStudentFromLogin(login,password);
    }

    /**
     * gets the amount of total days from the database
     * @return
     * @throws SQLException
     */
    public int getTotalDays() throws SQLException {
        return studentDAO.getTotalDays();
    }
}
