package hibernate.carStore;

/**
 * Created by Andrey on 27.12.2017.
 */
public class Carbody {
    private int id;
    private String type;

    public Carbody() {
    }

    public Carbody(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
