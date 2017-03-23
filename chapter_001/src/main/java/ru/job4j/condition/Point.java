package ru.job4j.condition;
/**
* @author Andrey Baranov
* @version $Id$
* @since 0.1
*/
public class Point {
/**
* field x.
*/
private int x;
/**
* field y.
*/
private int y;
/**
* constructor initializes private fields of class.
*@param x initializes field x
*@param y initializes field y
*/
public Point(int x, int y) {
this.x = x;
this.y = y;
}
/**
* method returns x.
*@return x
*/
public int getX() {
	return this.x;
	}
/**
* method returns y.
*@return y
*/
public int getY() {
	return this.y;
	}
/**
* method returns true or false.
*@param a - first operand
*@param b - second operand
*@return true if point belongs to function and false otherwise
*/
public boolean is(int a, int b) {
	return (getY() == a * getX() + b) ? true : false;
	}
}