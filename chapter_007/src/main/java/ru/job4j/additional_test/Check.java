package ru.job4j.additional_test;

/**
 * Created by Andrey on 23.09.2017.
 */
public class Check {
    public boolean isReversal(String first, String second) {
        char[] charar = first.toCharArray();
        int j = charar.length - 1;
        for (int i = 0; i < charar.length / 2; i++, j--) {
            char buf = charar[i];
            charar[i] = charar[j];
            charar[j] = buf;
        }
        return new String(charar).equals(second);
    }
}
