package servlets.jsp;

import java.sql.Timestamp;

/**
 * Created by Андрей on 20.10.2017.
 */
public class Jsp_User {

    private String name;

    private String login;

    private String email;

    private Timestamp createDate;

    public Jsp_User(String name, String login, String email, Timestamp createDate) {
        this.name = name;
        this.login = login;
        this.email = email;
        this.createDate = createDate;
    }

    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }

    public String getEmail() {
        return email;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }
}
