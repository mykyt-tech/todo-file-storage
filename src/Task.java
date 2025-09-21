import java.time.LocalDateTime;

public class Task {
    private String title;
    private LocalDateTime dueDate;
    private TaskStatus status;

    public Task(String title, LocalDateTime dueDate) {
        this.title = title;
        this.dueDate = dueDate;
        this.status = TaskStatus.TODO;
    }

    public String getTitle() {
        return title;
    }

    public LocalDateTime getDueDate() {
        return dueDate != null ? LocalDateTime.from(dueDate) : null;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }
}
