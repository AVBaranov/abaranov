package servlets.test_task.databaseException;

/**
 * Created by Андрей on 13.12.2017.
 */
public class NoSuchIdException extends RuntimeException {
    public NoSuchIdException(String message) {
        super(message);
    }
}
