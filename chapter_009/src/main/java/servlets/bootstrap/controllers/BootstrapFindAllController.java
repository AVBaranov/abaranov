package servlets.bootstrap.controllers;

import org.codehaus.jackson.map.ObjectMapper;
import servlets.bootstrap.models.Person;
import servlets.bootstrap.service.PersonServiceImpl;
import servlets.filters.JsonStorage;
import servlets.filters.JsonUser;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by Andrey on 25.06.2018.
 */
public class BootstrapFindAllController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*resp.setContentType("text/json");
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        List<JsonUser> list = JsonStorage.getInstance().getAll();
        ObjectMapper mapper = new ObjectMapper();
        String temp = mapper.writeValueAsString(list);
        writer.append(temp);
        writer.flush();*/
        resp.setContentType("text/json");
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        List<Person> list = new PersonServiceImpl().read();
        ObjectMapper mapper = new ObjectMapper();
        String temp = mapper.writeValueAsString(list);
        writer.append(temp);
        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
