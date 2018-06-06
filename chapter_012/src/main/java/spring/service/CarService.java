package spring.service;

import java.util.List;

/**
 * Created by Андрей on 06.06.2018.
 */
public interface CarService<T> {
    void create(T car);
    List<T> read();
    void update(int id, T newCar);
    void deleteById(int id);
    T getById(int id);
    T findByCredential(String carbody, String transmission, String engine);
    void deleteAll();
}
