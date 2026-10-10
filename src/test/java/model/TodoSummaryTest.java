package model;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Collections;
import static org.junit.jupiter.api.Assertions.*;

class TodoSummaryTest {

    @Test
    void shouldCountCompletedAndIncompleteTodos() {
        Todo first = new Todo("Study Java");
        Todo second = new Todo("Finish project");
        Todo third = new Todo("Submit assignment");

        first.setCompleted(true);
        second.setCompleted(true);

        TodoSummary summary = new TodoSummary(
                Arrays.asList(first, second, third)
        );

        assertEquals(2, summary.getCompletedCount());
        assertEquals(1, summary.getIncompleteCount());
    }

    @Test
    void shouldReturnZeroCountsForEmptyList() {
        TodoSummary summary = new TodoSummary(
                Collections.emptyList()
        );

        assertEquals(0, summary.getCompletedCount());
        assertEquals(0, summary.getIncompleteCount());
    }
}
