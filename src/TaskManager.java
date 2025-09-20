import java.time.LocalDateTime;
import java.util.ArrayList;

public class TaskManager {
    private static final ArrayList<Task> tasks = new ArrayList<>();

    public static ArrayList<Task> getTasks() {
        return new ArrayList<>(tasks);
    }

    public static void addTask(String title, LocalDateTime dueDate) {
        int newID = tasks.size() + 1;
        tasks.add(new Task(newID, title, dueDate));
    }

    public static void deleteTask(int id) {
        tasks.remove(id);
    }

    public static void updateTaskStatus(int id, TaskStatus status) {
        tasks.get(id - 1).setStatus(status);
    }
}