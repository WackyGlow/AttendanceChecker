package AttendanceChecker.DAL.DAO;

import AttendanceChecker.Be.Student;
import AttendanceChecker.DAL.DBConnection.JDBCConnectionPool;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    private final JDBCConnectionPool connectionPool;

    public StudentDAO() throws IOException {
        connectionPool = JDBCConnectionPool.getInstance();
    }

    public List<Student> getAllStudents(){
        ArrayList<Student> allStudents = new ArrayList<>(){
        };

        try (Connection connection = connectionPool.checkOut()) {
            String sql = "SELECT * FROM Student;";
            Statement statement = connection.createStatement();
            if (statement.execute(sql)) {
                ResultSet resultSet = statement.getResultSet();
                while (resultSet.next()) {
                    int id = resultSet.getInt("Id");
                    String name = resultSet.getString("StudentName");
                    int absentDays = resultSet.getInt("AbsentDays");
                    boolean presentToday = resultSet.getBoolean("PresentToday");
                    Student student = new Student(id,name,absentDays,presentToday);
                    allStudents.add(student);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return allStudents;
    }

}


