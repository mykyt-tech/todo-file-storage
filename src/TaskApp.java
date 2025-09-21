import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class TaskApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        boolean running = true;

        while (running) {
            System.out.println("-----------------------------");
            System.out.println("Please choose an option:");
            System.out.println("1. Add new task");
            System.out.println("2. Update task status");
            System.out.println("3. Delete task");
            System.out.println("4. View all tasks");
            System.out.println("5. Exit");
            System.out.println("-----------------------------");
            System.out.print("Enter your choice: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            int taskNumber;

            switch (option) {
                case 1:
                    String title;
                    String dueDate;

                    System.out.println("-----------------------------");
                    System.out.print("Enter title: ");
                    title = scanner.nextLine();

                    System.out.print("Enter due date and time (yyyy-MM-dd HH:mm): ");
                    dueDate = scanner.nextLine();

                    try {
                        LocalDateTime dueDateTime = LocalDateTime.parse(dueDate, formatter);
                        TaskManager.addTask(title, dueDateTime);

                        System.out.println("-----------------------------");
                        System.out.println("New task added successfully");
                    } catch (DateTimeParseException e) {
                        System.out.println("-----------------------------");
                        System.out.println("Invalid date format! Please use yyyy-MM-dd HH:mm");
                    }

                    break;
                case 2:
                    int newStatus;

                    System.out.println("-----------------------------");
                    System.out.print("Enter task number: ");

                    taskNumber = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Choose new status (1. IN_PROGRESS, 2. DONE): ");

                    newStatus = scanner.nextInt();
                    scanner.nextLine();

                    boolean updateStatusResult;
                    if (newStatus == 1) {
                        updateStatusResult = TaskManager.updateTaskStatus(taskNumber, TaskStatus.IN_PROGRESS);
                    } else if (newStatus == 2) {
                        updateStatusResult = TaskManager.updateTaskStatus(taskNumber, TaskStatus.DONE);
                    } else {
                        System.out.println("Incorrect status");
                        break;
                    }

                    if (!updateStatusResult) {
                        System.out.println("-----------------------------");
                        System.out.println("Something went wrong");
                        System.out.println("Task status cannot be changed");
                        break;
                    }

                    System.out.println("-----------------------------");
                    System.out.println("Task status changed successfully");
                    break;
                case 3:
                    System.out.println("-----------------------------");
                    System.out.print("Enter task number: ");

                    taskNumber = scanner.nextInt();
                    scanner.nextLine();

                    boolean deleteResult = TaskManager.deleteTask(taskNumber);
                    if (deleteResult) {
                        System.out.println("-----------------------------");
                        System.out.println("Task removed successfully");
                    } else {
                        System.out.println("-----------------------------");
                        System.out.println("Something went wrong");
                        System.out.println("Task cannot be removed");
                    }

                    break;
                case 4:
                    System.out.println("-----------------------------");
                    ArrayList<Task> tasks = TaskManager.getTasks();

                    for (int i = 0; i < tasks.size(); i++) {
                        Task task = tasks.get(i);
                        System.out.println(i + ". Title: " + task.getTitle()
                                + ", due date: " + task.getDueDate().format(formatter)
                                + ", status: " + task.getStatus());
                    }

                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("-----------------------------");
                    System.out.println("Incorrect option!");
            }
        }
    }
}
