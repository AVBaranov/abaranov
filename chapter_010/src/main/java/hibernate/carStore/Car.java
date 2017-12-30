package hibernate.carStore;

import java.util.List;

/**
 * Created by Andrey on 27.12.2017.
 */
public class Car {
    private int id;
    private String name;
    private Transmission transmission;
    private Carbody carbody;
    private Engine engine;

    public Car() {
    }

    public Car(int id) {
        this.id = id;
    }

    public Car(String name, Transmission transmission, Carbody carbody, Engine engine) {
        this.name = name;
        this.transmission = transmission;
        this.carbody = carbody;
        this.engine = engine;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public Carbody getCarbody() {
        return carbody;
    }

    public void setCarbody(Carbody carbody) {
        this.carbody = carbody;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", transmission=" + transmission +
                ", carbody=" + carbody +
                ", engine=" + engine +
                '}';
    }
}
