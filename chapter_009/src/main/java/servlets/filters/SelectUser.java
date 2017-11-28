package servlets.filters;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Андрей on 28.11.2017.
 */
public class SelectUser extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("users", FilterUserStorage.getInstance().getUsers());
        req.getRequestDispatcher("/WEB-INF/role_views/SelectUserToChange.jsp").forward(req, resp);

    }
}
