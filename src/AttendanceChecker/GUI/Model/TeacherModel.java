package AttendanceChecker.GUI.Model;

import AttendanceChecker.BLL.TeacherManager;

import java.io.IOException;
import java.sql.SQLException;

public class TeacherModel {
    private TeacherManager teacherManager;

    public TeacherModel() throws IOException {
        teacherManager = new TeacherManager();
    }

    public boolean validTeacherLogin(String password) throws SQLException {
        return teacherManager.validTeacherLogin(password);
    }
}
