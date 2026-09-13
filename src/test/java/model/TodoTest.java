package model;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TodoTest {

    // Tests that the Todo constructor correctly stores the task text.
    @Test
    void newTodoShouldStoreTaskText() {
        Todo todo = new Todo("Finish Assignment 3");

        // This task should match to the constructor.
        assertEquals("Finish Assignment 3", todo.getTask());
    }

    // Tests that a newly created Todo starts as incomplete.
    @Test
    void newTodoShouldStartAsNotCompleted() {
        Todo todo = new Todo("Study Java");

        // A new Todo that is completed should be set to false
        assertFalse(todo.isCompleted());
    }

    // Tests that setTask() correctly changes the task text.
    @Test
    void setTaskShouldUpdateTaskText() {
        Todo todo = new Todo("Study Java");

        // Changes existing task.
        todo.setTask("Study Maven");

        // Verifies task update.
        assertEquals("Study Maven", todo.getTask());
    }

    // Tests that setCompleted(true) marks a Todo as completed.
    @Test
    void setCompletedShouldMarkTodoAsCompleted() {
        Todo todo = new Todo("Complete unit testing");

        todo.setCompleted(true);

        // Verifies that the completion status is changed to true.
        assertTrue(todo.isCompleted());
    }

    // Tests that toString() correctly displays a completed Todo.
    @Test
    void toStringShouldShowCompletedStatus() {
        Todo todo = new Todo("Submit assignment");

        todo.setCompleted(true);

        // Verifies expected String representation
        assertEquals("0. Submit assignment [Completed]", todo.toString());
    }
}
