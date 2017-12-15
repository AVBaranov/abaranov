package servlets.test_task.databaseException;

/**
 * Created by Андрей on 15.12.2017.
 */
public class NoSuchAddressException extends RuntimeException {
    public NoSuchAddressException(String message) {
        super(message);
    }
}
