package servlets.test_task;

/**
 * Created by Андрей on 12.12.2017.
 */
public class Address {

    private String address;

    private int id;

    public Address(int id, String address) {
        this.id = id;
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public int getId() {
        return id;
    }
}
