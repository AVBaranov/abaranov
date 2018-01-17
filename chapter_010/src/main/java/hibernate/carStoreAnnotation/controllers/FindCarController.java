package hibernate.carStoreAnnotation.controllers;

import hibernate.carStoreAnnotation.Car;
import hibernate.carStoreAnnotation.CarDaoStorageAnnotate;
import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by Андрей on 17.01.2018.
 */
public class FindCarController extends HttpServlet {
    List<Car> cars = new CopyOnWriteArrayList<>();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json");
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        ObjectMapper mapper = new ObjectMapper();
        String newJsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(cars);
        writer.append(newJsonString);
        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.cars = new CarDaoStorageAnnotate().findByCredential(req.getParameter("bodytype"), req.getParameter("transmission"), req.getParameter("engine"));
        resp.sendRedirect(String.format("%s/showfindcar.html", req.getContextPath()));
    }
}
