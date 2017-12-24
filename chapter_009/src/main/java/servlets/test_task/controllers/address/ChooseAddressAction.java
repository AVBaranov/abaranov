package servlets.test_task.controllers.address;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Андрей on 15.12.2017.
 */
public class ChooseAddressAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/test_task_views/address/ChooseAddress.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String choice = req.getParameter("choice");
        if ("add".equals(choice)) {
            resp.sendRedirect(String.format("%s/addAddress", req.getContextPath()));
        } else if ("update".equals(choice)) {
            resp.sendRedirect(String.format("%s/updateAddress", req.getContextPath()));
        } else if ("get".equals(choice)) {
            resp.sendRedirect(String.format("%s/getAddresses", req.getContextPath()));
        } else if ("delete".equals(choice)) {
            resp.sendRedirect(String.format("%s/deleteAddress", req.getContextPath()));
        } else{
            req.getRequestDispatcher("/WEB-INF/test_task_views/error.jsp").forward(req, resp);
        }
    }
}
