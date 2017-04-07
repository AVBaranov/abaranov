package ru.job4j.figure;

/**
 * class Square.
 */
public class Square implements Shape{
    public String pic(int height) {
        StringBuffer str = new StringBuffer();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < height; j++) {
                str.append("* ");
            }
            str.append("\n");
        }
        String string=str.toString();
        return string;
    }
}
