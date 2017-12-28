package hibernate.carStore;

import java.util.List;

/**
 * Created by Андрей on 28.12.2017.
 */
public interface DaoStorage<T> {
    void create(T car);
    List<T> read();
    void update(int id, T newCar);
    void delete(int id);
}
