package hibernate.carStoreAnnotation;

import javax.persistence.*;

/**
 * Created by Андрей on 09.01.2018.
 */
@Entity
@Table(name="car_annotate")
public class Car {
    private int id;
    private String name;
    private Engine engine;
    private Carbody carbody;
    private Transmission transmission;

    public Car() {
    }

    public Car(String name, Engine engine, Carbody carbody, Transmission transmission) {
        this.name = name;
        this.engine = engine;
        this.carbody = carbody;
        this.transmission = transmission;
    }

    @Id @GeneratedValue
    @Column(name="car_id", nullable=false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name="car_name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "engine_id", nullable = false)
    public Engine getEngine() {
        return engine;
    }


    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "carbody_id", nullable = false)
    public Carbody getCarbody() {
        return carbody;
    }

    public void setCarbody(Carbody carbody) {
        this.carbody = carbody;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "transmission_id", nullable = false)
    public Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
