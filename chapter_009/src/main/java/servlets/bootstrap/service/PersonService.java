package servlets.bootstrap.service;

import java.util.List;

/**
 * Created by Andrey on 25.06.2018.
 */
public interface PersonService<T> {
    void create(T person);
    List<T> read();
}
