package spring.models;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Андрей on 28.12.2017.
 */
public class CarDaoStorageAnnotate implements DaoStorageAnnotate<Car> {

    private SessionFactory factory = null;

    public CarDaoStorageAnnotate() {
        this.factory = new Configuration().configure().buildSessionFactory();
    }

    @Override
    public void create(Car car) {
        if (this.factory.isClosed()) {
            this.factory = new Configuration().configure().buildSessionFactory();
        }
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
        if (this.factory.isClosed()) {
            this.factory = new Configuration().configure().buildSessionFactory();
        }
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
        if (this.factory.isClosed()) {
            this.factory = new Configuration().configure().buildSessionFactory();
        }
        Session session = this.factory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            newCar.setId(id);
            session.save(newCar.getTransmission());
            session.save(newCar.getEngine());
            session.save(newCar.getCarbody());
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
    public void delete(int id) {
        if (this.factory.isClosed()) {
            this.factory = new Configuration().configure().buildSessionFactory();
        }
        Session session = this.factory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Car car = session.get(Car.class, id);
            session.delete(car);
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
    public Car getById(int id) {
        if (this.factory.isClosed()) {
            this.factory = new Configuration().configure().buildSessionFactory();
        }
        Session session = this.factory.openSession();
        Car car = session.get(Car.class, id);
        session.close();
        factory.close();
        return car;
    }

    @Override
    public List<Car> findByCredential(String carbody, String transmission, String engine) {
        List<Car> cars = new ArrayList<>();
        Session session = null;
        try {
            if (this.factory.isClosed()) {
                this.factory = new Configuration().configure().buildSessionFactory();
            }
            session = this.factory.openSession();
            Query query = session.createQuery(
                    "from Car as c join fetch c.transmission where c.transmission.type =:transmission and c.carbody.type=:carbody and c.engine.model=:engine"
            );
            query.setParameter("transmission", transmission);
            query.setParameter("carbody", carbody);
            query.setParameter("engine", engine);
            cars = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            this.factory.close();
        }
        return cars;
    }

    @Override
    public void deleteAll() {
        if (this.factory.isClosed()) {
            this.factory = new Configuration().configure().buildSessionFactory();
        }
        Session session = this.factory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.createQuery("delete from Car ").executeUpdate();
            session.createQuery("delete from Carbody ").executeUpdate();
            session.createQuery("delete from Transmission ").executeUpdate();
            session.createQuery("delete from Engine ").executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
            this.factory.close();
            System.out.println(this.factory);
        }
    }


}
