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
*@param x1 - first coordinate of first peak
*@param x2 - second coordinate of first peak
*@param y1 - first coordinate of second peak
*@param y2 - second coordinate of second peak
*@return length
*/
public double getlength(int x1, int x2, int y1, int y2) {
	return Math.sqrt(Mat.sqr(x1 - x2, 2) + Mat.sqr(y1 - y2, 2));
}
/**
* returns square.
*@return square
*/
public double area() {
        if ((a.getX() != b.getX() || a.getY() != b.getY()) && (b.getX() != c.getX() || b.getY() != c.getY()) && (a.getX() != c.getX() || a.getY() != c.getY())) {
            double p = (getlength(a.getX(), b.getX(), a.getY(), b.getY()) + getlength(b.getX(), c.getX(), b.getY(), c.getY()) + getlength(a.getX(), c.getX(), a.getY(), c.getY())) / 2;
            double s = Math.sqrt(p * (p - getlength(a.getX(), b.getX(), a.getY(), b.getY())) * (p - getlength(a.getX(), c.getX(), a.getY(), c.getY())) * (p - getlength(b.getX(), c.getX(), b.getY(), c.getY())));
            return s;
        }
        return 0;
    }
}