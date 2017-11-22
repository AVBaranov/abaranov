package servlets.mvc_controllers;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;

/**
 * Created by Андрей on 20.11.2017.
 */
public class MvcUpdateUser extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/mvc_views/UpdateView.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        new MvcUserStorage().update(Integer.parseInt(req.getParameter("id")), new Mvc_User(req.getParameter("name"), req.getParameter("login"), req.getParameter("email"), new Timestamp(System.currentTimeMillis())));
        resp.sendRedirect(String.format("%s/mvcupdate", req.getContextPath()));
    }
}
