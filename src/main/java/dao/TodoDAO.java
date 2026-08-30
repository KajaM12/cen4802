package dao;

import javax.persistence.*;
import model.Todo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;


public class TodoDAO {

    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("todoPU");


    public List<Todo> getTodos() {

        EntityManager em = emf.createEntityManager();

        try {
            return em.createQuery("FROM Todo", Todo.class)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    public List<Todo> searchTodos(String task) {

        EntityManager em = emf.createEntityManager();

        try {

            return em.createQuery(
                            "FROM Todo t WHERE t.task LIKE :task",
                            Todo.class)
                    .setParameter("task", "%" + task + "%")
                    .getResultList();

        } finally {
            em.close();
        }
    }

    public void addTodo(Todo todo) {

        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            em.persist(todo);

            em.getTransaction().commit();

        } finally {
            em.close();
        }
    }


    public void deleteTodo(int id) {

        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            Todo todo = em.find(Todo.class, id);

            if (todo != null) {
                em.remove(todo);
            }

            em.getTransaction().commit();

        } finally {
            em.close();
        }

    }

    public void completeTodo(int id) {

        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            Todo todo = em.find(Todo.class, id);

            if (todo != null) {
                todo.setCompleted(true);
            }

            em.getTransaction().commit();

        } finally {
            em.close();
        }
    }
}
