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

@WebServlet("/todos")
public class TodoListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws IOException, ServletException {

        TodoDAO dao = new TodoDAO();

        List<Todo> todos = dao.getTodos();

        request.setAttribute("todos", todos);
        request.setAttribute("summary", new TodoSummary(todos));

        request.getRequestDispatcher(
                "/todolist.jsp"
        ).forward(request, response);
    }
}
