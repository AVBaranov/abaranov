package spring;

/**
 * Created by Andrey on 02.02.2018.
 */
public class Winter implements Season {
    @Override
    public void fallout() {
        System.out.println("it is snowing");
    }
}
