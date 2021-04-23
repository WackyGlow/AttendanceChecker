package AttendanceChecker.GUI.Model;

import AttendanceChecker.BLL.TeacherManager;

import java.io.IOException;
import java.sql.SQLException;

public class TeacherModel {
    private TeacherManager teacherManager;

    /**
     * constructor for the teacher model
     * @throws IOException
     */
    public TeacherModel() throws IOException {
        teacherManager = new TeacherManager();
    }

    /**
     * Checkes if the entered password is correct
     * @param password
     * @return
     * @throws SQLException
     */
    public boolean validTeacherLogin(String password) throws SQLException {
        return teacherManager.validTeacherLogin(password);
    }
}
