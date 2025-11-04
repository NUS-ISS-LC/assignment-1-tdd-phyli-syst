package sg.edu.nus.iss.epat.tdd.workshop;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.fail;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.Collection;

public class ToDoListTest  {
    // Define Test Fixtures
    private ToDoList todo; 

    public ToDoListTest() {
        super();
    }

    @Before
    public void setUp() throws Exception {
        // Initialise Test Fixtures
        todo = new ToDoList();
    }

    @After
    public void tearDown() throws Exception {
        // Uninitialise test Fixtures
        System.out.println("tearDown");
    }

    @Test
    public void testAddTask() {
        String description = "Buy eggs";
        Task task = new Task(description);

        todo.addTask(task);

        assertNotNull("getTask should return the added task", todo.getTask(description));
    }

    @Test
    public void testGetStatus() {
        String description = "Buy milk";
        Task task = new Task(description);
        todo.addTask(task);

        assertFalse("New task should be not completed by default", todo.getStatus(description));

        // after completing the task, status should be true
        todo.completeTask(description);
        assertTrue("Task should be completed after calling completeTask", todo.getStatus(description));
    }

    @Test
    public void testRemoveTask() {
        String description = "Walk dog";
        Task task = new Task(description);
        todo.addTask(task);

        Task removed = todo.removeTask(description);
        assertNotNull("removeTask should return the removed task", removed);
        assertNull("getTask should return null after removal", todo.getTask(description));
    }

    @Test
    public void 
    testGetCompletedTasks() {
        String d1 = "Pay bills";
        String d2 = "Read book";
        Task t1 = new Task(d1);
        Task t2 = new Task(d2);

        todo.addTask(t1);
        todo.addTask(t2);

        // complete only the first task
        todo.completeTask(d1);

        Collection<Task> completed = todo.getCompletedTasks();
        assertTrue("Completed tasks should contain the completed task", completed.contains(todo.getTask(d1)));
        assertFalse("Completed tasks should not contain the incomplete task", completed.contains(todo.getTask(d2)));
    }
}