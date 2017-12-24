package hibernate;

/**
 * Created by Андрей on 07.12.2017.
 */
public class JsonUser {

    private String login;

    private String email;

    private String city;

    private String country;

    public JsonUser(String login, String email) {
        this.login = login;
        this.email = email;
    }

    public JsonUser(String login, String email, String city, String country) {
        this.login = login;
        this.email = email;
        this.city = city;
        this.country = country;
    }

    public String getLogin() {
        return login;
    }

    public String getEmail() {
        return email;
    }

    public String getCity() {

        return city;
    }

    public String getCountry() {
        return country;
    }

}
