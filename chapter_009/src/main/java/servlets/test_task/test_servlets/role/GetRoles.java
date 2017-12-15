package servlets.test_task.test_servlets.role;

import servlets.test_task.DaoStorage;
import servlets.test_task.Role;
import servlets.test_task.RoleDaoStorage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Андрей on 15.12.2017.
 */
public class GetRoles extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DaoStorage<Role> store = new RoleDaoStorage();
        try {
            req.setAttribute("roles", store.getAll());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.getRequestDispatcher("/WEB-INF/test_task_views/role/GetRoles.jsp").forward(req, resp);
    }
}
