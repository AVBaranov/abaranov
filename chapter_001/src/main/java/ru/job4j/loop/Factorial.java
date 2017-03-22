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
	if (n == 0) {
	return 1;
	}
        int x = n * calc(n - 1);
        return x;
	}
}