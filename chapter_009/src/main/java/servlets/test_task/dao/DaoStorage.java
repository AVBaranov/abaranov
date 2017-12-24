package servlets.test_task.dao;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Андрей on 15.12.2017.
 */
public interface DaoStorage <T> {

    void add(T value);
    List<T> getAll();
    void update(int id, T value);
    void delete(int id);
}
