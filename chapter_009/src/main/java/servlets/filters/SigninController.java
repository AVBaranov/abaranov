package servlets.filters;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Андрей on 22.11.2017.
 */
public class SigninController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/filter_views/LoginView.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        if (login.equals("admin") && password.equals("admin")) {
            HttpSession session = req.getSession();
            synchronized (session) {
                session.setAttribute("login", login);
            }
            resp.sendRedirect(String.format("%s/admin", req.getContextPath()));
        } else if (FilterUserStorage.getInstance().isCredentional(login, password)) {
            HttpSession session = req.getSession();
            synchronized (session) {
                session.setAttribute("login", login);
                FilterUserStorage.getInstance().value = login;
            }
//            FilterUserStorage.getInstance().check = "check";

//            resp.sendRedirect(String.format("%s/", req.getContextPath()));

            resp.sendRedirect(String.format("%s/user", req.getContextPath()));
        } else {
            req.setAttribute("error", "access denied ! ! !");
            doGet(req, resp);
        }
    }
}
