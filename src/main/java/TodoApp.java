import javax.persistence.*;

import model.Todo;
import java.util.List;
import java.util.Scanner;

/** I will be using this old to do list application for this project

 */

/**
 *  This is my console base To Do List application.
 *
 *  This program allows the users to:
 *  Add, Delete, View, and the to-do items
 *
 *  I was able to use an ArrayList to store tasks in memory.
 */

/**
 * Main method that runs the to do list application
 *
 */
public class TodoApp {

    private static EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("todoPU");

    private static EntityManager em = emf.createEntityManager();

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        runApp(input);

        input.close();
        em.close();
        emf.close();
    }

    public static void runApp(Scanner input) {

        while (true) {

            showMenu();

            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1 -> addTask(input);
                case 2 -> deleteTask(input);
                case 3 -> viewTasks();
                case 4 -> {
                    System.out.println("Bye!");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    /**
     *  We will have to display menu options of the items
     */
    public static void showMenu() {
        System.out.println("\n     TO DO LIST     ");
        System.out.println("1. Add Item");
        System.out.println("2. Remove Item");
        System.out.println("3. View Items");
        System.out.println("4. Exit");
        System.out.print("Choose: ");
    }

    /**
     * Add a task to the list
     */
    public static void addTask(Scanner input) {

        System.out.print("Enter task: ");
        String task = input.nextLine();

        Todo todo = new Todo(task);

        em.getTransaction().begin();
        em.persist(todo);
        em.getTransaction().commit();

    }

    /**
     * Display all tasks
     */
    public static void viewTasks() {

        List<Todo> list = em.createQuery("FROM Todo", Todo.class).getResultList();

        if (list.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }

        System.out.println("\nYour Tasks:");
        for (Todo t : list) {
            System.out.println(t);
        }
    }

    /**
     * Delete a task from the list
     */
    public static void deleteTask(Scanner input) {

        viewTasks();

        System.out.print("Enter ID to delete: ");
        int id = input.nextInt();
        input.nextLine();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Todo todo = em.find(Todo.class, id);

        if (todo != null) {
            em.remove(todo);
            System.out.println("Deleted task ID: " + id);
        } else {
            System.out.println("Task not found!");
        }

        tx.commit();
    }
}
