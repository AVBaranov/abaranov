package servlets.test_task.test_servlets.address;

import servlets.test_task.Address;
import servlets.test_task.AddressDaoStorage;
import servlets.test_task.DaoStorage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Андрей on 15.12.2017.
 */
public class GetAddresses extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DaoStorage<Address> store = new AddressDaoStorage();
        try {
            req.setAttribute("addresses", store.getAll());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.getRequestDispatcher("/WEB-INF/test_task_views/address/GetAddresses.jsp").forward(req, resp);
    }
}
