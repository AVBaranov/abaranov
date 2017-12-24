package servlets.test_task.controllers.address;

import servlets.test_task.dao.addressDao.Address;
import servlets.test_task.dao.addressDao.AddressDaoStorage;
import servlets.test_task.dao.DaoStorage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Андрей on 15.12.2017.
 */
public class UpdateAddress extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/test_task_views/address/UpdateAddress.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        DaoStorage<Address> store = new AddressDaoStorage();
        store.update(Integer.parseInt(req.getParameter("id")), new Address(Integer.parseInt(req.getParameter("new_id")), req.getParameter("new_address")));
        resp.sendRedirect(String.format("%s/updateRole", req.getContextPath()));
    }
}
