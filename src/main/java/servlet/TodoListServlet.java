package servlet;

import dao.TodoDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/todos")
public class TodoListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws IOException, ServletException {

        TodoDAO dao = new TodoDAO();

        request.setAttribute(
                "todos",
                dao.getTodos()
        );

        request.getRequestDispatcher(
                "/todolist.jsp"
        ).forward(request, response);
    }
}