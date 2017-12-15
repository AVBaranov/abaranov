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
public class AddAddress extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/test_task_views/address/AddAddress.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        DaoStorage<Address> store = new AddressDaoStorage();
        try {
            store.add(new Address(Integer.parseInt(req.getParameter("id")), req.getParameter("address")));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        resp.sendRedirect(String.format("%s/addAddress", req.getContextPath()));
    }
}
