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
public class GetAddresses extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DaoStorage<Address> store = new AddressDaoStorage();
        req.setAttribute("addresses", store.getAll());
        req.getRequestDispatcher("/WEB-INF/test_task_views/address/GetAddresses.jsp").forward(req, resp);
    }
}
