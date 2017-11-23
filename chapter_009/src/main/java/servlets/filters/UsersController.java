package servlets.filters;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by Андрей on 23.11.2017.
 */
public class UsersController extends HttpServlet {

    private List<String> users = new CopyOnWriteArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*HttpSession session = req.getSession();
        synchronized (session) {
            if (session == null || session.getAttribute("login") == null) {
                resp.sendRedirect(String.format("%s/signin", req.getContextPath()));
            } else {
                req.setAttribute("users", FilterUserStorage.getInstance().getUsers());
                req.getRequestDispatcher("/WEB-INF/filter_views/UsersView.jsp").forward(req, resp);
            }
        }*/

        req.setAttribute("users", FilterUserStorage.getInstance().getUsers());
        req.getRequestDispatcher("/WEB-INF/filter_views/UsersView.jsp").forward(req, resp);

        /*if (!("check").equals((FilterUserStorage.getInstance().check))) {
            resp.sendRedirect(String.format("%s/signin", req.getContextPath()));
        } else {
            req.setAttribute("users", FilterUserStorage.getInstance().getUsers());
            req.getRequestDispatcher("/WEB-INF/filter_views/UsersView.jsp").forward(req, resp);
        }*/


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        FilterUserStorage.getInstance().add(new Filter_User(req.getParameter("login"), req.getParameter("email"), null));
        resp.sendRedirect(String.format("%s/controller", req.getContextPath()));
    }
}
