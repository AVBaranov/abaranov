package ru.job4j.collectionsframework.comparator;
import java.util.Set;
import java.util.List;
import java.util.TreeSet;
import java.util.Comparator;
/**
 * Created by Андрей on 02.05.2017.
 */
public class SortUser {
    /**
     * method converts List to Set.
     * @param list - list of users
     * @return TreeSet of User
     */
    public Set<User> sort(List<User> list) {

        return new TreeSet<>(list);
    }
    /**
     * method for sort List of User's objects by name length.
     * @param users - list of users
     * @return sorted List of users
     */
    public List<User> sortLength(List<User> users) {
        users.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o2.getNameLength().compareTo(o1.getNameLength());
            }
        });
        return users;
    }
    /**
     * method for sort List of User's objects by hashcode.
     * @param users - list of users
     * @return sorted List of users
     */
    public List<User> sortHash(List<User> users) {
        users.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o2.getHashcode().compareTo(o1.getHashcode());
            }
        });
        return users;
    }
}
