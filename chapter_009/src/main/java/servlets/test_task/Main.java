package servlets.test_task;

import servlets.test_task.dao.addressDao.Address;
import servlets.test_task.dao.roleDao.Role;
import servlets.test_task.dao.userDao.User;
import servlets.test_task.dao.userDao.UserDaoStorage;

/**
 * Created by Andrey on 12.12.2017.
 */
public class Main {
    public static void main (String[] args) {


//            UserDaoStorage.getInstance().add(new User("1", "1", "1", "user", "Russia"));

            /*List<User> list = UserDaoStorage.getInstance().getAll();
            for (User user : list) {
                System.out.println(String.format("%s %s %s %s %s", user.getLogin(), user.getPassword(), user.getEmail(), user.getRole(), user.getAddress()));
            }*/
//            UserDaoStorage.getInstance().update(1, new User("admin", "admin", "admin_email", "user", "canada"));


//        DaoStorage<User> store = new UserDaoStorage();
//        System.out.println(String.format("%s %s", store.findById(2).getRole(), store.findById(2).getEmail()));

        /*try {
            System.out.println(String.format("%s %s", new UserDaoStorage().getEssences("admin").get(0).getRole(), new UserDaoStorage().getEssences("admin").get(0).getAddress()));
        } catch (SQLException e) {
            e.printStackTrace();
        }*/

        new UserDaoStorage().addEssence(new User("1", "1", "1", "hulk", "hulk_address"), new Role(10, "hulk"), new Address(10, "hulk_address"));


    }
}
