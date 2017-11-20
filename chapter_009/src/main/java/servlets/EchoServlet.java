package servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;


/**
 * Created by Андрей on 16.10.2017.
 */
public class EchoServlet extends HttpServlet {

    private static final Logger log = LoggerFactory.getLogger(EchoServlet.class);

    private List<String> list = new CopyOnWriteArrayList<>();

//    UserDao ud = new UserDaoJdbcImpl();

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        try {
            UserDaoJdbcImpl.getInstance().put(new User("walt", "walter", "ww@mail.ru", new Timestamp(System.currentTimeMillis())));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*resp.setContentType("text/html");
        PrintWriter writer = new PrintWriter(resp.getOutputStream());

        try {
            for (Jsp_User values : ud.getAll()) {
                writer.append(String.format("%s %s %s \n", values.getName(), values.getLogin(), values.getEmail()));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        writer.flush();*/

        resp.setContentType("text/html");
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        StringBuilder sb =new StringBuilder("<table>");
        for (String value : list) {
            sb.append("<tr><td>"+ value +"</td></tr>");

        }
        sb.append("<\table>");

        writer.append("<!DOCTYPE html>" +
                "<html lang=\"en\">" +
                "<head>" +
                "    <meta charset=\"UTF-8\">" +
                "    <title></title>" +
                "</head>" +
                "<body>" +
                "<form action='"+req.getContextPath()+"/echo' method='post'>" +
                "Name : <input type='text' name='login'/>" +
                "<input type ='submit'>" +
                "</form>" +
                "<br/>" +
                sb.toString() +
                "</body>" +
                "</html>");
        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        /*try {
            ud.update();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }*/

        UserStorage.getInstance().add(new TestUser(req.getParameter("login"), req.getParameter("email")));
//        this.list.add(req.getParameter("login"));
//        doGet(req, resp);
        resp.sendRedirect(String.format("%s/index.jsp", req.getContextPath()));
}

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        try {
            UserDaoJdbcImpl.getInstance().delete();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
