package servlets.test_task.controllers.user;

import servlets.test_task.dao.DaoStorage;
import servlets.test_task.dao.userDao.User;
import servlets.test_task.dao.userDao.UserDaoStorage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Андрей on 14.12.2017.
 */
public class GetUsers extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DaoStorage<User> store = new UserDaoStorage();
        req.setAttribute("users", store.getAll());
        req.getRequestDispatcher("/WEB-INF/test_task_views/user/GetUsers.jsp").forward(req, resp);
    }
}
