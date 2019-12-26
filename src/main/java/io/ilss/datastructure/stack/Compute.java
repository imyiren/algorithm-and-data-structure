package io.ilss.datastructure.stack;

import java.util.Scanner;

/**
 * @author feng
 */
public class Compute {
    public static void main(String[] args) {
        Stack numStack = new LinkedStack();
        Stack operatorStack = new LinkedStack();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("请输入运算式");
            String expr = scanner.next();
            System.out.println("expr: " + expr + ", size: " + expr.length());

            for (int i = 0; i < expr.length(); i++) {
                char temp = expr.charAt(i);
                // 异常判断
                // 如果是数字直接放进去
                if (isOperator(temp)) {
                    // 为空直接加进去然后介绍本次循环
                    if (operatorStack.isEmpty()) {
                        operatorStack.push(temp);
                        continue;
                    }
                    // 如果不为空就需要处理了
                    int top = operatorStack.peek();
                    // 如果大于栈顶的优先级 就直接push进去
                    if (priority(temp) > priority(top)) {
                        operatorStack.push(temp);
                        continue;
                    }
                    // 处理优先级小于的情况
                    int num2 = numStack.pop();
                    int num1 = numStack.pop();
                    int result = calculator(num1, num2, operatorStack.pop());
                    numStack.push(result);
                    operatorStack.push(temp);
                } else if (temp >= '0' && temp <= '9') {
                    if (numStack.isEmpty() || i == 0) {
                        numStack.push(temp - '0');
                    } else {
                        int newNum = temp - '0';
                        if (isNum(expr.charAt(i - 1))) {
                            int oldNum = numStack.pop();
                            numStack.push(oldNum * 10 + newNum);
                        } else {
                            numStack.push(newNum);
                        }
                    }
                } else {
                    System.out.println("输入有误");
                    break;
                }
                System.out.print("====> numStack: ");
                numStack.list();
                System.out.print("====> operatorStack: ");
                operatorStack.list();
            }
            // 最后一个数字 计算出结果
            while (true) {
                if (operatorStack.isEmpty()) {
                    System.out.println("expr: " + expr + ", result: " + numStack.peek());
                    break;
                }
                int num2 = numStack.pop();
                int num1 = numStack.pop();
                int result = calculator(num1, num2, operatorStack.pop());
                numStack.push(result);
            }
        }

        // 考虑小括号的情况。
    }

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
                break;
        }
        return result;
    }
}
