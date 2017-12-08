package servlets.json;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Андрей on 07.12.2017.
 */
public class JsonUpdateController extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json");
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
//        writer.append("[{\"login\" : \"test2\", \"email\" : \"email22\"}]");
        List<String> ls = new ArrayList<>();
        List<JsonUser> list = JsonStorage.getInstance().getAll();
        writer.append(String.format("[{\"login\" : \"%s\", \"email\" : \"%s\"}]", list.get(0).getLogin(), list.get(0).getEmail()));
        writer.flush();


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*try {
            JsonStorage.getInstance().add(new JsonUser(req.getParameter("login"), req.getParameter("email")));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }*/
        JsonStorage.getInstance().update(req.getParameter("login_to_update"), req.getParameter("city"), req.getParameter("country"));
        resp.sendRedirect(String.format("%s/Items.html", req.getContextPath()));
        /*try {
            JsonStorage.getInstance().add(new JsonUser(req.getParameter("name"), req.getParameter("password")));
            resp.sendRedirect(String.format("%s/Items.html", req.getContextPath()));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }*/

    }
}
