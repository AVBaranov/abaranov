package ru.job4j.loop;
/**
* @author Andrey Baranov
* @version $Id$
* @since 0.1
*/
public class Factorial {

/**
* method calculates factorial of a number.
*@param n - argument of a method
*@return factorial
*/
public int calc(int n) {
	int a = 1;
        for (int i = 1; i <= n; i++) {
	a *= i;
	}
        return a;
	}
}