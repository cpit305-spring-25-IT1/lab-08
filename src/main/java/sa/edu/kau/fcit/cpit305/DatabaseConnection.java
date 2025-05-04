package sa.edu.kau.fcit.cpit305;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    // Values from .env hardcoded (You should read the .env file in a real application)
    private static final String HOST = "localhost";
    private static final String PORT = "5432";
    private static final String DB = "tododb";
    private static final String USER = "postgres";
    private static final String PASSWORD = "changeme";
    private static DatabaseConnection instance;
    private Connection connection;

    private DatabaseConnection() throws SQLException {





    }

    public Connection getConnection() {
        return connection;
    }

    public static DatabaseConnection getInstance() throws SQLException {
        if (instance == null || instance.getConnection().isClosed()) {
            instance = new DatabaseConnection();
        }
        return instance;
    }
}