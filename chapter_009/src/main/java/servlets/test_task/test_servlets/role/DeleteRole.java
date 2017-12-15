package servlets.test_task.test_servlets.role;

import servlets.test_task.DaoStorage;
import servlets.test_task.Role;
import servlets.test_task.RoleDaoStorage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Андрей on 15.12.2017.
 */
public class DeleteRole extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/test_task_views/role/DeleteRole.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DaoStorage<Role> store = new RoleDaoStorage();
        store.delete(Integer.parseInt(req.getParameter("id")));
        resp.sendRedirect(String.format("%s/deleteRole", req.getContextPath()));
    }
}
