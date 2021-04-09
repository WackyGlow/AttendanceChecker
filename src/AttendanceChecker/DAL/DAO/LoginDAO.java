package AttendanceChecker.DAL.DAO;

import AttendanceChecker.Be.Student;
import AttendanceChecker.DAL.DBConnection.JDBCConnectionPool;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LoginDAO {

    private final JDBCConnectionPool connectionPool;

    public LoginDAO() throws IOException {
        connectionPool = JDBCConnectionPool.getInstance();
    }


    public Student getAllStudents(String login, String password){

        try (Connection connection = connectionPool.checkOut()) {
            String sql = "Select * from Student INNER JOIN StudentLogin ON Student.StudentID = StudentLogin.StudentID WHERE StudentLogin.StudentLogin = " + login +" AND StudentLogin.StudentPassword = " + password;
            Statement statement = connection.createStatement();
            if (statement.execute(sql)) {
                ResultSet resultSet = statement.getResultSet();
                while (resultSet.next()) {
                    int id = resultSet.getInt("StudentId");
                    String name = resultSet.getString("StudentName");
                    int absentDays = resultSet.getInt("AbsentDays");
                    boolean presentToday = resultSet.getBoolean("PresentToday");
                    Student student = new Student(id,name,absentDays,presentToday);
                    return student;
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }


}
