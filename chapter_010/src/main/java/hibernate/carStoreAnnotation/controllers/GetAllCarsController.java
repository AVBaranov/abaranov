package hibernate.carStoreAnnotation.controllers;

import hibernate.carStore.*;
import hibernate.carStoreAnnotation.*;
import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Андрей on 10.01.2018.
 */
public class GetAllCarsController extends HttpServlet {

    private class NewCar {
        private String name;
        private String engine;
        private String carbody;
        private String transmission;
        private boolean sold;

        public NewCar(String name, String engine, String carbody, String transmission, boolean sold) {
            this.name = name;
            this.engine = engine;
            this.carbody = carbody;
            this.transmission = transmission;
            this.sold = sold;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEngine() {
            return engine;
        }

        public void setEngine(String engine) {
            this.engine = engine;
        }

        public String getCarbody() {
            return carbody;
        }

        public void setCarbody(String carbody) {
            this.carbody = carbody;
        }

        public String getTransmission() {
            return transmission;
        }

        public void setTransmission(String transmission) {
            this.transmission = transmission;
        }

        public boolean isSold() {
            return sold;
        }

        public void setSold(boolean sold) {
            this.sold = sold;
        }

        @Override
        public String toString() {
            return "NewUser{" +
                    "name='" + name + '\'' +
                    ", engine='" + engine + '\'' +
                    ", carbody='" + carbody + '\'' +
                    ", transmission='" + transmission + '\'' +
                    '}';
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json");
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        List<hibernate.carStoreAnnotation.Car> list = new CarDaoStorageAnnotate().read();
        ObjectMapper mapper = new ObjectMapper();
        List<NewCar> cars = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            cars.add(new NewCar(
                    list.get(i).getName(),
                    list.get(i).getEngine().getModel(),
                    list.get(i).getCarbody().getType(),
                    list.get(i).getTransmission().getType(),
                    list.get(i).isSold())
                );
        }
        String newJsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(cars);
        writer.append(newJsonString);
        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect(String.format("%s/getcars.html", req.getContextPath()));
    }
}
