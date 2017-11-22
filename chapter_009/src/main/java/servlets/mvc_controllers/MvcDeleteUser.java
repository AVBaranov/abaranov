package servlets.mvc_controllers;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Андрей on 20.11.2017.
 */
public class MvcDeleteUser extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("/WEB-INF/mvc_views/DeleteView.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        new MvcUserStorage().delete(Integer.parseInt(req.getParameter("id")));
        resp.sendRedirect(String.format("%s/mvcdelete", req.getContextPath()));
    }
}
