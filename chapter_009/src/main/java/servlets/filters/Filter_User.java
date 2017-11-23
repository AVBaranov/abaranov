package servlets.filters;

import java.sql.Timestamp;

/**
 * Created by Андрей on 20.10.2017.
 */
public class Filter_User {

    private String login;

    private String email;

    private String password;

    public Filter_User(String login, String email, String password) {
        this.email = email;
        this.login = login;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
