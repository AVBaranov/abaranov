package hibernate;

import hibernate.carStoreAnnotation.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.*;
import org.hibernate.cfg.*;

/**
 * Created by Андрей on 29.12.2017.
 */
public class Main {
    public static void main (String[] args) {

        Engine engineTest = new Engine();
        engineTest.setModel("bmw_model");
        Carbody carbodyTest = new Carbody();
        carbodyTest.setType("bmw");
        Transmission transmission = new Transmission();
        transmission.setType("bmw");
        Car car = new Car("bmw", engineTest, carbodyTest, transmission);
        new CarDaoStorageAnnotate().create(car);

    }
}
