package ru.job4j.calculator;
/**
* @author Andrey Baranov
* @version $Id$
* @since 0.1
*/
public class Calculator {
/**
* закрытое поле класса.
*/
private double result;
/**
* метод считает сумму 2-х значений с плавающей точкой.
*@param first - 1-й операнд
*@param second - 2-й операнд
*/
public void add(double first, double second) {
this.result = first + second;
	}
/**
* метод считает разность 2-х значений с плавающей точкой.
*@param first - 1-й операнд
*@param second - 2-й операнд
*/
public void substruct(double first, double second) {
this.result = first - second;
	}
/**
* метод считает произведение 2-х значений типа с плавающей точкой.
*@param first - 1-й операнд
*@param second - 2-й операнд
*/
public void multiple(double first, double second) {
this.result = first * second;
	}
/**
* метод считает частное 2-х значений типа с плавающей точкой.
*@param first - 1-й операнд
*@param second - 2-й операнд
*/
public void div(double first, double second) {
this.result = first / second;
	}
/**
* метод возвращает значение поля result.
*@return result
*/
public double getResult() {
return this.result;
	}
}