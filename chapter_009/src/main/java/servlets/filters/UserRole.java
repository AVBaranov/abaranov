package servlets.filters;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Andrey on 28.11.2017.
 */
public class UserRole extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("key", FilterUserStorage.getInstance().value);
        req.setAttribute("users", FilterUserStorage.getInstance().getUsers());
        req.getRequestDispatcher("/WEB-INF/role_views/UserView.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        try {
            FilterUserStorage.getInstance().update(FilterUserStorage.getInstance().value, new Filter_User(req.getParameter("login"), req.getParameter("email"), req.getParameter("password")));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        resp.sendRedirect(String.format("%s/userrole", req.getContextPath()));
    }
}
