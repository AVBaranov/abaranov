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

    public boolean contains(String word1, String word2) {
        char[] ar1 = word1.toCharArray();
        char[] ar2 = word2.toCharArray();
        boolean isContained = false;
        begin : for(int i = 0; i < ar1.length; i++) {
            if (ar1[i] == ar2[0]) {
                int k = i;
                for (int j = 0; j < ar2.length; j++, k++) {
                    if (k > ar1.length - 1) {
                        break begin;
                    }
                    if (ar2[j] != ar1[k]) {
                        continue begin;
                    }
                }
                isContained = true;
                break begin;
            }
        }
        return isContained;
    }
}
