package ru.job4j.max;
/**
* @author Andrey Baranov
* @version $Id$
* @since 0.1
*/
public class Max {

/**
* method returns max number.
*@param first - first operand
*@param second - second operand
*@return max
*/
public int max(int first, int second) {
	return first > second ? first : second;
	}
/**
* method returns max number.
*@param first - first operand
*@param second - second operand
*@param third - third operand
*@return max
*/
public int max(int first, int second, int third) {
	return max(max(first, second), max(first, third));
	}

}