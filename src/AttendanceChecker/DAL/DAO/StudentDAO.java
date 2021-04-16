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
                    int id = resultSet.getInt("StudentId");
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

    public void changeIsPresentBack(Student student) throws SQLException {
        int studentID = student.getID();
        Connection con = connectionPool.checkOut();
        String sql = "UPDATE Student SET PresentToday = 0 WHERE StudentID = " + studentID + ";";
        try (PreparedStatement st = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            st.executeUpdate();
        } catch (SQLException ex) {
            throw new SQLException("Could not set attendance to 0 again", ex);
        } finally {
            connectionPool.checkIn(con);
        }
    }


    public void addToAbsentDays(Student student) throws SQLException {
        int studentID = student.getID();
        int absentDays = student.getAbsentDays();
        Connection con = connectionPool.checkOut();
        String sql = "UPDATE Student SET AbsentDays =" + absentDays++ + "WHERE StudentID =" + studentID + ";";
        try (PreparedStatement st = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            st.executeUpdate();
        } catch (SQLException ex) {
            throw new SQLException("Could not update AbsentDays in Student",ex);
        } finally {
            connectionPool.checkIn(con);
        }
    }

    /* public void addToTotalDays() throws SQLException {
        Connection con = connectionPool.checkOut();
        int totalDays =
        String sql = "UPDATE TotalDays SET Totaldays";
    }
    */
}


