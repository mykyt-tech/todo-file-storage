import java.time.LocalDateTime;

public class Task {
    private int id;
    private String title;
    private LocalDateTime dueDate;
    private String status;

    public Task(int id, String title, LocalDateTime dueDate) {
        this.id = id;
        this.title = title;
        this.dueDate = dueDate;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public LocalDateTime getDueDate() {
        return dueDate != null ? LocalDateTime.from(dueDate) : null;
    }

    public String getStatus() {
        return status;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
