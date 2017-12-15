package servlets.test_task;

/**
 * Created by Андрей on 12.12.2017.
 */
public class Role {

    private String role;

    private int id;

    public Role(int id, String role) {
        this.id = id;
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public int getId() {
        return id;
    }

}
