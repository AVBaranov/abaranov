package ru.job4j.figure;

import ru.job4j.figure.Shape;

/**
 * class Triangle.
 */
public class Triangle implements Shape {
    public String pic(int height) {
        StringBuffer str = new StringBuffer();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < height - i - 1; j++) {
                str.append(" ");
            }
            for (int j = 0; j < 2 * i + 1; j++) {
                str.append("*");
            }
            str.append("\n");
        }
        String string=str.toString();
        return string;
    }

}
