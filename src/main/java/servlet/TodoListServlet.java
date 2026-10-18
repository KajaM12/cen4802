package servlet;

import dao.TodoDAO;
import model.Todo;
import model.TodoSummary;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

// Maps this servlet to the /todos URL
@WebServlet("/todos")
public class TodoListServlet extends HttpServlet {

    @Override
    // Handles GET requests when the todo list page is opened
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws IOException, ServletException {

        // Createsd a DAO object to access the todo data
        TodoDAO dao = new TodoDAO();

        // This will get the list of todos from the database
        List<Todo> todos = dao.getTodos();

        // Sends the todo list to the JSP page
        request.setAttribute("todos", todos);

        // This will create a summary of the todos and sends it to the page
        request.setAttribute("summary", new TodoSummary(todos));

        // It will forward the request to the JSP page to display the todos
        request.getRequestDispatcher(
                "/todolist.jsp"
        ).forward(request, response);
    }
}
