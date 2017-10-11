package ru.job4j.additional_test;

import java.util.HashMap;
import java.util.Map;

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
        /*char[] ar1 = word1.toCharArray();
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
        return isContained;*/
        Map<Character, Integer> map = new HashMap<>();
        char[] array = word1.toCharArray();
        char[] array2 = word2.toCharArray();
        int count = 0;
        boolean b = true;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i] == array[j]) {
                    count++;
                }
            }
            map.put(array[i], count);
            count = 0;
        }

        for (int i = 0; i < array2.length; i++) {
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                if (array2[i] == entry.getKey()) {
                    map.put(entry.getKey(), entry.getValue() - 1);
                    break;
                }
            }
        }

        if (array.length != array2.length) {
            b = false;
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() != 0) {
                b = false;
                break;
            }
        }
        return b;
    }
}
