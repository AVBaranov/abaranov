package hibernate.carStore;

import java.util.List;

/**
 * Created by Andrey on 27.12.2017.
 */
public class Transmission {
    private int id;
    String type;
    List<Car> cars;

    public Transmission() {
    }

    public Transmission(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}
