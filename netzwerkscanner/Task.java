/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 07.11.2023
 * @author
 */

public class Task {

  // Anfang Attribute
  private String id;
  private String description;
  private String command;
  // Ende Attribute

  // Anfang Methoden

  public Task(String description, String command, String id) {
    this.description = description;
    this.command = command;
    this.id = id;
  }

  public String getId() {
    return id;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String descriptionNeu) {
    description = descriptionNeu;
  }

  public String getCommand() {
    return command;
  }

  public void setCommand(String commandNeu) {
    command = commandNeu;
  }

  // Ende Methoden
} // end of Task
