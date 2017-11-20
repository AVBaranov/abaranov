package servlets;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Андрей on 30.10.2017.
 */
public interface UserDao {

    void put(User user) throws SQLException, ClassNotFoundException;

    List<User> getAll() throws SQLException, ClassNotFoundException;

    void update(int id, User user) throws SQLException, ClassNotFoundException;

    void delete(int id) throws SQLException, ClassNotFoundException;

}
