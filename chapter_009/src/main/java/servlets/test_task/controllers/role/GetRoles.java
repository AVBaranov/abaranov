package servlets.test_task.controllers.role;

import servlets.test_task.dao.DaoStorage;
import servlets.test_task.dao.roleDao.Role;
import servlets.test_task.dao.roleDao.RoleDaoStorage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Андрей on 15.12.2017.
 */
public class GetRoles extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DaoStorage<Role> store = new RoleDaoStorage();
        req.setAttribute("roles", store.getAll());
        req.getRequestDispatcher("/WEB-INF/test_task_views/role/GetRoles.jsp").forward(req, resp);
    }
}
