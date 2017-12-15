package servlets.test_task.databaseException;

/**
 * Created by Андрей on 15.12.2017.
 */
public class NoSuchRoleException extends RuntimeException {
    public NoSuchRoleException(String message) {
        super(message);
    }
}
