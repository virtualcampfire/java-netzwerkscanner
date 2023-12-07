/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 07.11.2023
 * @author
 */

public class TaskManager {

  // Anfang Attribute
  private Database db;
  private Task[] tasks;
  // Ende Attribute

  // Anfang Methoden
  public Database getDb() {
    return db;
  }

  public Task[] getTasks() {
    return tasks;
  }

  public void addTask(String description, String command) {
    // Eintrag in DB und generierung der ID

    String id = String.valueOf(System.currentTimeMillis());
    Task newTask = new Task(description, command, id);
    Task[] newTasks = new Task[tasks.length + 1];
    System.arraycopy(tasks, 0, newTasks, 0, tasks.length);
    newTasks[tasks.length] = newTask;
    tasks = newTasks;
    System.out.println("Task added: " + newTask.getDescription() + " (" + newTask.getId() + ")");
  }

  public void deleteTaskById(String id) {
    // Delete Task with ID in Database
    Task[] newTasks = new Task[tasks.length - 1];
    int index = 0;
    for (Task task : tasks) {
      if (task.getId().equals(id)) {
        continue;
      }
      newTasks[index] = task;
      index++;
    }
    tasks = newTasks;
  }

  // Ende Methoden
} // end of TaskManager
