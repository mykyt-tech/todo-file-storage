import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
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
//            System.out.println("4. View all tasks");
//            System.out.println("5. Exit");
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

                    if (newStatus == 1) {
                        TaskManager.updateTaskStatus(taskNumber, TaskStatus.IN_PROGRESS);
                    } else if (newStatus == 2) {
                        TaskManager.updateTaskStatus(taskNumber, TaskStatus.DONE);
                    } else {
                        System.out.println("Incorrect status");
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

                    TaskManager.deleteTask(taskNumber);
                    System.out.println("Task removed successfully");
                    break;
            }
        }
    }
}
