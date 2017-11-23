package servlets.mvc_controllers;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Timestamp;

/**
 * Created by Андрей on 20.11.2017.
 */
public class MvcAddUser extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("users", new MvcUserStorage().getUsers());
        req.getRequestDispatcher("/WEB-INF/mvc_views/AddView.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        new MvcUserStorage().add(new Mvc_User(req.getParameter("name"), req.getParameter("login"), req.getParameter("email"), new Timestamp(System.currentTimeMillis())));
        resp.sendRedirect(String.format("%s/mvcadd", req.getContextPath()));
    }

}
