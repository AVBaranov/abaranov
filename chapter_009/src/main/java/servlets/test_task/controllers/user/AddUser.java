package servlets.test_task.controllers.user;

import servlets.test_task.dao.DaoStorage;
import servlets.test_task.dao.userDao.User;
import servlets.test_task.dao.userDao.UserDaoStorage;
import servlets.test_task.databaseException.NoSuchAddressException;
import servlets.test_task.databaseException.NoSuchRoleException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Андрей on 14.12.2017.
 */
public class AddUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/test_task_views/user/AddUser.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        try {
            DaoStorage<User> store = new UserDaoStorage();
            store.add(new User(req.getParameter("name"), req.getParameter("login"), req.getParameter("email"), req.getParameter("role"), req.getParameter("address")));
        } catch (NoSuchRoleException e) {
            req.getRequestDispatcher("/WEB-INF/test_task_views/error.jsp").forward(req, resp);
        } catch (NoSuchAddressException e) {
            req.getRequestDispatcher("/WEB-INF/test_task_views/error.jsp").forward(req, resp);
        }
        resp.sendRedirect(String.format("%s/addUser", req.getContextPath()));
    }
}
