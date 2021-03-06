package hibernate.todolist;

import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Андрей on 08.12.2017.
 */
public class AddController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json");
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        List<Item> list = new ItemStorage().getAll();
        ObjectMapper mapper = new ObjectMapper();
        String newJsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(list);
        writer.append(newJsonString);
        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        new ItemStorage().add(new Item(Integer.parseInt(req.getParameter("id")), req.getParameter("descr"), req.getParameter("created"), Boolean.parseBoolean(req.getParameter("done"))));
        resp.sendRedirect(String.format("%s/index.html", req.getContextPath()));
    }
}
