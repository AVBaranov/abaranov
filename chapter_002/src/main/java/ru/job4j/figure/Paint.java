package ru.job4j.figure;

/**
 *  Class.
 */
public class Paint {
    /**
     *  object of interface.
     */
    private Shape shape;
    /**
     *  method returns selected figure.
     *  @param shape - interface(selected figure)
     *  @return figure
     */
    public String draw(Shape shape) {
        return (shape.pic(3));
    }
}
