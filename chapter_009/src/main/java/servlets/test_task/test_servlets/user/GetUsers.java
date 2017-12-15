package servlets.test_task.test_servlets.user;

import servlets.test_task.DaoStorage;
import servlets.test_task.User;
import servlets.test_task.UserDaoStorage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Андрей on 14.12.2017.
 */
public class GetUsers extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DaoStorage<User> store = new UserDaoStorage();
        try {
            req.setAttribute("users", store.getAll());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.getRequestDispatcher("/WEB-INF/test_task_views/user/GetUsers.jsp").forward(req, resp);
    }
}
