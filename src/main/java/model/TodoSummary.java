package model;

import java.util.List;

public class TodoSummary {

    private int completedCount;
    private int incompleteCount;

    public TodoSummary(List<Todo> todos) {
        for (Todo todo : todos) {
            if (todo.isCompleted()) {
                completedCount++;
            } else {
                incompleteCount++;
            }
        }
    }

    public int getCompletedCount() {
        return completedCount;
    }

    public int getIncompleteCount() {
        return incompleteCount;
    }
}
