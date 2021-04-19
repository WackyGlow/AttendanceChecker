package AttendanceChecker.BLL;

import AttendanceChecker.Be.Teacher;
import AttendanceChecker.DAL.DAO.LoginDAO;
import AttendanceChecker.DAL.DAO.TeacherDAO;

import java.io.IOException;
import java.sql.SQLException;

public class TeacherManager {
    private TeacherDAO teacherDAO;
    private LoginDAO loginDAO;

    public TeacherManager() throws IOException {
        teacherDAO = new TeacherDAO();
        loginDAO = new LoginDAO();
    }
    public boolean validTeacherLogin(String password) throws SQLException {
        return loginDAO.validTeacherLogin(password);
    }
}
