package spring.store;

import java.util.List;

/**
 * Created by Andrey on 02.02.2018.
 */
public interface Storage <T>{
    void add(User user);
    List<T> getAll();
}
