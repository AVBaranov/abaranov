package hibernate.carStore;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrey on 27.12.2017.
 */
public class Main {
    public static void main (String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        Car car = new Car();
        car.setName("new_car");
        car.setTransmission(new Transmission(1));
        session.save(car);
//        Transmission transmission = new Transmission();
//        transmission.setType("kaka");

//        List<Car> cars = new ArrayList<>();
//        cars.add(new Car(1));
//        transmission.setCars(cars);
//        session.save(transmission);
        session.getTransaction().commit();
        session.close();
        factory.close();

    }
}
