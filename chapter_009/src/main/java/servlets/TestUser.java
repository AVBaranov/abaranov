package servlets;

/**
 * Created by Андрей on 16.11.2017.
 */
public class TestUser {

    private String login;

    private String email;

    public TestUser(String login, String email) {
        this.login = login;
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public String getEmail() {
        return email;
    }
}
