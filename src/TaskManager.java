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

    public static boolean deleteTask(int id) {
        try {
            tasks.remove(id);
            return true;
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }

    public static boolean updateTaskStatus(int number, TaskStatus status) {
        try {
            tasks.get(number).setStatus(status);
            return true;
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }
}