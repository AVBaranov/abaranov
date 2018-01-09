package hibernate.carStoreAnnotation;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Андрей on 09.01.2018.
 */
@Entity
@Table(name="transmission_annotate")
public class Transmission {
    private int id;
    private String type;
    private List<Car> cars = new ArrayList<>();

    public Transmission() {
    }

    @Id @GeneratedValue
    @Column(name="transmission_id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name="transmission_type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "transmission")
    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "Transmission{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", cars=" + cars +
                '}';
    }
}
