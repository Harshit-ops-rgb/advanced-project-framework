package db;
import java.sql.*;

/**
 * Database Connection Manager
 * Handles SQLite database connections for fraud detection system
 */
public class Database {
    private static final String URL = "jdbc:sqlite:resources/fraud.db";
    
    /**
     * Gets a new database connection
     * @return Connection to the fraud detection database
     * @throws SQLException if connection fails
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL);
    }
}
