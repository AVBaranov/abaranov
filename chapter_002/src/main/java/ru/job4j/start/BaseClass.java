package ru.job4j.start;

/**
 * base class.
 */
public abstract class BaseClass implements UserAction {
    /**
     * info.
     */
    private String name;
    /**
     * constructor.
     * @param name ...
     */
    public BaseClass(String name) {
        this.name = name;
    }
    /**
     * method determines action.
     * @return key
     */
    public abstract int key();
    /**
     * method adds item.
     * @param input - input object
     * @param tracker - tracker object
     */
    public abstract void execute(Input input, Tracker tracker);
    /**
     * method show information about action.
     * @return information
     */
    public String info() {
        return String.format("%s. %s", this.key(), this.name);
    }

}
