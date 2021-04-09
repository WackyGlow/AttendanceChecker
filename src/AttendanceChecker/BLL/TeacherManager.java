package AttendanceChecker.BLL;

import AttendanceChecker.Be.Teacher;
import AttendanceChecker.DAL.DAO.TeacherDAO;

import java.io.IOException;
import java.util.List;

public class TeacherManager {
    private TeacherDAO teacherDAO;

    public TeacherManager() throws IOException {
        teacherDAO = new TeacherDAO();
    }
}
