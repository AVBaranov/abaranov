package hibernate.carStore;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Андрей on 28.12.2017.
 */
public class CarDaoStorage implements DaoStorage<Car> {

    SessionFactory factory = null;



    public CarDaoStorage() {
        this.factory = new Configuration().configure().buildSessionFactory();
    }

    @Override
    public void create(Car car) {
        Session session = this.factory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(car.getTransmission());
            session.save(car.getEngine());
            session.save(car.getCarbody());
            session.save(car);
            session.getTransaction().commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
            this.factory.close();
        }
    }

    @Override
    public List<Car> read() {
        Session session = this.factory.openSession();
        Transaction transaction = null;
        List<Car> cars = new ArrayList<>();
        try {
            transaction = session.beginTransaction();
            cars = session.createQuery("from Car").list();
            session.getTransaction().commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
            this.factory.close();
        }
        return cars;
    }

    @Override
    public void update(int id, Car newCar) {
        Session session = this.factory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            newCar.setId(id);
            session.saveOrUpdate(newCar);
            session.getTransaction().commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
            this.factory.close();
        }
    }

    @Override
    public void delete(Car car) {



    }

    public Car getById(int id) {
        Session session = this.factory.openSession();
        Car car = session.get(Car.class, id);
        session.close();
        factory.close();
        return car;
    }
}
