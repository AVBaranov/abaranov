package ru.job4j.calculator;

import org.junit.Test;
//import java.io.ByteArrayOutputStream;
//import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
* Test.
* @author Andrey Baranov
* @version $Id$
* @since 0.1
*/
public class CalculatorTest {
/**
* Test add.
*/
@Test
public void whenAddOnePlusOneThenTwo() {
        Calculator calc = new Calculator();
        calc.add(1D, 1D);
        double result = calc.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }
/**
* Test add.
*/
@Test
public void whenSubstructTenMinusFiveThenFive() {
        Calculator calc = new Calculator();
        calc.substruct(10D, 5D);
        double result = calc.getResult();
        double expected = 5D;
        assertThat(result, is(expected));
    }
/**
* Test add.
*/
@Test
public void whenDivTenDivideTwoThenFive() {
        Calculator calc = new Calculator();
        calc.div(10D, 2D);
        double result = calc.getResult();
        double expected = 5D;
        assertThat(result, is(expected));
    }
/**
* Test add.
*/
@Test
public void whenMultipleTenMultiplyTwoThenTwenty() {
        Calculator calc = new Calculator();
        calc.multiple(10D, 2D);
        double result = calc.getResult();
        double expected = 20D;
        assertThat(result, is(expected));
    }
}