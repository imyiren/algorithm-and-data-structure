package com.imyiren.datastructure.stack;

/**
 * @author yiren
 */
public class CalculatorUtils {

    public static int priority(int operator) {
        if (operator == '*' || operator == '/') {
            return 1;
        }
        if (operator == '+' || operator == '-') {
            return 0;
        }
        return -1;
    }

    public static boolean isOperator(char value) {
        return value == '+' || value == '-' || value == '*' || value == '/';
    }

    public static boolean isNum(char value) {
        return value >= '0' && value <= '9';
    }

    public static int calculator(int num1, int num2, int operator) {
        int result = 0;
        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
                break;
            default:
                System.out.println("符号不支持: " + operator);
                break;
        }
        return result;
    }
}
