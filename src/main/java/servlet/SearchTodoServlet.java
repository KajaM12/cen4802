package servlet;

import dao.TodoDAO;
import model.Todo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/search")
public class SearchTodoServlet extends HttpServlet {

    private TodoDAO dao = new TodoDAO();

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        String task = request.getParameter("task");

        List<Todo> todos = dao.searchTodos(task);

        System.out.println("Search input: " + task);
        System.out.println("Number of results: " + todos.size());

        request.setAttribute("todos", todos);

        request.getRequestDispatcher("todolist.jsp")
                .forward(request, response);
    }
}