package ru.job4j.figure;

import sun.security.provider.SHA;

/**
 *  Class.
 */
public class Paint {
    private Shape shape;
    /*Paint(Shape shape) {
        this.shape = shape;
    }*/
    public void draw(Shape shape) {
        System.out.println((shape.pic(5)));
    }
}
