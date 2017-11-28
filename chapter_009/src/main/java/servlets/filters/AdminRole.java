package servlets.filters;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Андрей on 28.11.2017.
 */
public class AdminRole extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setAttribute("key", FilterUserStorage.getInstance().value);
        req.setAttribute("users", FilterUserStorage.getInstance().getUsers());
        req.getRequestDispatcher("/WEB-INF/role_views/AdminView.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        try {
            FilterUserStorage.getInstance().update(req.getParameter("login"), new Filter_User(req.getParameter("newlogin"), req.getParameter("newemail"), req.getParameter("newpassword")));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        resp.sendRedirect(String.format("%s/admin", req.getContextPath()));
    }
}
