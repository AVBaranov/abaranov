package spring;

/**
 * Created by Andrey on 02.02.2018.
 */
public class HelperClass {
    private Season season;
    public HelperClass(Season season) {
        this.season = season;
    }
    public void setSeason(Season season) {
        this.season = season;
    }
    public void fallout() {
        this.season.fallout();
    }
}
