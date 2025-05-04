package sa.edu.kau.fcit.cpit305;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    @Test
    void testTaskCreation() {
        String title = "Buy Milk";
        Task task = new Task(title);

        assertEquals(title, task.getTitle());
        assertFalse(task.isCompleted());
        assertNotNull(task.getCreatedAt());
    }

    @Test
    void testTaskSetters() {
        Task task = new Task("Buy Coffee Beans");
        LocalDateTime now = LocalDateTime.now();

        task.setId(1);
        String updatedTitle = "Buy Decaf Coffee Beans";
        task.setTitle(updatedTitle);
        task.setCompleted(true);
        task.setCreatedAt(now);

        assertEquals(1, task.getId());
        assertEquals(updatedTitle, task.getTitle());
        assertTrue(task.isCompleted());
        assertEquals(now, task.getCreatedAt());
    }

    @Test
    void testToString() {
        Task task = new Task("Go grocery shopping");
        task.setId(1);
        task.setCompleted(true);

        String taskString = task.toString();
        assertTrue(taskString.contains("Go grocery shopping"));
        assertTrue(taskString.contains("1"));
        assertTrue(taskString.contains("true"));
    }
}