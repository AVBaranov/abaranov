package servlets.test_task.dao.userDao;

/**
 * Created by Андрей on 12.12.2017.
 */
public class User {

    private String login;

    private String password;

    private String email;

    private String role;

    private String address;

    public User(String login, String password, String email, String role, String address) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.role = role;
        this.address = address;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    public String getAddress() {
        return address;
    }

}
