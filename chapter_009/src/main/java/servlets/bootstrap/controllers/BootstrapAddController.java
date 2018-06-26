package servlets.bootstrap.controllers;

import servlets.bootstrap.models.Person;
import servlets.bootstrap.service.PersonServiceImpl;
import servlets.filters.JsonStorage;
import servlets.filters.JsonUser;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Andrey on 25.06.2018.
 */
public class BootstrapAddController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            new PersonServiceImpl().create(new Person(req.getParameter("firstname"), req.getParameter("lastname"), req.getParameter("sex"), req.getParameter("desc")));

            resp.sendRedirect(String.format("%s/index.html", req.getContextPath()));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
