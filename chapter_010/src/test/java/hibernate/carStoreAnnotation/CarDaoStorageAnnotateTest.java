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

    @Test
    public void whenAddNewEntityThenCanGetFieldOfItEntity() {
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
        assertThat("x6", is(carDaoStorageAnnotate.read().get(0).getEngine().getModel()));
    }

    @Test
    public void whenDeleteAllFromTableThenNoMoreRowsInTheTable() {
        CarDaoStorageAnnotate carDaoStorageAnnotate = new CarDaoStorageAnnotate();
        carDaoStorageAnnotate.deleteAll();
        Engine engineTest = new Engine();
        engineTest.setModel("x6");
        Carbody carbodyTest = new Carbody();
        carbodyTest.setType("crossover");
        Transmission transmission = new Transmission();
        transmission.setType("auto");
        Car car = new Car("bmw", engineTest, carbodyTest, transmission, false);
        engineTest.setModel("q5");
        Car car2 = new Car("audi", engineTest, carbodyTest, transmission, false);
        carDaoStorageAnnotate.create(car);
        carDaoStorageAnnotate.create(car2);
        carDaoStorageAnnotate.deleteAll();
        assertThat(0, is(carDaoStorageAnnotate.read().size()));
    }

    @Test
    public void whenReadFromDatabaseTableThenCanGetAllEntities() {
        CarDaoStorageAnnotate carDaoStorageAnnotate = new CarDaoStorageAnnotate();
        Engine engineTest = new Engine();
        engineTest.setModel("x6");
        Carbody carbodyTest = new Carbody();
        carbodyTest.setType("crossover");
        Transmission transmission = new Transmission();
        transmission.setType("auto");
        Car car = new Car("bmw", engineTest, carbodyTest, transmission, false);
        carDaoStorageAnnotate.create(car);
        assertThat(car.getEngine().getModel(), is(carDaoStorageAnnotate.read().get(0).getEngine().getModel()));
    }

}
