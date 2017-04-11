package ru.job4j.start;

/**
 * .
 */
public class StubInput implements Input {
    /**
     * String array.
     */
    private String[] answers;
     /**
     * counter.
     */
    private int counter = 0;
    /**
     * Constructor.
     * @param answers - String array
     */
    public StubInput(String[] answers) {
        this.answers = answers;
    }
    /**
     * Method input data.
     * @return input data
     */
    public String ask() {
        return this.answers[counter++];
    }
    /**
     * Method input data.
     * @param str - message for user
     * @return input data
     */
    public String ask(String str) {
        System.out.print(str);
        return this.answers[counter++];
    }
    /**
     * Method input data.
     * @return input data
     */
    public long askDate() {
        return 1;
    }
}
