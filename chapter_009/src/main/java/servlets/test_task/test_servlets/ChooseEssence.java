package servlets.test_task.test_servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Андрей on 14.12.2017.
 */
public class ChooseEssence extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/test_task_views/LoginView.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String choice = req.getParameter("choice");
        if ("user".equals(choice)) {
            resp.sendRedirect(String.format("%s/chooseUserAction", req.getContextPath()));
        } else if ("role".equals(choice)) {
            resp.sendRedirect(String.format("%s/chooseRoleAction", req.getContextPath()));
        } else if ("address".equals(choice)) {
            resp.sendRedirect(String.format("%s/chooseAddressAction", req.getContextPath()));
        } else if ("musicType".equals(choice)) {
            resp.sendRedirect(String.format("%s/newMusicType", req.getContextPath()));
        } else {
            req.getRequestDispatcher("/WEB-INF/test_task_views/error.jsp").forward(req, resp);
        }
    }
}
