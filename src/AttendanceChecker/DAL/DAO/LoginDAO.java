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

    /**
     * Constructor for the class
     * @throws IOException
     */
    public LoginDAO() throws IOException {
        connectionPool = JDBCConnectionPool.getInstance();
    }

    /**
     * This methods returns a student object from a two given Strings which is login and password.
     * @param login
     * @param password
     * @return
     * @throws SQLException
     */
    public Student getStudentFromLogin(String login, String password) throws SQLException {
        Connection connection = connectionPool.checkOut();
        String sql = "Select * from Student INNER JOIN StudentLogin ON Student.StudentID = StudentLogin.StudentID WHERE StudentLogin.StudentLogin = ? AND StudentLogin.StudentPassword = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, login);
        statement.setString(2, password);
        ResultSet resultSet = statement.executeQuery();
        Student student = null;
        if (resultSet.next()) {
            id = resultSet.getInt("StudentId");
            name = resultSet.getString("StudentName");
            absentDays = resultSet.getInt("AbsentDays");
            presentToday = resultSet.getBoolean("PresentToday");
            student = new Student(id,name,absentDays,presentToday);
        }
        return student;
    }

    /**
     * returns true if the teacher login used is correct otherwhise it returns false
     * @param password
     * @return
     * @throws SQLException
     */
    public boolean validTeacherLogin(String password) throws SQLException {
        Connection connection = connectionPool.checkOut();
        String sql = "Select * From Teacher WHERE Teacher.TeacherCode = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, password);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()){
            return true;
        } else {
            return false;
        }
    }
}
