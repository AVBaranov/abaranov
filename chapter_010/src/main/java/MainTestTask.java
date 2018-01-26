import java.util.List;

/**
 * Created by Андрей on 26.01.2018.
 */
public class MainTestTask {
    public static void main (String[] args) {
        for (String value : new TestTask().show()) {
            System.out.println(value);
        }
    }
}
