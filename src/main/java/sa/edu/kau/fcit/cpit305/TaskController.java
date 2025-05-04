package sa.edu.kau.fcit.cpit305;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskController {
    private final Connection connection;

    public TaskController() throws SQLException {
        this.connection = DatabaseConnection.getInstance().getConnection();
    }

    public void addTask(Task task) throws SQLException {

    }

    public List<Task> getAllTasks() throws SQLException {
        return null;
    }

    public boolean markTaskAsComplete(int id) throws SQLException {
        return false;
    }

    public boolean deleteTask(int id) throws SQLException {
        return false;
    }
}