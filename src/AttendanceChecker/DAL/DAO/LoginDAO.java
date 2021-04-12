package AttendanceChecker.DAL.DAO;

import AttendanceChecker.Be.Student;
import AttendanceChecker.DAL.DBConnection.JDBCConnectionPool;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LoginDAO {

    private final JDBCConnectionPool connectionPool;
    private int id;
    private String name;
    private int absentDays;
    private boolean presentToday;
    public LoginDAO() throws IOException {
        connectionPool = JDBCConnectionPool.getInstance();
    }


    public Student getStudentFromLogin(String login, String password) throws SQLException {
        Connection connection = connectionPool.checkOut();
        String sql = "Select * from Student INNER JOIN StudentLogin ON Student.StudentID = StudentLogin.StudentID WHERE StudentLogin.StudentLogin = ? AND StudentLogin.StudentPassword = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, login);
        statement.setString(2, password);
        ResultSet resultSet = statement.executeQuery();
        Student student = null;
        if (resultSet.next()) {
            student = new Student(id,name,absentDays,presentToday);
            id = resultSet.getInt("StudentId");
            name = resultSet.getString("StudentName");
            absentDays = resultSet.getInt("AbsentDays");
            presentToday = resultSet.getBoolean("PresentToday");
        }
        return student;
    }
}
