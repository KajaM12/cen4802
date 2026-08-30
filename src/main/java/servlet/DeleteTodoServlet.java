package servlet;

import dao.TodoDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/delete-todo")
public class DeleteTodoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws IOException, ServletException {

        int id = Integer.parseInt(
                request.getParameter("id")
        );

        TodoDAO dao = new TodoDAO();
        dao.deleteTodo(id);

        response.sendRedirect("todos");
    }
}
