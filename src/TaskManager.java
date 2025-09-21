import java.time.LocalDateTime;
import java.util.ArrayList;

public class TaskManager {
    private static final ArrayList<Task> tasks = new ArrayList<>();

    public static ArrayList<Task> getTasks() {
        return new ArrayList<>(tasks);
    }

    public static void addTask(String title, LocalDateTime dueDate) {
        tasks.add(new Task(title, dueDate));
    }

    public static void deleteTask(int id) {
        tasks.remove(id);
    }

    public static void updateTaskStatus(int number, TaskStatus status) {
        tasks.get(number).setStatus(status);
    }
}