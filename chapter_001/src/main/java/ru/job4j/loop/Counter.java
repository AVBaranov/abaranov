package ru.job4j.loop;
/**
* @author Andrey Baranov
* @version $Id$
* @since 0.1
*/
public class Counter {

/**
* method returns sum of even numbers.
*@param start - first operand
*@param finish - second operand
*@return sum
*/
public int add(int start, int finish) {
	int sum = 0;
	for (int i = start; i <= finish; i++) {
	if (i % 2 == 0) {
	sum += i;
	}
	}
	return sum;
	}

}