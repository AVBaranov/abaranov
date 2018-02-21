package spring;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import spring.models.Car;
import spring.models.CarDaoStorageAnnotate;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Андрей on 20.02.2018.
 */
public class Main {
    public static void main (String[] args) {
        /*SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        for (Car car : (List<Car>) session.createQuery("from Car").list()) {
            System.out.println(car.getEngine().getModel());
        }
        session.close();
        factory.close();*/
        new CarDaoStorageAnnotate().deleteAll();
    }


}
