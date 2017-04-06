package ru.job4j.start;

/**
 * .
 */
public class StubInput implements Input {
    private String[] answers;
    private int counter = 0;
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
     * @return input data
     */
    public long askDate() {
        return 1;
    }
}
