import java.time.LocalDateTime;
import java.util.ArrayList;

public class TaskManager {
    static ArrayList<Task> tasks = new ArrayList<>();

    public static void main(String[] args) {
    }

    static void addTask(String title, LocalDateTime dueDate) {
        int newID = tasks.size() + 1;
        tasks.add(new Task(newID, title, dueDate));
    }
}