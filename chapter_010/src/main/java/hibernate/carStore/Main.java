package hibernate.carStore;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


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


        /*Transmission transmission = new Transmission();
        transmission.setType("auto");
        session.save(transmission);
        Engine engine = new Engine();
        engine.setModel("bmw_engine");
        session.save(engine);
        Carbody carbody = new Carbody();
        carbody.setType("crossover");
        session.save(carbody);
        Car car = new Car();
        Car car2 = new Car("karfthrthrthka", transmission, carbody , engine);
        car2.setId(4);
        car.setName("dfgdsagdadf");
        car.setId(4);
        car.setEngine(new Engine(2));
        car.setTransmission(new Transmission(2));
        car.setCarbody(new Carbody(2));

        session.saveOrUpdate(car2);*/

//        Car car = session.get(Car.class, 6);
//        session.delete(car);

//        new CarDaoStorage().delete(5);

//        Query q = session.createQuery("delete Car where id = 2");
//        q.executeUpdate();

//        List<Car> cars = session.createQuery("from Car").list();
//        for (Car car : cars) {
//            System.out.println(car.getEngine().getModel());
//        }


        /*List<Car> cars = new CarDaoStorage().read();
        for (Car car : cars) {
            System.out.println(car);
        }*/

        /*Transmission transmission = new Transmission();
        transmission.setType("mersTransmission");
        Engine engine = new Engine();
        engine.setModel("mersEngine");
        Carbody carbody = new Carbody();
        carbody.setType("mersCarbody");
        new CarDaoStorage().update(4, new Car("newmers", transmission, carbody, engine));*/

        /*Transmission transmission = new Transmission();
        transmission.setType("7");
        Engine engine = new Engine();
        engine.setModel("7");
        Carbody carbody = new Carbody();
        carbody.setType("7");

        new CarDaoStorage().create(new Car("mers", transmission, carbody, engine));*/



//        System.out.println(car);
//        session.update("1", car);

//        Transmission transmission = new Transmission();
//        transmission.setType("kaka");

//        List<Car> cars = new ArrayList<>();
//        cars.add(new Car(1));
//        transmission.setCars(cars);
//        session.save(transmission);
        session.getTransaction().commit();
        session.close();
        factory.close();

        System.out.println(new CarDaoStorage().read());

    }

}
