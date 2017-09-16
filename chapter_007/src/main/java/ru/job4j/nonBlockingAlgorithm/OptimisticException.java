package ru.job4j.nonBlockingAlgorithm;

/**
 * Created by Andrey on 17.09.2017.
 */
public class OptimisticException extends RuntimeException {
    /**
     * constructor..
     * @param str - throwing string
     */
    public OptimisticException(String str) {
        super(str);
    }
}
