package sg.edu.nus.iss.epat.tdd.workshop;
import java.util.Collection;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

public class ToDoList {
   private HashMap<String, Task> tasks = new HashMap<String, Task>();

   public void addTask(Task task) {
      // Add code here
      if (task == null || task.getDescription() == null) {
         throw new IllegalArgumentException("task and task description must not be null");
      }
      // store the provided task keyed by its description
      tasks.put(task.getDescription(), task);
   }

   public void completeTask(String description) {
      // mark the task identified by description as complete
      Task t = tasks.get(description);
      if (t == null) {
         throw new IllegalArgumentException("task not found: " + description);
      }
      t.setComplete(true);
   }

   public boolean getStatus(String description) {
      Task t = tasks.get(description);
      if (t == null) {
         throw new IllegalArgumentException("task not found: " + description);
      }
      return t.isComplete();
   }

   public Task getTask(String description) {
      // Add code here
      return tasks.get(description);
   }

   public Task removeTask(String description) {
      // remove and return the task (or null if not present)
      return tasks.remove(description);
   }

   public Collection<Task> getAllTasks() {
      return tasks.values();
   }

   public Collection<Task> getCompletedTasks() {
      List<Task> completed = new ArrayList<>();
      for (Task t : tasks.values()) {
         if (t.isComplete()) {
            completed.add(t);
         }
      }
      return completed;
   }
}
