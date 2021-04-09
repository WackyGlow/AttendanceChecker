package AttendanceChecker.DAL.DAO;

import AttendanceChecker.DAL.DBConnection.JDBCConnectionPool;

import java.io.IOException;

public class CourseDAO {

    private final JDBCConnectionPool connectionPool;

    public CourseDAO() throws IOException {
        connectionPool = JDBCConnectionPool.getInstance();
    }
}