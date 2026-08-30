package rest;

import dao.TodoDAO;
import model.Todo;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/todos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class TodoResource {


    @GET
    public List<Todo> getTodos() {

        TodoDAO dao = new TodoDAO();

        return dao.getTodos();
    }


    @POST
    public Todo addTodo(Todo todo) {

        TodoDAO dao = new TodoDAO();

        dao.addTodo(todo);

        return todo;
    }
}