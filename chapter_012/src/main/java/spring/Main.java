package spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.models.Car;
import spring.models.Carbody;
import spring.models.Engine;
import spring.models.Transmission;
import spring.repository.CarRepository;
import spring.service.CarServiceImpl;


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
//        new CarDaoStorageAnnotate().deleteAll();
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        /*context.getBean(CarRepository.class).save(new Car("a",
                context.getBean(EngineRepository.class).save(new Engine("a")),
                context.getBean(CarbodyRepository.class).save(new Carbody("b")),
                context.getBean(TransmissionRepository.class).save(new Transmission("c")),
                true));*/
        new CarServiceImpl().create(new Car("a", new Engine("b"), new Carbody("c"), new Transmission("d"), true));
//        context.getBean(CarRepository.class).deleteCarById(7);

    }


}
