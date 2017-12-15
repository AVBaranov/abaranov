package servlets.test_task.test_servlets.user;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Андрей on 14.12.2017.
 */
public class ChooseUserAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/test_task_views/user/ChooseUser.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String choice = req.getParameter("choice");
        if ("add".equals(choice)) {
            resp.sendRedirect(String.format("%s/addUser", req.getContextPath()));
        } else if ("update".equals(choice)) {
            resp.sendRedirect(String.format("%s/updateUser", req.getContextPath()));
        } else if ("get".equals(choice)) {
            resp.sendRedirect(String.format("%s/getUsers", req.getContextPath()));
        } else if ("delete".equals(choice)) {
            resp.sendRedirect(String.format("%s/deleteUser", req.getContextPath()));
        } else{
            req.getRequestDispatcher("/WEB-INF/test_task_views/error.jsp").forward(req, resp);
        }
    }
}
