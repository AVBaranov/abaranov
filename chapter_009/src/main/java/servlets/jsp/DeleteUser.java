package servlets.jsp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;

/**
 * Created by Андрей on 20.11.2017.
 */
public class DeleteUser extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        JspUserStorage.getInstance().delete(Integer.parseInt(req.getParameter("id")));
        resp.sendRedirect(String.format("%s/index.jsp", req.getContextPath()));
    }
}
