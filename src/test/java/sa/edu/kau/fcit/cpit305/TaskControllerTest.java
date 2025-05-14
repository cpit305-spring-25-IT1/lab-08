package sa.edu.kau.fcit.cpit305;

import org.junit.jupiter.api.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class TaskControllerTest {
    private TaskController taskController;
    private Connection connection;


    @BeforeEach
    void setUp() throws SQLException {
        taskController = new TaskController();
        connection = DatabaseConnection.getInstance().getConnection();
        try (Statement stmt = connection.createStatement()) {
            stmt.execute("CREATE TABLE IF NOT EXISTS tasks (" +
                    "id SERIAL PRIMARY KEY," +
                    "title VARCHAR(255) NOT NULL," +
                    "completed BOOLEAN DEFAULT FALSE," +
                    "created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP);");
        }
    }

    @AfterEach
    void tearDown() throws SQLException {
        try (Statement stmt = connection.createStatement()) {
            stmt.execute("DELETE FROM tasks");
        }
    }

    @Test
    void testAddAndGetTask() throws SQLException {
        Task task = new Task("Test Task");
        taskController.addTask(task);

        List<Task> tasks = taskController.getAllTasks();
        assertFalse(tasks.isEmpty());
        assertEquals("Test Task", tasks.get(0).getTitle());
    }

    @Test
    void testMarkTaskAsComplete() throws SQLException {
        Task task = new Task("Complete Me");
        taskController.addTask(task);

        List<Task> tasks = taskController.getAllTasks();
        int taskId = tasks.get(0).getId();

        assertTrue(taskController.markTaskAsComplete(taskId));
        tasks = taskController.getAllTasks();
        assertTrue(tasks.get(0).isCompleted());
    }

    @Test
    void testDeleteTask() throws SQLException {
        Task task = new Task("Delete Me");
        taskController.addTask(task);

        List<Task> tasks = taskController.getAllTasks();
        int taskId = tasks.get(0).getId();

        assertTrue(taskController.deleteTask(taskId));
        tasks = taskController.getAllTasks();
        assertTrue(tasks.isEmpty());
    }
}