package AttendanceChecker.DAL.DAO;

import AttendanceChecker.DAL.DBConnection.JDBCConnectionPool;

import java.io.IOException;

public class LoginDAO {

    private final JDBCConnectionPool connectionPool;

    public LoginDAO() throws IOException {
        connectionPool = JDBCConnectionPool.getInstance();
    }

}
