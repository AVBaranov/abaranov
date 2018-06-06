package spring.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.repository.CarRepository;
import spring.repository.CarbodyRepository;
import spring.repository.EngineRepository;
import spring.repository.TransmissionRepository;
import spring.models.Car;

import java.util.List;

/**
 * Created by Андрей on 06.06.2018.
 */
public class CarServiceImpl implements CarService<Car> {

    private ApplicationContext context;
    private CarRepository repository;

    public CarServiceImpl() {
        this.context = new ClassPathXmlApplicationContext("spring.xml");
        this.repository = this.context.getBean(CarRepository.class);
    }

    @Override
    public void create(Car car) {
        this.context.getBean(CarRepository.class).save(new Car(
                car.getName(),
                context.getBean(EngineRepository.class).save(car.getEngine()),
                context.getBean(CarbodyRepository.class).save(car.getCarbody()),
                context.getBean(TransmissionRepository.class).save(car.getTransmission()),
                true));
    }

    @Override
    public List<Car> read() {
        return this.repository.findAll();
    }

    @Override
    public void update(int id, Car newCar) {
        //todoSomething
    }

    @Override
    public void deleteById(int id) {
        this.repository.delete(id);
    }

    @Override
    public Car getById(int id) {
        return this.repository.findById(id);
    }

    @Override
    public Car findByCredential(String carbody, String transmission, String engine) {
        return this.repository.findByIdAndName(9, "toyota");
    }

    @Override
    public void deleteAll() {
        this.repository.deleteAll();
    }
}
