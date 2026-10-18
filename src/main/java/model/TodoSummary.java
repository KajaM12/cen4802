package model;

import java.util.List;

public class TodoSummary {

    private int completedCount;
    private int incompleteCount;

    // Counts how many todos are completed and incomplete
    public TodoSummary(List<Todo> todos) {
        for (Todo todo : todos) {
            if (todo.isCompleted()) {
                completedCount++;
            } else {
                incompleteCount++;
            }
        }
    }

    // Returns the number of completed todos
    public int getCompletedCount() {

        return completedCount;
    }

    // Returns the number of incomplete todos
    public int getIncompleteCount() {

        return incompleteCount;
    }
}
