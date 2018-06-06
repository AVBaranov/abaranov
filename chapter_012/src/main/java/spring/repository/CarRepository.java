package spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import spring.models.Car;
import spring.models.Carbody;
import spring.models.Engine;
import spring.models.Transmission;

import java.util.List;

/**
 * Created by Андрей on 05.06.2018.
 */
public interface CarRepository extends JpaRepository<Car, Integer> {
    Car findById(int id);
    @Transactional
    void deleteCarById(int id);
    Car findByIdAndName(int id, String name);
}
