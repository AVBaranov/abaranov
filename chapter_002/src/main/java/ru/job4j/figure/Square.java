package ru.job4j.figure;

/**
 * class Square.
 */
public class Square implements Shape {
    /**
     * method build square.
     * @param height - height
     * @return square
     */
    public String pic(int height) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < height; j++) {
                str.append("* ");
            }
            str.append("\n");
        }
        String string = str.toString();
        return string;
    }
}
