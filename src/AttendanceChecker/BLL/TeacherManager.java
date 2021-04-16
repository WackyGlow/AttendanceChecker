package AttendanceChecker.BLL;

import AttendanceChecker.Be.Teacher;
import AttendanceChecker.DAL.DAO.TeacherDAO;

import java.io.IOException;

public class TeacherManager {
    private TeacherDAO teacherDAO;

    public TeacherManager() throws IOException {
        teacherDAO = new TeacherDAO();
    }
}
