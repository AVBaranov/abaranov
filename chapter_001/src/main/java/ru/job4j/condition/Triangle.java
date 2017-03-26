package ru.job4j.condition;
/**
* @author Andrey Baranov
* @version $Id$
* @since 0.1
*/
public class Triangle {
/**
* field a.
*/
private Point a;
/**
* field b.
*/
private Point b;
/**
* field c.
*/
private Point c;
/**
* constructor initializes private fields of class.
*@param x initializes field a
*@param y initializes field b
*@param z initializes field c
*/
public Triangle(Point x, Point y, Point z) {
        this.a = x;
        this.b = y;
        this.c = z;
}
/**
* returns length of side.
*@param a - first peak
*@param b - second peak

*@return length
*/
public double getlength(Point a, Point b) {
	return Math.sqrt(Mat.sqr(a.getX() - b.getX(), 2) + Mat.sqr(a.getY() - b.getY(), 2));
}
/**
* returns square.
*@return square
*/
public double area() {
        if ((a.getX() != b.getX() || a.getY() != b.getY()) && (b.getX() != c.getX() || b.getY() != c.getY()) && (a.getX() != c.getX() || a.getY() != c.getY())) {
            double p = (getlength(a, b) + getlength(b, c) + getlength(a, c)) / 2;
            double s = Math.sqrt(p * (p - getlength(a, b)) * (p - getlength(a, c)) * (p - getlength(b, c)));
            return s;
        }
        return 0;
    }
}