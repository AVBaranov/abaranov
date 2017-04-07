package ru.job4j.figure;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 */
public class PaintTest {
    /**
     * Test add item.
     */
    @Test
    public void whenUseInterfaceForClassTriangleThenReturnTriangle() {
        Paint paint = new Paint();
        String excpectation = "  *\n ***\n*****\n";

        assertThat(excpectation, is(paint.draw(new Triangle())));
    }
    /**
     * Test add item.
     */
    @Test
    public void whenUseInterfaceForClassSquareThenReturnSquare() {
        Paint paint = new Paint();
        String excpectation = "* * * \n* * * \n* * * \n";

        assertThat(excpectation, is(paint.draw(new Square())));
    }
}
