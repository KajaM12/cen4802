package servlet;

import dao.TodoDAO;
import model.Todo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.io.IOException;

@WebServlet("/add-todo")
public class AddTodoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws IOException, ServletException {

        String task = request.getParameter("task");

        if (task != null && !task.trim().isEmpty()) {

            Todo todo = new Todo();
            todo.setTask(task);

            TodoDAO dao = new TodoDAO();
            dao.addTodo(todo);
        }

        response.sendRedirect("todos");
    }
}
