package spring.models;

import java.util.List;

/**
 * Created by Андрей on 28.12.2017.
 */
public interface DaoStorageAnnotate<T> {
    void create(T car);
    List<T> read();
    void update(int id, T newCar);
    void delete(int id);
    T getById(int id);
    List<T> findByCredential(String carbody, String transmission, String engine);
    void deleteAll();
}
