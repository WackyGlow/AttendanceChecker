package AttendanceChecker.DAL.DAO;

import AttendanceChecker.DAL.DBConnection.JDBCConnectionPool;

import java.io.IOException;

public class CourseDAO {

    private final JDBCConnectionPool connectionPool;


    /**
     * The constructor for the unused CourseDAO Class
     * @throws IOException
     */
    public CourseDAO() throws IOException {
        connectionPool = JDBCConnectionPool.getInstance();
    }
}