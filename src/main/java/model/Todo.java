package model;

import javax.persistence.*;

//Updated entities
@Entity
@Table(name = "todos")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String task;

    // Required by Hibernate/JPA
    public Todo() {}

    // Constructor
    public Todo(String task) {
        this.task = task;
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

    @Override
    public String toString() {
        return id + ". " + task;
    }
}