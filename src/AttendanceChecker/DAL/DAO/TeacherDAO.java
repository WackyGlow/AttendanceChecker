package AttendanceChecker.DAL.DAO;

import AttendanceChecker.DAL.DBConnection.JDBCConnectionPool;

import java.io.IOException;

public class TeacherDAO {

    private final JDBCConnectionPool connectionPool;

    /**
     * constructor for the unused teacherDAO
     * @throws IOException
     */
    public TeacherDAO() throws IOException {
        connectionPool = JDBCConnectionPool.getInstance();
    }

}
