# To-Do List with File Storage

A simple console-based to-do application in Java.

## Features

- Add task (title, due date)
- Delete task
- Mark task as complete
- List all tasks
- Save tasks to a text file on exit
- Load tasks from a file on startup

## Installation

Clone the repository and navigate to the project directory:

```bash
git clone https://github.com/mykyt-tech/todo-file-storage.git
cd todo-file-storage
```

Compile the Java files:
```bash
javac *.java
```

Run the application:
```bash
java TaskApp
```

## Usage

1. On startup, tasks are loaded automatically from tasks.txt (or created if missing).
2. Use the menu to add, delete, or complete tasks.
3. Exit the application to save tasks automatically.