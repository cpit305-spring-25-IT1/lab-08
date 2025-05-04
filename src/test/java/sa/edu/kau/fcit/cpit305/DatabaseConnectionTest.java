package sa.edu.kau.fcit.cpit305;

import org.junit.jupiter.api.Test;
import java.sql.Connection;
import java.sql.SQLException;
import static org.junit.jupiter.api.Assertions.*;

class DatabaseConnectionTest {

    // DatabaseConnection is a singleton.
    @Test
    void testGetInstance() throws SQLException {
        DatabaseConnection instance1 = DatabaseConnection.getInstance();
        DatabaseConnection instance2 = DatabaseConnection.getInstance();

        assertNotNull(instance1);
        assertNotNull(instance2);
        assertSame(instance1, instance2);
    }

    @Test
    void testConnection() throws SQLException {
        Connection conn = DatabaseConnection.getInstance().getConnection();
        assertNotNull(conn);
        assertFalse(conn.isClosed());
    }

    @Test
    void testConnectionClosed() throws SQLException {
        DatabaseConnection dbConnection = DatabaseConnection.getInstance();
        Connection conn = dbConnection.getConnection();
        conn.close();
        assertTrue(conn.isClosed());
    }
}