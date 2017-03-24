package ru.job4j.condition;

import org.junit.Test;
//import java.io.ByteArrayOutputStream;
//import java.io.PrintStream;
//import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.number.IsCloseTo.closeTo;
/**
* Test.
* @author Andrey Baranov
* @version $Id$
* @since 0.1
*/
public class TriangleTest {
/**
* Test.
*/
@Test
public void whenCoordinatesAreFiveAndFifteenForFirstTopTwoAndElevenForSecondTopEightAndElevenForThirdTopThenReturnTwelve() {
	Point ob1 = new Point(5, 15);
        Point ob2 = new Point(2, 11);
        Point ob3 = new Point(8, 11);
	Triangle obj = new Triangle(ob1, ob2, ob3);
	double reality = obj.area();
	double expectation = 12.01;
        assertThat(reality, closeTo(expectation, 0.01));
    }

}