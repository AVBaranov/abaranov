package spring.models;

import org.codehaus.jackson.annotate.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Андрей on 09.01.2018.
 */
@Entity
@Table(name="carbody_annotate")
public class Carbody {
    private int id;
    private String type;
    private List<Car> cars = new ArrayList<>();

    public Carbody() {
    }

    public Carbody(String type) {
        this.type = type;
    }

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="carbody_id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name="carbody_type", nullable = true)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "carbody")
    @JsonManagedReference
    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "Carbody{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", cars=" + cars +
                '}';
    }
}
