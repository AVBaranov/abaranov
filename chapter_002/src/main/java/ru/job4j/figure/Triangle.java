package ru.job4j.figure;

/**
 * class Triangle.
 */
public class Triangle implements Shape {
    /**
     * method build triangle.
     * @param height - height
     * @return triangle
     */
    public String pic(int height) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < height - i - 1; j++) {
                str.append(" ");
            }
            for (int j = 0; j < 2 * i + 1; j++) {
                str.append("*");
            }
            str.append("\n");
        }
        String string = str.toString();
        return string;
    }

}
