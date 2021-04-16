package AttendanceChecker.BLL;

import AttendanceChecker.Be.Student;
import AttendanceChecker.DAL.DAO.StudentDAO;

import java.io.IOException;
import java.sql.SQLException;

public class AttendanceManager {
    private StudentDAO studentDAO;

    public AttendanceManager() throws IOException {
        studentDAO = new StudentDAO();
    }

    public void markAsPresent(Student student) throws IOException, SQLException {
        studentDAO.markStudentAsPresent(student);
    }
}
