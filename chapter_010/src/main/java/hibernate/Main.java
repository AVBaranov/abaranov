package hibernate;

import hibernate.carStoreAnnotation.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.*;
import org.hibernate.cfg.*;

import javax.persistence.Query;
import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by Андрей on 29.12.2017.
 */
public class Main {
    public static void main (String[] args) {

        /*Engine engineTest = new Engine();
        engineTest.setModel("x6");
        Carbody carbodyTest = new Carbody();
        carbodyTest.setType("crossover");
        Transmission transmission = new Transmission();
        transmission.setType("auto");
        Car car = new Car("bmw", engineTest, carbodyTest, transmission, false);
        new CarDaoStorageAnnotate().create(car);*/

        /*SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        List<Car> cars = new ArrayList<>();
        Query query = session.createQuery(
                "from Car as c join fetch c.transmission where c.transmission.type =:transmission and c.carbody.type=:carbody and c.engine.model=:engine"
        );
        query.setParameter("transmission", "AT");
        query.setParameter("carbody", "cabriolet");
        query.setParameter("engine", "1.6 Optima");
        cars = query.getResultList();*/
        /*SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        System.out.println(session.createQuery("delete from Transmission ").executeUpdate());
        System.out.println(session.createQuery("delete from Engine ").executeUpdate());
        session.getTransaction().commit();
        session.close();
        factory.close();*/
        /*List<Car> cars = new CarDaoStorageAnnotate().findByCredential("cabriolet", "AT", "1.6 Optima");
        for (Car car : cars) {
            System.out.println(car.getName());
        }*/
        new CarDaoStorageAnnotate().deleteAll();




        /*File file = new File("C:\\Users\\Андрей\\Desktop/target");
        File[] arrayfiles = file.listFiles();
        List<File> listfiles = new ArrayList<>();
        for (File value : arrayfiles) {
            listfiles.add(value);
        }
        System.out.println(listfiles);*/

//        session.close();
//        factory.close();


    }
}
