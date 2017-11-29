package servlets.jsp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;

/**
 * Created by Андрей on 20.11.2017.
 */
public class JspUpdateUser extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        JspUserStorage.getInstance().update(Integer.parseInt(req.getParameter("id")), new Jsp_User(req.getParameter("name"), req.getParameter("login"), req.getParameter("email"), new Timestamp(System.currentTimeMillis())));
        resp.sendRedirect(String.format("%s/jspadd.jsp", req.getContextPath()));
    }
}
