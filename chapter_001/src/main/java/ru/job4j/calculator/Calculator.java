package ru.job4j.calculator;
/**
* @author Andrey Baranov
* @version $Id$
* @since 0.1
*/
public class Calculator {
/**
* �������� ���� ������.
*/
private double result;
/**
* ����� ������� ����� 2-� �������� � ��������� ������.
*@param first - 1-� �������
*@param second - 2-� �������
*/
public void add(double first, double second) {
this.result = first + second;
	}
/**
* ����� ������� �������� 2-� �������� � ��������� ������.
*@param first - 1-� �������
*@param second - 2-� �������
*/
public void substruct(double first, double second) {
this.result = first - second;
	}
/**
* ����� ������� ������������ 2-� �������� ���� � ��������� ������.
*@param first - 1-� �������
*@param second - 2-� �������
*/
public void multiple(double first, double second) {
this.result = first * second;
	}
/**
* ����� ������� ������� 2-� �������� ���� � ��������� ������.
*@param first - 1-� �������
*@param second - 2-� �������
*/
public void div(double first, double second) {
this.result = first / second;
	}
/**
* ����� ���������� �������� ���� result.
*@return result
*/
public double getResult() {
return this.result;
	}
}