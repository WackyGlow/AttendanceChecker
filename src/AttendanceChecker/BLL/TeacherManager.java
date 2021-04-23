package AttendanceChecker.BLL;

import AttendanceChecker.Be.Teacher;
import AttendanceChecker.DAL.DAO.LoginDAO;
import AttendanceChecker.DAL.DAO.TeacherDAO;

import java.io.IOException;
import java.sql.SQLException;

public class TeacherManager {
    private TeacherDAO teacherDAO;
    private LoginDAO loginDAO;

    /**
     * this is the constructor of the class
     * @throws IOException
     */
    public TeacherManager() throws IOException {
        teacherDAO = new TeacherDAO();
        loginDAO = new LoginDAO();
    }

    /**
     * Checks if the entered password is correct
     * @param password
     * @return
     * @throws SQLException
     */
    public boolean validTeacherLogin(String password) throws SQLException {
        return loginDAO.validTeacherLogin(password);
    }
}
