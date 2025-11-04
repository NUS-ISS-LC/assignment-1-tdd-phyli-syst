package sg.edu.nus.iss.epat.tdd.workshop;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.fail;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

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
        // todo = null;
    }

    @Test
    public void testAddTask() {
        String description = "Buy eggs";
        Task task = new Task(description);

        todo.addTask(task);

        assertEquals("There should be one task after adding", 1, todo.getAllTasks().size());
        assertNotNull("getTask should return the added task", todo.getTask(description));

        // fail("Not implemented yet");
    }

    @Test
    public void testGetStatus() {
        fail("Not implemented yet");
    }

    @Test
    public void testRemoveTask() {
        fail("Not implemented yet");
    }

    @Test
    public void testGetCompletedTasks() {
        fail("Not implemented yet");
    }
}