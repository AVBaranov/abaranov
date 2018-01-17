package hibernate.carStoreAnnotation;

import org.junit.Test;

import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
/**
 * Created by Андрей on 17.01.2018.
 */
public class CarDaoStorageAnnotateTest {
    @Test
    public void whenRunMethodFindByCredentialThenGetTargetEntity() {
        CarDaoStorageAnnotate carDaoStorageAnnotate = new CarDaoStorageAnnotate();
        carDaoStorageAnnotate.deleteAll();
        Engine engineTest = new Engine();
        engineTest.setModel("x6");
        Carbody carbodyTest = new Carbody();
        carbodyTest.setType("crossover");
        Transmission transmission = new Transmission();
        transmission.setType("auto");
        Car car = new Car("bmw", engineTest, carbodyTest, transmission, false);
        carDaoStorageAnnotate.create(car);
        List<Car> cars = carDaoStorageAnnotate.findByCredential("crossover", "auto", "x6");
        assertThat("x6", is(cars.get(0).getEngine().getModel()));
    }
}
