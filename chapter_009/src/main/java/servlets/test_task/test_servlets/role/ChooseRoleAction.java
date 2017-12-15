package servlets.test_task.test_servlets.role;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Андрей on 15.12.2017.
 */
public class ChooseRoleAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/test_task_views/role/ChooseRole.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String choice = req.getParameter("choice");
        if ("add".equals(choice)) {
            resp.sendRedirect(String.format("%s/addRole", req.getContextPath()));
        } else if ("update".equals(choice)) {
            resp.sendRedirect(String.format("%s/updateRole", req.getContextPath()));
        } else if ("get".equals(choice)) {
            resp.sendRedirect(String.format("%s/getRoles", req.getContextPath()));
        } else if ("delete".equals(choice)) {
            resp.sendRedirect(String.format("%s/deleteRole", req.getContextPath()));
        } else if ("find".equals(choice)) {
            resp.sendRedirect(String.format("%s/findRoleById", req.getContextPath()));
        } else{
            req.getRequestDispatcher("/WEB-INF/test_task_views/error.jsp").forward(req, resp);
        }
    }
}
