package spring.models;

import org.codehaus.jackson.annotate.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Андрей on 09.01.2018.
 */
@Entity
@Table(name="engine_annotate")
public class Engine {
    private int id;
    private String model;

    private List<Car> cars = new ArrayList<>();

    public Engine() {
    }

    public Engine(String model) {
        this.model = model;
    }

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="engine_id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name="engine_model")
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "engine")
    @JsonManagedReference
    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "Engine{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", cars=" + cars +
                '}';
    }
}
