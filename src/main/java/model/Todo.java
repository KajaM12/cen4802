package model;

import javax.persistence.*;

// Updated entity
@Entity
@Table(name = "todos")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String task;

    private boolean completed = false;

    // Required by Hibernate/JPA
    public Todo() {}

    // Constructor
    public Todo(String task) {
        this.task = task;
        this.completed = false;
    }


    public int getId() {
        return id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return id + ". " + task + (completed ? " [Completed]" : "");
    }

}
