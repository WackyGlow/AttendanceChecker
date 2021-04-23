package AttendanceChecker.DAL.DAO;

import AttendanceChecker.Be.Student;
import AttendanceChecker.DAL.DBConnection.JDBCConnectionPool;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    private final JDBCConnectionPool connectionPool;
    private int totalDays;

    /**
     * Constructor which instantiates the connectionPool variable
     * @throws IOException
     */
    public StudentDAO() throws IOException {
        connectionPool = JDBCConnectionPool.getInstance();
    }

    /**
     * returns a list of all students in the database
     * @return
     */
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


    /**
     * Changes the bit in the database back to 0 instead of 1
     * @param student
     * @throws SQLException
     */
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

    /**
     * Marks a specific student given from a student ID as present
     * @param student
     * @throws SQLException
     */
    public void markStudentAsPresent(Student student) throws SQLException {
        int studentID = student.getID();
        Connection con = connectionPool.checkOut();
        String sql = "UPDATE Student SET PresentToday = 1 WHERE StudentID = " + studentID + ";";
        try (PreparedStatement st = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            st.executeUpdate();
        } catch (SQLException ex) {
            throw new SQLException("Could not set attendance to 0 again", ex);
        } finally {
            connectionPool.checkIn(con);
        }
    }

    /**
     * adds to a given students total absence
     * @param student
     * @throws SQLException
     */
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

    /**
     * returns a value from total days in the database
     * @return
     * @throws SQLException
     */
    public int getTotalDays() throws SQLException {
        try (Connection connection = connectionPool.checkOut()) {
            String sql = "SELECT Totaldays FROM TotalDays;";
            Statement statement = connection.createStatement();
            if (statement.execute(sql)) {
                ResultSet resultSet = statement.getResultSet();
                while (resultSet.next()) {
                    totalDays = resultSet.getInt("Totaldays");
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return totalDays;
    }

    /**
     * adds 1 to the total days in the database
     * @throws SQLException
     */
    public void addToTotalDays() throws SQLException {
        Connection con = connectionPool.checkOut();
        int newTotalDays = getTotalDays() + 1;
        String sql = "UPDATE TotalDays SET Totaldays =" + newTotalDays +";";
        try (PreparedStatement st = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)) {
            st.executeUpdate();
        } catch (SQLException exception){
            throw new SQLException("could not add to total days", exception);

        } finally {
            connectionPool.checkIn(con);
        }
    }

    /**
     * gets a the value of a students total absence on a given day.
     * @param student
     * @param specifiedDay
     * @return
     */
    public int getValueFromDay(Student student, String specifiedDay){
        int value = 0;
        int studentID = student.getID();
        try (Connection connection = connectionPool.checkOut()) {
            String sql = "SELECT "+ specifiedDay +" FROM MostAbsentDay WHERE StudentID = " + studentID + ";";
            Statement statement = connection.createStatement();
            if (statement.execute(sql)) {
                ResultSet resultSet = statement.getResultSet();
                while (resultSet.next()) {
                    value = resultSet.getInt(specifiedDay);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return value;
    }

    /**
     * adds 1 to the value in the database which represents a students total absence on a given day
     * @param student
     * @param specifiedDay
     * @throws SQLException
     */
    public void addToMostAbsentDay(Student student, String specifiedDay) throws SQLException {
        Connection con = connectionPool.checkOut();
        int studentId = student.getID();
        String day = specifiedDay.substring(0,1).toUpperCase() + specifiedDay.substring(1).toLowerCase();
        int oldValueFromDay = getValueFromDay(student,day);
        int valuetoAdd = 1;
        String sql = "UPDATE MostAbsentDay SET "+ day +" = " + (oldValueFromDay + valuetoAdd) + " WHERE StudentID = " + studentId + ";";
        try (PreparedStatement st = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)) {
            st.executeUpdate();
        } catch (SQLException exception){
            throw new SQLException("could not add absence to " + day + " for:" + student.getName(), exception);

        } finally {
            connectionPool.checkIn(con);
        }
    }

    /**
     * Used to correct mistakes and remove the students absence from a given day in the database
     * @param student
     * @param specifiedDay
     */
    public void removeFromMostDayAbsentDay(Student student, String specifiedDay) {
        Connection con= connectionPool.checkOut();
        int studentID = student.getID();
        String day = specifiedDay.substring(0,1).toUpperCase() + specifiedDay.substring(1).toLowerCase();
        int oldValueFromDay = getValueFromDay(student,day);
        int valuetoAdd = -1;
        String sql = "UPDATE MostAbsentDay SET "+ day +" = " + (oldValueFromDay + valuetoAdd) + " WHERE StudentID = " + studentID + ";";
        try (PreparedStatement st = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)){
            st.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
        } finally {
            connectionPool.checkIn(con);
        }
    }

    /**
     * removes 1 from a students absent days in the database.
     * @param student
     * @throws SQLException
     */
    public void removefromAbsentDays(Student student) throws SQLException {
        int studentID = student.getID();
        int absentDays = student.getAbsentDays();
        int daysToSubtract = -1;
        Connection con = connectionPool.checkOut();
        String sql = "UPDATE Student SET AbsentDays =" + (absentDays + daysToSubtract) + "WHERE StudentID =" + studentID + ";";
        try (PreparedStatement st = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            st.executeUpdate();
        } catch (SQLException ex) {
            throw new SQLException("Could not update AbsentDays in Student",ex);
        } finally {
            connectionPool.checkIn(con);
        }
    }
}


